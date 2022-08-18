package ru.vichukano.webflux.server.r2dbc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class PersonController {
    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/person")
    public Mono<Long> addPerson(@RequestBody Person person) {
        log.debug("Receive request: {}", person);
        return repository.save(person)
            .map(Person::getId)
            .doOnNext(id -> log.debug("Successfully save with id: {}", id));
    }

}
