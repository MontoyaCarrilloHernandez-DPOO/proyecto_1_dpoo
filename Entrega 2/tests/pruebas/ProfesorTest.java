package pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import learningPaths.Actividad;
import learningPaths.LearningPath;
import learningPaths.PreguntaAbierta;
import learningPaths.Progreso;
import usuarios.Estudiante;
import usuarios.Profesor;

public class ProfesorTest {
	
	private Profesor profesor;
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
	private ArrayList<LearningPath> lps;
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
		
		lp1 = new LearningPath("Pepe", "Eda BST", (float) 1.0, 3, 1, "Curso de BST",
				"Aprender de grafos", "Creado el 30 de octubre", acts, null);
		lp2 = new LearningPath("Samuel Montoya", "Dpoo", (float) 1.0, 3, 1, "Curso de DPOO",
				"Aprender POO", "Creado el 30 de octubre", acts, ests);
		progreso1 = new Progreso(lp1,"alirob");
		lps = new ArrayList<LearningPath>();
		lps.addLast(lp1);
		
		respuestas = new HashMap<PreguntaAbierta, String>();
		pregunta = new PreguntaAbierta("respuesta guia", "enunciado");
		respuestas.put(pregunta, "respuesta");
		
		profesor = new Profesor("contrasenia", "Pepe", "Perez", "PepePerez", lps, acts);
		
    }
	
	@AfterEach
    public void tearDown() 
	{
    }
	
	@Test
	public void testCrearLearningPath() throws SQLException {
		profesor.crearLearningPath(acts, "Eda BST", "Curso de BST", "Aprender de grafos", "Creado el 30 de octubre", (float) 1.0, 3, 1);
        assertEquals(lps, profesor.getLearningPaths(), "No se creo un LP correctamente");
    }
	
	@Test
	public void testVerResenias() {
		assertEquals("Muy buena", profesor.verResenias("EDA Act"), "Las resenias no son correctas");
    }
	
	@Test
	public void testGetEstudiantesAsociados() {
		assertEquals(ests, profesor.getEstudiantesAsociados(lp2), "Los estudiantes asociados no son correctos");
    }
	
	
}
