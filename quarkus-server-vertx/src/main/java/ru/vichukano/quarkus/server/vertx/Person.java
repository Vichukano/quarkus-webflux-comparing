package ru.vichukano.quarkus.server.vertx;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person extends PanacheEntity {
    @Column(name = "name")
    String name;

    @Override
    public String toString() {
        return "Person[id = " + id + " , name = " + name + "]";
    }
}
