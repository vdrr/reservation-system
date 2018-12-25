package com.example.reservationsystem.service.impl;

import com.example.reservationsystem.entity.ConferenceRoom;
import com.example.reservationsystem.repository.ConferenceRoomRepository;
import com.example.reservationsystem.service.ConferenceRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceRoomServiceImpl implements ConferenceRoomService {

    private final ConferenceRoomRepository conferenceRoomRepository;

    @Autowired
    public ConferenceRoomServiceImpl(ConferenceRoomRepository conferenceRoomRepository) {
        this.conferenceRoomRepository = conferenceRoomRepository;
    }

    @Override
    public List<ConferenceRoom> getAllRooms(Long organizationId) {
        return null;
    }

    @Override
    public List<ConferenceRoom> getAllAvailableRooms(Long organizationId) {
        return null;
    }

    @Override
    public ConferenceRoom getRoomById(long id) {
        return null;
    }

    @Override
    public ConferenceRoom getRoomByName(String name) {
        return null;
    }

    @Override
    public ConferenceRoom updateRoom(ConferenceRoom room) {
        return null;
    }

    @Override
    public ConferenceRoom addRoom(ConferenceRoom room, long organizationId) {
        return null;
    }

    @Override
    public void removeRoom(long id) {

    }
}
