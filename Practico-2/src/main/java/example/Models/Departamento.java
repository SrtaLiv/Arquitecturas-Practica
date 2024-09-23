package example.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

public class Departamento {
    private String descripcion;

    @Id
    private int id;


    //El departamento tiene MUCHOS empledos, crea tabla INTERMEDIA
    @Column(name="lista_empleados")
    @OneToMany
    private List<Empleado> empleados;


}
