package ru.vichukano.webmvc.server.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PersonController {
    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/person")
    public Long addPerson(@RequestBody Person person) {
        log.info("Receive request: {}", person);
        Person saved = repository.save(person);
        log.info("Successfully save person with id: {}", saved.id);
        return saved.id;
    }
}
