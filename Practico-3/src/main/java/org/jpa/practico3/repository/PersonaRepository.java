package org.jpa.practico3.repository;

import org.jpa.practico3.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

    @Query("SELECT t FROM Persona t where t.nombre = :nombre")
    public List<Persona> findAllByNombre(String nombre);

    @Query("SELECT t FROM Persona t where t.domicilio = :domicilio")
    public List<Persona> findAllByDomicilio(String domicilio);
}
