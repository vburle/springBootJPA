/*
 * Copyright (c) 2018. Venkata SN Burle Code.
 */

package com.vburle.burle;

import com.vburle.burle.model.Event;
import com.vburle.burle.model.Group;
import com.vburle.burle.model.GroupRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

@Component
class Initializer implements CommandLineRunner {

    private final GroupRepository repository;

    public Initializer(GroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        Stream.of("Shukran UG", "NewUser UG", "Frequest UG").forEach(name ->
                repository.save(new Group(name))
        );

        Group djug = repository.findByName("Shukran UG");
        Event e = Event.builder().title("Full Stack Reactive")
                .description("Reactive with Spring Boot + React")
                .date(Instant.parse("2018-12-12T18:00:00.000Z"))
                .build();
        djug.setEvents(Collections.singleton(e));
        repository.save(djug);

        repository.findAll().forEach(System.out::println);
    }
}