package ru.vichukano.webflux.server.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@RestController
public class PersonController {
    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/person")
    public Mono<Long> addPerson(@RequestBody Person person) {
        log.info("Receive person: {}", person);
        return Mono.fromCallable(() -> repository.save(person))
            .map(Person::getId)
            .doOnNext(id -> log.info("Successfully process person with id: {}", id));
    }
}
