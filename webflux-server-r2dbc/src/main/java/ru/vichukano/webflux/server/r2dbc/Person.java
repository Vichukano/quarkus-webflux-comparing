package ru.vichukano.webflux.server.r2dbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("person")
public class Person {
    @Id
    private Long id;
    private String name;
}
