package com.example.reservationsystem.controller;

import com.example.reservationsystem.entity.ConferenceRoom;
import com.example.reservationsystem.service.ConferenceRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConferenceRoomController {

    private final ConferenceRoomService conferenceRoomService;

    @Autowired
    public ConferenceRoomController(ConferenceRoomService conferenceRoomService) {
        this.conferenceRoomService = conferenceRoomService;
    }

    @RequestMapping(path = "/rooms", method = RequestMethod.GET)
    public List<ConferenceRoom> getAllRooms() {
        return conferenceRoomService.getAllRooms(null);
    }

    @RequestMapping(path = "/rooms/byorganization/{id}", method = RequestMethod.GET)
    public List<ConferenceRoom> getAllRoomsByOrganization(@PathVariable Long id) {
        return conferenceRoomService.getAllRooms(id);
    }

    @RequestMapping(path = "/rooms/available", method = RequestMethod.GET)
    public List<ConferenceRoom> getAllAvailableRooms() {
        return conferenceRoomService.getAllAvailableRooms(null);
    }

    @RequestMapping(path = "/rooms/available/byorganization/{id}", method = RequestMethod.GET)
    public List<ConferenceRoom> getAllAvailableRoomsByOrganization(@PathVariable Long id) {
        return conferenceRoomService.getAllAvailableRooms(id);
    }

    @RequestMapping(path = "/room/{id}", method = RequestMethod.GET)
    public ConferenceRoom getRoom(@PathVariable Long id) {
        return conferenceRoomService.getRoomById(id);
    }

    @RequestMapping(path = "/room/byname/{name}", method = RequestMethod.GET)
    public ConferenceRoom getRoomByName(@PathVariable String name) {
        return conferenceRoomService.getRoomByName(name);
    }

    @RequestMapping(path = "/room/{id}",method = RequestMethod.DELETE)
    public void removeRoom(@PathVariable Long id) {
        conferenceRoomService.removeRoom(id);
    }

    @RequestMapping(path = "/room/{id}", method = RequestMethod.PUT)
    public ConferenceRoom updateRoom(@PathVariable Long id, @RequestBody ConferenceRoom conferenceRoom) {
        conferenceRoom.setId(id);
        return conferenceRoomService.updateRoom(conferenceRoom);
    }

    @RequestMapping(path = "/room/organization/{organizationId}", method = RequestMethod.POST)
    public ConferenceRoom addRoom(@PathVariable Long organizationId, @RequestBody ConferenceRoom conferenceRoom) {
        return conferenceRoomService.addRoom(conferenceRoom, organizationId);
    }
}
