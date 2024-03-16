package laboratorio3.cliente.model;

import java.io.Serializable;

public class Materia implements Serializable {
    private static final long serialVersionUID = 1L;
    private String codigo;
    private String nombre;
    private int creditos;
    private TipoMateria tipoMateria;
    private Carrera carrera;

}
