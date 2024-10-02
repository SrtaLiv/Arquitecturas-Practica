package org.jpa.practico3.repository;

import org.jpa.practico3.models.Persona;
import org.jpa.practico3.models.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SocioRepository extends JpaRepository<Socio, Long> {

    @Query("SELECT t FROM Socio t where t.id = :id")
    public List<Persona> findAllById(String id);

}
