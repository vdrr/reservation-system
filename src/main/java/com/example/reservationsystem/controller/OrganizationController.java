package com.example.reservationsystem.controller;

import com.example.reservationsystem.entity.Organization;
import com.example.reservationsystem.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("organization")
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Organization getOrganization(@PathVariable long id) {
        return organizationService.getOrganizationById(id);
    }

    @RequestMapping(path = "/byname/{name}", method = RequestMethod.GET)
    public Organization getOrganizationByName(@PathVariable String name) {
        return organizationService.getOrganizationByName(name);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<Organization> getAllOrganizations() {
        return organizationService.getAllOrganizations();
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public Organization addOrganization(@RequestBody Organization organization) {
        return organizationService.addOrganization(organization);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void removeOrganization(@PathVariable long id) {
        organizationService.removeOrganization(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Organization updateOrganization(@PathVariable long id, @RequestBody Organization organization) {
        organization.setId(id);
        return organizationService.updateOrganization(organization);
    }
}
