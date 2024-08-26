package org.example.dao;

import javax.sql.RowSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface IDAOFactory<T> {
    void insert(T t) throws SQLException;
    void update(T t) throws SQLException;
    void delete(T id) throws SQLException;
    T getById(int id);
    List<T> getAll() throws SQLException;

    //Las que no entendi:
    public RowSet selectCustomersRS();
    public Collection selectCustomers();

}
