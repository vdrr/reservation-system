package com.example.reservationsystem.service.impl;

import com.example.reservationsystem.entity.Reservation;
import com.example.reservationsystem.repository.ReservationRepository;
import com.example.reservationsystem.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return null;
    }

    @Override
    public List<Reservation> getAllReservationsForOrganization(long organizationId) {
        return null;
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        return null;
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return null;
    }

    @Override
    public void remvoeReservation(long id) {

    }
}
