package com.example.reservationsystem.controller;

import com.example.reservationsystem.entity.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<Reservation> getAllReservations() {
        return null;
    }

    @RequestMapping(path = "/reservation", method = RequestMethod.POST)
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return null;
    }

    @RequestMapping(path = "/reservation", method = RequestMethod.PUT)
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return null;
    }

    @RequestMapping(path = "/reservation/{id}", method = RequestMethod.GET)
    public Reservation getReservation(@PathVariable long id) {
        return null;
    }

    @RequestMapping(path = "/reservation/{id}", method = RequestMethod.DELETE)
    public void removeReservation(@PathVariable long id) {

    }
}
