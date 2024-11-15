package pruebas;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import learningPaths.Actividad;
import learningPaths.Examen;
import learningPaths.PreguntaAbierta;
import learningPaths.Recurso;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
public class RecursoTest {
	
	private Actividad prerequisitos;
	private Actividad sugeridos;
	private Recurso recurso;
	@BeforeEach
    void setUp( ) {
		prerequisitos = new Actividad("Aprender Java","Programacion en Java","Basico",null,null,"Muy bueno",5,5,false);
		sugeridos = new Actividad("Persistencia en Java","Persistencia","Medio",null,null,"Muy bueno",5,5,false);
        recurso = new Recurso("Entender Grafos", "Grafos", "Nivel", prerequisitos, sugeridos, "muy bueno",(float) 5,(double)5,false, "Texto");
    }
	
    @AfterEach
    void tearDown() {
    }
    @Test
    void testGetTipo() {
        assertEquals("Texto", recurso.getTipo());
    }
}
