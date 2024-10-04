package org.jpa.practico3.utils;

import lombok.extern.slf4j.Slf4j;
import org.jpa.practico3.models.Direccion;
import org.jpa.practico3.models.Persona;
import org.jpa.practico3.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(@Qualifier("personaRepository") PersonaRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Persona((int) 1234,"Olivia", 11)));
            log.info("Preloading " + repository.save(new Persona((int) 2345, "Pedro", 19)));
        };
    }
}