package org.jpa.practico3.controller;

import org.jpa.practico3.models.Persona;
import org.jpa.practico3.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonaController {

    @Qualifier("personaRepository")
    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping("/personas")
    public Iterable<Persona> getPersonas() {
        return personaRepository.findAll();
    }

    @GetMapping("personas/nombre/{nombre}")
    public Iterable<Persona> getPersonasPorNombre(@PathVariable String nombre) {
        return personaRepository.findAllByNombre(nombre);
    }

    @PostMapping("/persona")
    public Persona addPersona(@RequestBody Persona persona) {
        return personaRepository.save(persona);
    }

    @DeleteMapping("personas/{id}")
    public void deletePersona(@PathVariable Long id) {
        personaRepository.deleteById(id);
    }

}
