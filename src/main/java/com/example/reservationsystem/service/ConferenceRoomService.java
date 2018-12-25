package com.example.reservationsystem.service;

import com.example.reservationsystem.entity.ConferenceRoom;

import java.util.List;

public interface ConferenceRoomService {

    List<ConferenceRoom> getAllRooms(Long organizationId);

    List<ConferenceRoom> getAllAvailableRooms(Long organizationId);

    ConferenceRoom getRoomById(long id);

    ConferenceRoom getRoomByName(String name);

    ConferenceRoom updateRoom(ConferenceRoom room);

    ConferenceRoom addRoom(ConferenceRoom room, long organizationId);

    void removeRoom(long id);
}
