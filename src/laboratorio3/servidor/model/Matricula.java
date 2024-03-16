package laboratorio3.servidor.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Matricula implements Serializable {
    private static final long serialVersionUID = 1L;
    private Estudiante estudiante;
    private ArrayList<Materia> materias;
    private float costo;
}
