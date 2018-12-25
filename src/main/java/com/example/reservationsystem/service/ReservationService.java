package com.example.reservationsystem.service;

import com.example.reservationsystem.entity.Reservation;

import java.util.List;

public interface ReservationService {

    List<Reservation> getAllReservations();

    List<Reservation> getAllReservationsForOrganization(long organizationId);

    Reservation addReservation(Reservation reservation);

    Reservation updateReservation(Reservation reservation);

    void remvoeReservation(long id);
}
