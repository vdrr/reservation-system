package com.example.reservationsystem.service;

import com.example.reservationsystem.controller.dto.ReservationDto;
import com.example.reservationsystem.entity.Reservation;

import java.util.List;

public interface ReservationService {

    Reservation getReservationById(long id);

    List<Reservation> getAllReservations();

    List<Reservation> getAllReservationsForRoom(String roomName);

    Reservation addReservation(ReservationDto reservation);

    void removeReservation(long id);
}
