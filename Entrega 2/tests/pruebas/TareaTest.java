package pruebas;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import learningPaths.Actividad;
import learningPaths.Examen;
import learningPaths.PreguntaAbierta;
import learningPaths.Tarea;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
public class TareaTest {

	private Actividad prerequisitos;
	private Actividad sugeridos;	
	private Tarea tarea;
	
	@BeforeEach
    void setUp( ) {
		
		prerequisitos = new Actividad("Aprender Java","Programacion en Java","Basico",null,null,"Muy bueno",5,5,false);
		sugeridos = new Actividad("Persistencia en Java","Persistencia","Medio",null,null,"Muy bueno",5,5,false);
        tarea = new Tarea(false, "Realizar un reporte", "Reporte de la empresa", "Básico", prerequisitos, sugeridos, "", 10f, 0.0, false);
    }
	
	@Test
	void testIsEstado() {
		assertFalse(tarea.isEstado(),"El estado es verdadero");
	}
}
