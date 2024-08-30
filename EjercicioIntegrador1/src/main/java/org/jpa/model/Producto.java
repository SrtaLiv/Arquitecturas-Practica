package org.jpa.model;

import javax.persistence.*;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int idProducto;
    String nombre;
    Float valor;

    @ManyToMany
    private  Factura factura;
}
