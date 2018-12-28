package com.example.reservationsystem.service.impl;

import com.example.reservationsystem.controller.dto.ReservationDto;
import com.example.reservationsystem.entity.Reservation;
import com.example.reservationsystem.exception.BadRequestException;
import com.example.reservationsystem.exception.ResourceNotFoundException;
import com.example.reservationsystem.repository.ConferenceRoomRepository;
import com.example.reservationsystem.repository.ReservationRepository;
import com.example.reservationsystem.service.ReservationService;
import com.example.reservationsystem.utils.DateUtils;
import com.example.reservationsystem.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ConferenceRoomRepository conferenceRoomRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository, ConferenceRoomRepository conferenceRoomRepository) {
        this.reservationRepository = reservationRepository;
        this.conferenceRoomRepository = conferenceRoomRepository;
    }

    @Override
    public Reservation getReservationById(long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);

        if (!reservation.isPresent()) {
            throw new ResourceNotFoundException("Reservation with id=" + id + " not found");
        }

        return reservation.get();
    }

    @Override
    public List<Reservation> getAllReservations() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public List<Reservation> getAllReservationsForRoom(String roomName) {
        return reservationRepository.findAllByRoomName(roomName);
    }

    @Override
    public Reservation addReservation(ReservationDto reservationDto) {
        Reservation reservation = new Reservation();
        fillReservation(reservation, reservationDto);

        if (!checkIfRoomExist(reservation.getRoomName())) {
            throw new BadRequestException("Conference room with name=" + reservation.getRoomName() + " does not exist");
        }

        if (reservationRepository.countAllByRoomNameEqualsAndStartDateIsBeforeAndEndDateIsAfter(
                reservation.getRoomName(), reservation.getEndDate(), reservation.getStartDate()) > 0) {
            throw new BadRequestException("Conference room '" + reservation.getRoomName() + "' is already reserved for given date");
        }

        return reservationRepository.save(reservation);
    }

    @Override
    public void removeReservation(long id) {
        reservationRepository.deleteById(id);
    }

    private void fillReservation(Reservation reservation, ReservationDto reservationDto) {
        if (!ValidationUtils.checkReservationRequiredFieldsNotNull(reservationDto)) {
            throw new BadRequestException("All required fields must be set");
        }

        if (!ValidationUtils.validateName(reservationDto.getClientId())) {
            throw new BadRequestException("Client id invalid");
        }

        reservation.setStartDate(DateUtils.parseDate(reservationDto.getStartDate()));
        reservation.setEndDate(DateUtils.parseDate(reservationDto.getEndDate()));

        if (reservation.getStartDate() == null || reservation.getEndDate() == null) {
            throw new BadRequestException("startDate and endDate must be formatted [dd/MM/yyyy HH:mm]");
        }

        reservation.setRoomName(reservationDto.getRoomName());
        reservation.setClientId(reservationDto.getClientId());
    }

    private boolean checkIfRoomExist(String roomName) {
        return conferenceRoomRepository.findByNameEquals(roomName).isPresent();
    }
}
