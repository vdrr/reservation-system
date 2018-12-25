package com.example.reservationsystem.controller;

import com.example.reservationsystem.entity.Organization;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("organization")
public class OrganizationController {

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Organization getOrganization(@PathVariable long id) {
        return null;
    }

    @RequestMapping(path = "/byname/{name}", method = RequestMethod.GET)
    public Organization getOrganizationByName(@PathVariable String name) {
        return null;
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public Organization addOrganization(@RequestBody Organization organization) {
        return null;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void removeOrganization(@PathVariable long id) {

    }

    @RequestMapping(path = "/", method = RequestMethod.PUT)
    public Organization updateOrganization(@RequestBody Organization organization) {
        return null;
    }
}
