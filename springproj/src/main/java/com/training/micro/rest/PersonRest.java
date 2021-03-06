package com.training.micro.rest;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.micro.services.PersonService;

@RestController
@RequestMapping("/api/v1/person/provision")
// @RequestScope
// @SessionScope
// @ApplicationScope
@Validated
public class PersonRest {

    @Autowired
    private PersonService ps;

    @PostMapping("/add")
    public String add(@Validated @RequestBody final Person person) {
        if ((person.getName() == null)
            || person.getName()
                     .isEmpty()) {
            throw new IllegalArgumentException("name null olamaz");
        }
        this.ps.add(person);
        return "Added : " + person;
    }


    @GetMapping("/suspend")
    public String suspend(@RequestParam("user") final String username) {
        this.ps.suspend(username);
        return "User  : " + username + " suspended";
    }

    @PostMapping("/change")
    public Person change(@NotNull @RequestBody final Person person) {
        return person;
    }

    @GetMapping("/query/all")
    public List<Person> getAll() {
        return null;
    }

    @PostMapping("/op")
    public ResponseEntity<Person> op(@RequestBody final Person person) {
        return ResponseEntity.status(202)
                             .header("test",
                                     "osman")
                             .body(person);
    }


}
