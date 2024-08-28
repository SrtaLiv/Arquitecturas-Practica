package org.jpa;

import org.jpa.model.Direccion;
import org.jpa.model.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExampleJPA");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin(); //transaccion para empezar a guardar datos

        Direccion d = new Direccion("Olavarria", "Paz 88"); //era al reves XD
        Direccion e = new Direccion("Tandil", "9 de julio");
        em.persist(d); //Persisti la direccion, en la base de datos
        em.persist(e);

        Persona j = new Persona("Julio", 23, d);
        Persona a = new Persona( "Ana", 19, d);
        Persona m = new Persona( "Mario", 19, e);
        em.persist(a);
        em.persist(j);
        em.persist(m);

        em.getTransaction().commit();
        em.close(); //cerramos en manager
        emf.close();
    }
}