package pruebas;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import Excepciones.LPException;
import learningPaths.Actividad;
import learningPaths.LearningPath;
import learningPaths.PreguntaAbierta;
import learningPaths.Progreso;
import usuarios.Estudiante;

public class EstudianteTest {

	private LearningPath lp1;
	private LearningPath lp2;
	private Actividad act1;
	private Actividad act_sugerida;
	private Actividad act_prerrequisito;
	private ArrayList<Actividad> acts;
	private Estudiante est1;
	private Estudiante est2;
	private Estudiante est3;
	private ArrayList<Estudiante> ests;
	private Progreso progreso1;
	private ArrayList<LearningPath> historialLearningPaths;
	private HashMap<PreguntaAbierta, String> respuestas;
	private PreguntaAbierta pregunta;
	
	@BeforeEach
    public void setUp() {
		//TODO: completar la creacion de cada estudiante y actividad para poder hacer los test
		est1 = new Estudiante("1234","Alicia","Robinson","alirob");
		est2 = new Estudiante("1234","Nicolas","Sanchez","ns69");
		est3 = new Estudiante("1234","Antonio","Robinson","antoto");
		ests = new ArrayList<Estudiante>();
		
		ests.addLast(est1);
		ests.addLast(est2);
		ests.addLast(est3);
		
		act_sugerida = new Actividad("TI en las org","TI","Bajo",null,null,"muy buena",5,3.2,false);
		act_prerrequisito = new Actividad("Aprender IP","IP","Bajo",null,null,"muy buena",5,3.2,false);
		act1 = new Actividad("Aprender EDA","EDA Act", "Medio", act_prerrequisito, act_sugerida, "Muy buena", 5, 3.2, false);
		
		acts = new ArrayList<Actividad>();
		acts.addLast(act1);
		
		lp1 = new LearningPath("Roberto", "Eda BST", (float) 1.0, 3, 1, "Curso de BST",
				"Aprender de grafos", "Creado el 30 de octubre", acts, ests);
		lp2 = new LearningPath("Samuel Montoya", "Dpoo", (float) 1.0, 3, 1, "Curso de DPOO",
				"Aprender POO", "Creado el 30 de octubre", acts, ests);
		progreso1 = new Progreso(lp1,"alirob");
		historialLearningPaths = new ArrayList<LearningPath>();
		
		respuestas = new HashMap<PreguntaAbierta, String>();
		pregunta = new PreguntaAbierta("respuesta guia", "enunciado");
		respuestas.put(pregunta, "respuesta");
		
    }
	
	@AfterEach
    public void tearDown() 
	{
    }
	
	@Test
	public void testGetHistorialLearningPaths() {
        assertEquals(historialLearningPaths, est1.getHistorialLearningPaths(), "El historial de Learning Paths no es correcto");
    }
	
	@Test
	public void testGetActualActividad() {
		assertNull(est1.getActualActividad(), "La actividad actual deberia ser vacia");
    }
	
	@Test
	public void testGetActualLearningPath() {
		assertNull(est1.getActualLearningPath(), "El Learning Path actual deberia ser vacio");
    }
	
	@Test
	public void testRatear() {
		act1.ratear(3.5);
		assertEquals(3.35, act1.getRating(), "El rating de la actividad no es correcto");
	}
	
	@Test
	public void testEnroll() {
		try {
			est1.enroll(lp1);
		} catch (LPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(lp1, est1.getActualLearningPath(), "El Learning Path actual no es correcto");
		assertEquals(progreso1, est1.getProgreso(), "El progreso actual no es correcto");
		assertNotNull(est1.getHistorialLearningPaths(), "El historial de LPs no deberia ser vacio");
		assertNull(est1.getActualActividad(), "La actividad actual deberia ser vacia");
	}
	
	@Test
	public void testUnenroll() {
		est1.unenroll();
		assertNull(est1.getActualLearningPath(), "El LP actual deberia ser vacio");
		assertNull(est1.getProgreso(), "El progreso actual deberia ser vacio");
		assertNull(est1.getActualActividad(), "La actividad actual deberia ser vacia");
	}
	
	@Test
	public void testVerificarActividadEnLP() {
		try {
			est1.enroll(lp1);
		} catch (LPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue("La actividad deberia estar en el LP", est1.verificarActividadEnLP(act1));
	}
	
	@Test
	public void testComenzarActividad() {
		try {
			est1.enroll(lp1);
		} catch (LPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		est1.comenzarActividad(act1);
		assertEquals(act1, est1.getActualActividad(), "La actividad actual no es correcto");
	}
	
	@Test
	public void testTerminarActividad() {
		assertNull(est1.getActualActividad(), "La actividad actual deberia ser vacia");
	}
	
	@Test
	public void testResponder() {
		est1.responder("respuesta", pregunta);
		assertEquals(respuestas, est1.getRespuestas(), "Las respuestas no son correctas");
	}
	
	@Test
	public void testViendoActividad() {
		try {
			est1.enroll(lp1);
		} catch (LPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		est1.comenzarActividad(act1);
		assertTrue("El estudiante deberia estar viendo una actividad", est1.viendoActividad());
	}
	
}
