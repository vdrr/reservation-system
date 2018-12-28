package com.example.reservationsystem.repository;

import com.example.reservationsystem.entity.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    List<Reservation> findAllByRoomName(String roomName);

    int countAllByRoomNameEqualsAndStartDateIsBeforeAndEndDateIsAfter(String roomName, Date endDate, Date startDate);
}
