package ru.vichukano.webflux.server.r2dbc;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends R2dbcRepository<Person, Long> {
}
