package com.example.reservationsystem.repository;

import com.example.reservationsystem.entity.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Long> {

    Optional<Organization> findByNameEquals(String name);
}
