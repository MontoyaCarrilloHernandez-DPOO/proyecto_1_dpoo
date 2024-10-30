package pruebas;

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
	public void testLearningPath() {
		
		
	}
}
