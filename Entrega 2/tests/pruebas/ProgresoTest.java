package pruebas;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import learningPaths.*;
import usuarios.Estudiante;
public class ProgresoTest {

	private LearningPath lp1;
	private LearningPath lp2;
	private Actividad act1;
	private Actividad act2;
	private Actividad act3;
	private Actividad act_sugerida;
	private Actividad act_prerrequisito;
	private ArrayList<Actividad> acts;
	private Estudiante est1;
	private Estudiante est2;
	private Estudiante est3;
	private ArrayList<Estudiante> ests;
	private Progreso progreso1;
	
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
		act2 = new Actividad("Aprender Dpoo","EDA Act", "Medio", act_prerrequisito, act_sugerida, "Muy buena", 5, 3.2, false);
		act3 = new Actividad("Aprender Ip","EDA Act", "Medio", act_prerrequisito, act_sugerida, "Muy buena", 5, 3.2, false);
		
		
		acts = new ArrayList<Actividad>();
		acts.addLast(act1);
		acts.addLast(act2);
		acts.addLast(act3);
		
		lp1 = new LearningPath("Roberto", "Eda BST", (float) 1.0, 3, 1, "Curso de BST",
				"Aprender de grafos", "Creado el 30 de octubre", acts, ests);
		lp2 = new LearningPath("Samuel Montoya", "Dpoo", (float) 1.0, 3, 1, "Curso de DPOO",
				"Aprender POO", "Creado el 30 de octubre", acts, ests);
		progreso1 = new Progreso(lp1,"Samuel Montoya");
    }
	
	@AfterEach
    public void tearDown() 
	{
    }
	
	
	
	@Test
	public void testAnadirCompletasQuitarIncompleta() {
		progreso1.anadirCompletasQuitarIncompleta(act1);
        assertEquals(acts.size()-1, progreso1.getActividadesCompletas().size(), "El número de actividades completadas no se ha modificado correctamente");
        progreso1.anadirCompletasQuitarIncompleta(act1);
        assertEquals(acts.size(), progreso1.getActividadesCompletas().size(), "El número de actividades completadas no se ha modificado correctamente");
	}
	@Test 
	void testGetLearningPath() {
		assertEquals(lp1, progreso1.getLearningPath(), "El Learning Path no se ha obtenido correctamente");
	}
	
	@Test
	void testGetActividadesCompletas() {
		progreso1.setActividadesCompletadas(acts);
		assertEquals(acts, progreso1.getActividadesCompletas());	
	}
	@Test
    void testGetActividadesIncompletas() {
		assertEquals(3,progreso1.getActividadesIncompletas().size());    
    }
	@Test
    void testGetEstudiante() {
	    assertEquals("Samuel Montoya",progreso1.getEstudiante(),"El estudiante no es el mismo");    
    }
	@Test
    void testCalcularProgreso() {
		assertEquals(0.0, progreso1.calcularProgreso(),"El progreso no es el correcto");    
    }
}

