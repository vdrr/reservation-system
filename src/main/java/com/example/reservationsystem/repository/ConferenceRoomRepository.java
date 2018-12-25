package com.example.reservationsystem.repository;

import com.example.reservationsystem.entity.ConferenceRoom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConferenceRoomRepository extends CrudRepository<ConferenceRoom, Long> {
}
