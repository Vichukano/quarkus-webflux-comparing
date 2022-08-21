package ru.vichukano.quarkus.server.vertx;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.logging.Logger;

@Path("/person")
@ApplicationScoped
@Consumes("application/json")
public class PersonResource {
    private static final Logger LOGGER = Logger.getLogger(PersonResource.class.getName());

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<Long> person(Person person) {
        LOGGER.info("Receive request: " + person);
        return Panache.withTransaction(person::persist)
            .replaceWith(person.id)
            .onItem()
            .invoke(id -> LOGGER.info("Process person with id: " + id));
    }

}
