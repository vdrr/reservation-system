package com.example.reservationsystem.service.impl;

import com.example.reservationsystem.entity.Organization;
import com.example.reservationsystem.exception.BadRequestException;
import com.example.reservationsystem.exception.ResourceNotFoundException;
import com.example.reservationsystem.repository.OrganizationRepository;
import com.example.reservationsystem.service.OrganizationService;
import com.example.reservationsystem.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validation;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public List<Organization> getAllOrganizations() {
        return (List<Organization>) organizationRepository.findAll();
    }

    @Override
    public Organization getOrganizationById(long id) {
        Optional<Organization> organization = organizationRepository.findById(id);

        if (organization.isPresent()) {
            return organization.get();
        }

        throw new ResourceNotFoundException("Organization with id=" + id + " does not exist.");
    }

    @Override
    public Organization getOrganizationByName(String name) {
        Optional<Organization> organization = organizationRepository.findByNameEquals(name);

        if (organization.isPresent()) {
            return organization.get();
        }

        throw new ResourceNotFoundException("Organization with name=" + name + " does not exist");
    }

    @Override
    public void removeOrganization(long id) {
        organizationRepository.deleteById(id);
    }

    @Override
    public Organization addOrganization(Organization organization) {
        if (organization.getName() == null || !ValidationUtils.validateName(organization.getName())) {
            throw new BadRequestException("Invalid organization name");
        }

        if (organizationRepository.findByNameEquals(organization.getName()).isPresent()) {
            throw new BadRequestException("Organization with given name already exists");
        }

        organization.setConferenceRooms(null);
        organization.setId(null);

        return organizationRepository.save(organization);
    }

    @Override
    public Organization updateOrganization(Organization organization) {

        if (organization.getId() == null) {
            throw new BadRequestException("Invalid organization id");
        }

        Optional<Organization> optionalOrganization = organizationRepository.findById(organization.getId());

        if (!optionalOrganization.isPresent()) {
            throw new BadRequestException("Organization with id=" + organization.getId() + " does not exist");
        }

        if (!ValidationUtils.validateName(organization.getName())) {
            throw new BadRequestException("Invalid organization name");
        }

        optionalOrganization.get().setName(organization.getName());
        return organizationRepository.save(optionalOrganization.get());
    }
}
