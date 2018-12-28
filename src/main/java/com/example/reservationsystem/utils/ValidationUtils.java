package com.example.reservationsystem.utils;

import com.example.reservationsystem.controller.dto.ReservationDto;
import com.example.reservationsystem.entity.ConferenceRoom;
import com.example.reservationsystem.entity.RoomEquipment;
import com.example.reservationsystem.enums.ProjectorInterface;

import java.util.Arrays;

public class ValidationUtils {

    public static boolean validateName(String name) {
        return name.length() >= 2 && name.length() <= 20 && name.trim().length() != 0;
    }

    public static boolean checkRoomRequiredFieldsNotNull(ConferenceRoom room) {
        return room.getName() != null && room.getStandingCount() != null && room.getAvailable() != null &&
                room.getSeatsCount() != null && room.getLevel() != null;
    }

    public static boolean roomFieldsMatchRequirements(ConferenceRoom room) {
        if (room.getIdentifier() != null && !validateName(room.getIdentifier())) {
            return false;
        }

        if (room.getLevel() < 0 || room.getLevel() > 10) {
            return false;
        }

        if (room.getSeatsCount() < 0 || room.getStandingCount() < 0 ||
                (room.getLyingCount() != null && room.getLyingCount() < 0) ||
                (room.getHammockCount() !=  null && room.getHammockCount() < 0)) {
            return false;
        }

        return room.getRoomEquipment() == null || roomEquipmentMatchRequirement(room.getRoomEquipment());
    }

    private static boolean roomEquipmentMatchRequirement(RoomEquipment equipment) {
        if (equipment.isHasPhone()) {
            if (equipment.getInternalNumber() != null && equipment.getInternalNumber() >= 100) {
                return false;
            }

            if (equipment.getExternalNumber() != null && !equipment.getExternalNumber().matches("^\\+\\d+\\s\\d{9}$")) {
                return false;
            }
        }

        if (equipment.getConnectionInterface() != null &&
                Arrays.stream(ProjectorInterface.values()).map(Enum::name)
                        .noneMatch(s -> s.equals(equipment.getConnectionInterface()))) {
            return false;
        }

        return true;
    }

    public static boolean checkReservationRequiredFieldsNotNull(ReservationDto reservationDto) {
        return reservationDto.getClientId() != null && reservationDto.getRoomName() != null &&
                reservationDto.getStartDate() != null && reservationDto.getEndDate() != null;
    }
}
