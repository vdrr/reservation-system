package com.example.reservationsystem.service;

import com.example.reservationsystem.entity.Organization;

import java.util.List;

public interface OrganizationService {

    List<Organization> getAllOrganizations();

    Organization getOrganizationById(long id);

    Organization getOrganizationByName(String name);

    void removeOrganization(long id);

    Organization addOrganization(Organization organization);

    Organization updateOrganization(Organization organization);
}
