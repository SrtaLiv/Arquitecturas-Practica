package org.example.dao;

import org.example.modelo.Persona;

import java.util.List;

public interface IPersonaDAO {

    public void insertPersona(Persona persona);
    public void delete(int id);
    public Persona getPersonaByID(int id);
    public List<Persona> getPersonas();

    //Las que no entendi:
    //public RowSet selectCustomersRS();
    //public Collection selectCustomers();

}
