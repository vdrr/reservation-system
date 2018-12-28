package com.example.reservationsystem.repository;

import com.example.reservationsystem.entity.ConferenceRoom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConferenceRoomRepository extends CrudRepository<ConferenceRoom, Long> {

    List<ConferenceRoom> findAllByOrganizationId(Long organizationId);

    List<ConferenceRoom> findAllByAvailableIsTrue();

    List<ConferenceRoom> findAllByAvailableIsTrueAndOrganizationId(Long organizationId);

    Optional<ConferenceRoom> findByNameEquals(String name);
}
