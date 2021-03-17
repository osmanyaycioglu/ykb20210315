package com.training.micro.rest;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.micro.services.PersonService;

@RestController
@RequestMapping("/api/v2/person/provision")
@Validated
public class PersonRest2 {

    @Autowired
    private PersonService ps;

    @PutMapping
    public String add(@Validated @RequestBody final Person person) {
        if ((person.getName() == null)
            || person.getName()
                     .isEmpty()) {
            throw new IllegalArgumentException("name null olamaz");
        }
        this.ps.add(person);
        return "Added : " + person;
    }

    @DeleteMapping
    public String suspend(@RequestParam("user") final String username) {
        this.ps.suspend(username);
        return "User  : " + username + " suspended";
    }

    @PatchMapping
    public Person change(@NotNull @RequestBody final Person person) {
        return person;
    }

    @PostMapping("/op")
    public ResponseEntity<Person> op(@RequestBody final Person person) {
        return ResponseEntity.status(202)
                             .header("test",
                                     "osman")
                             .body(person);
    }


}
