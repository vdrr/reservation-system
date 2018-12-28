package com.example.reservationsystem.service.impl;

import com.example.reservationsystem.entity.ConferenceRoom;
import com.example.reservationsystem.entity.Organization;
import com.example.reservationsystem.exception.BadRequestException;
import com.example.reservationsystem.exception.ResourceNotFoundException;
import com.example.reservationsystem.repository.ConferenceRoomRepository;
import com.example.reservationsystem.repository.OrganizationRepository;
import com.example.reservationsystem.service.ConferenceRoomService;
import com.example.reservationsystem.utils.ValidationUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConferenceRoomServiceImpl implements ConferenceRoomService {

    private final ConferenceRoomRepository conferenceRoomRepository;
    private final OrganizationRepository organizationRepository;

    @Autowired
    public ConferenceRoomServiceImpl(ConferenceRoomRepository conferenceRoomRepository, OrganizationRepository organizationRepository) {
        this.conferenceRoomRepository = conferenceRoomRepository;
        this.organizationRepository = organizationRepository;
    }

    @Override
    public List<ConferenceRoom> getAllRooms(Long organizationId) {
        if (organizationId == null) {
            return (List<ConferenceRoom>) conferenceRoomRepository.findAll();
        }
        return conferenceRoomRepository.findAllByOrganizationId(organizationId);
    }

    @Override
    public List<ConferenceRoom> getAllAvailableRooms(Long organizationId) {
        if (organizationId == null) {
            return conferenceRoomRepository.findAllByAvailableIsTrue();
        }
        return conferenceRoomRepository.findAllByAvailableIsTrueAndOrganizationId(organizationId);
    }

    @Override
    public ConferenceRoom getRoomById(long id) {
        Optional<ConferenceRoom> room = conferenceRoomRepository.findById(id);

        if (room.isPresent()) {
            return room.get();
        }

        throw new ResourceNotFoundException("Conference room with id=" + id + " doest not exist");
    }

    @Override
    public ConferenceRoom getRoomByName(String name) {
        Optional<ConferenceRoom> room = conferenceRoomRepository.findByNameEquals(name);

        if (room.isPresent()) {
            return room.get();
        }

        throw new ResourceNotFoundException("Conference room with name=" + name + " does not exist");
    }

    @Override
    public ConferenceRoom updateRoom(ConferenceRoom room) {
        if (room.getId() == null) {
            throw new BadRequestException("Conference room id must be set");
        }

        Optional<ConferenceRoom> oldRoom = conferenceRoomRepository.findById(room.getId());

        if (!oldRoom.isPresent()) {
            throw new ResourceNotFoundException("Conference room with id=" + room.getId() + " not found");
        }

        if (!ValidationUtils.checkRoomRequiredFieldsNotNull(room)) {
            throw new BadRequestException("Required fields must not be null");
        }

        if (!ValidationUtils.validateName(room.getName())) {
            throw new BadRequestException("Invalid conference room name");
        }

        if (!ValidationUtils.roomFieldsMatchRequirements(room)) {
            throw new BadRequestException("Fields doesn't match requirements");
        }

        if (!room.getName().equals(oldRoom.get().getName()) &&
                conferenceRoomRepository.findByNameEquals(room.getName()).isPresent()) {
            throw new BadRequestException("Conference room with name=" + room.getName() + " already exists");
        }

        BeanUtils.copyProperties(room, oldRoom.get(), "organization", "roomEquipment");

        if (room.getRoomEquipment() == null) {
            oldRoom.get().setRoomEquipment(null);
        } else if (oldRoom.get().getRoomEquipment() != null) {
            BeanUtils.copyProperties(room.getRoomEquipment(), oldRoom.get().getRoomEquipment(), "id");
        } else {
            oldRoom.get().setRoomEquipment(room.getRoomEquipment());
        }

        return conferenceRoomRepository.save(oldRoom.get());
    }

    @Override
    public ConferenceRoom addRoom(ConferenceRoom room, long organizationId) {
        if (!ValidationUtils.checkRoomRequiredFieldsNotNull(room)) {
            throw new BadRequestException("Required fields must not be null");
        }

        if (!ValidationUtils.validateName(room.getName())) {
            throw new BadRequestException("Invalid conference room name");
        }

        if (!ValidationUtils.roomFieldsMatchRequirements(room)) {
            throw new BadRequestException("Fields doesn't match requirements");
        }

        if (conferenceRoomRepository.findByNameEquals(room.getName()).isPresent()) {
            throw new BadRequestException("Conference room with name=" + room.getName() + " already exists");
        }

        Optional<Organization> organization = organizationRepository.findById(organizationId);

        if (!organization.isPresent()) {
            throw new BadRequestException("Organization with id=" + organizationId + " does not exist");
        }

        room.setId(null);

        organization.get().addConferenceRoom(room);
        return conferenceRoomRepository.save(room);
    }

    @Override
    public void removeRoom(long id) {
        conferenceRoomRepository.deleteById(id);
    }
}
