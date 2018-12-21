package com.example.reservationsystem.controller;

import com.example.reservationsystem.entity.ConferenceRoom;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConferenceRoomController {

    @RequestMapping(path = "/rooms", method = RequestMethod.GET)
    public List<ConferenceRoom> getAllRooms() {
        return null;
    }

    @RequestMapping(path = "/room/{name}", method = RequestMethod.GET)
    public ConferenceRoom getRoom(@PathVariable String name) {
        return null;
    }

    @RequestMapping(path = "/room/{name}",method = RequestMethod.DELETE)
    public void removeRoom(@PathVariable String name) {

    }

    @RequestMapping(path = "/room", method = RequestMethod.PUT)
    public ConferenceRoom updateRoom(@RequestBody ConferenceRoom conferenceRoom) {
        return null;
    }

    @RequestMapping(path = "/room", method = RequestMethod.POST)
    public ConferenceRoom addRoom(@RequestBody ConferenceRoom conferenceRoom) {
        return null;
    }
}
