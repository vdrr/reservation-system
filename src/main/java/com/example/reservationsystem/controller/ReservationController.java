package com.example.reservationsystem.controller;

import com.example.reservationsystem.controller.dto.ReservationDto;
import com.example.reservationsystem.entity.Reservation;
import com.example.reservationsystem.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @RequestMapping(path = "/reservations/room/{name}", method = RequestMethod.GET)
    public List<Reservation> getAllReservationsForRoom(@PathVariable String name) {
        return reservationService.getAllReservationsForRoom(name);
    }

    @RequestMapping(path = "/reservation", method = RequestMethod.POST)
    public Reservation addReservation(@RequestBody ReservationDto reservation) {
        return reservationService.addReservation(reservation);
    }

    @RequestMapping(path = "/reservation/{id}", method = RequestMethod.GET)
    public Reservation getReservation(@PathVariable long id) {
        return reservationService.getReservationById(id);
    }

    @RequestMapping(path = "/reservation/{id}", method = RequestMethod.DELETE)
    public void removeReservation(@PathVariable long id) {
        reservationService.removeReservation(id);
    }
}
