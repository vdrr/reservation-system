package com.example.reservationsystem.service.impl;

import com.example.reservationsystem.entity.Organization;
import com.example.reservationsystem.repository.OrganizationRepository;
import com.example.reservationsystem.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public List<Organization> getAllOrganizations() {
        return null;
    }

    @Override
    public Organization getOrganizationById(long id) {
        return null;
    }

    @Override
    public Organization getOrganizationByName(String name) {
        return null;
    }

    @Override
    public void removeOrganization(long id) {

    }

    @Override
    public Organization addOrganization(Organization organization) {
        return null;
    }

    @Override
    public Organization updateOrganization(Organization organization) {
        return null;
    }
}
