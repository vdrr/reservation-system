package com.example.reservationsystem.controller;

import com.example.reservationsystem.entity.Organization;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("organization")
public class OrganizationController {

    @RequestMapping(path = "/{name}", method = RequestMethod.GET)
    public Organization getOrganization(@PathVariable String name) {
        return null;
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public Organization addOrganization(@RequestBody Organization organization) {
        return null;
    }

    @RequestMapping(path = "/{name}", method = RequestMethod.DELETE)
    public void removeOrganization(@PathVariable String name) {

    }
}
