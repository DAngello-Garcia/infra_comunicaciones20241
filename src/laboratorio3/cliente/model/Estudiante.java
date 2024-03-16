package laboratorio3.cliente.model;

import java.io.Serializable;

public class Estudiante implements Serializable {
    private static final long serialVersionUID = 1L;
    private String codigo;
    private String nombre;
    private String clave;
    private EstadoMatricula estadoMatricula;

}
