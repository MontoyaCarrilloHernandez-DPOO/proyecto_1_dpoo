package pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import learningPaths.Actividad;
import learningPaths.LearningPath;
import usuarios.Estudiante;

public class LearningPathTest {
	
	private LearningPath lp;
	private Actividad act1;
	private Actividad act2;
	private Actividad act3;
	private ArrayList<Actividad> acts;
	private Estudiante est1;
	private Estudiante est2;
	private Estudiante est3;
	private ArrayList<Estudiante> ests;
	
	
	@BeforeEach
    public void setUp() {
		ests = new ArrayList<Estudiante>();
		
		ests.addLast(est1);
		ests.addLast(est2);
		ests.addLast(est3);
		
		acts = new ArrayList<Actividad>();
		acts.addLast(act1);
		acts.addLast(act2);
		acts.addLast(act3);
		
		lp = new LearningPath("Roberto", "Eda BST", (float) 1.0, 3, 1, "Curso de BST",
				"Aprender de grafos", "Creado el 30 de octubre", acts, ests);
	}
	@Test
	public void testGetActividades() {
		assertEquals( acts, lp.getActividades(), "Las actividades del Learning Paths no son correctas" );
	}

	
	@Test
	void testTitulo() {
		assertEquals( "Eda BST", lp.getTitulo(), "El titulo del Learning Path no es el correcto" );		
	}
	
	@Test
	void testGetPropietario() {
		assertEquals( "Roberto", lp.getPropietario(), "El nombre del propietario no es el correcto" );
	}
	
	@Test
	void testGetDuracion() {
		assertEquals( 1.0, lp.getDuracion(), "La duracion del LEarning Path no es la correcto" );		
	}
	
	@Test
	void testGetDificultad() {
		assertEquals( 3,(int) lp.getDificultad(), "La dificultad del Learning Path no es correcta" );		
	}
	
	@Test
    void testGetRating() {
        assertEquals( 1, (int) lp.getRating(), "El rating del Learning Path no es correcto" );
    }
	
	@Test 
	void testGetDescription() {
		assertEquals( "Curso de BST", lp.getDescripcion(), "La descripcion del Learning Path no es correcta" );		
	}
	
	@Test
    void testGetObjetivo() {
		assertEquals( "Aprender de grafos", lp.getObjetivo(), "El objetivo del Learning Path no es el correcto" );
    }
}
