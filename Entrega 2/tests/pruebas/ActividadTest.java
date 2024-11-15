package pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import learningPaths.Actividad;
import learningPaths.Examen;
import learningPaths.PreguntaAbierta;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import learningPaths.Actividad;
import usuarios.Estudiante;

public class ActividadTest {
	private Actividad act;
	private Actividad act_prerrequisito;
	private Actividad act_sugerida;
	
	@BeforeEach
    public void setUp() {
		act_sugerida = new Actividad("TI en las org","TI","Bajo",null,null,"muy buena",5,3.2,false);
		act_prerrequisito = new Actividad("Aprender IP","IP","Bajo",null,null,"muy buena",5,3.2,false);
		act = new Actividad("Aprender EDA","EDA Act", "Medio", act_prerrequisito, act_sugerida, "Muy buena", 5, 3.2, false);
	}
	
	@AfterEach
	public void tearDown() {
    }
	
	
    @Test
    void testGetTitulo() {
        assertEquals( "EDA Act", act.getTitulo(), "El titulo de la actividad no es el correcto" );
    }
    @Test
    void testGetObjetivo() {
        assertEquals( "Aprender EDA", act.getObjetivo(), "El objetivo de la actividad no es el correcto" );
    }
    @Test
    void testGetNivel() {
        assertEquals( "Medio", act.getNivel(), "El nivel de la actividad no es el correcto" );
    }
    @Test
    void testGetPrerequisitos() {
        assertEquals( act_prerrequisito, act.getPrerequisistos(), "El prerrequisito de la actividad no es el correcto" );
    }
    @Test
    void testGetSugeridos() {
        assertEquals( act_sugerida, act.getSugeridos(), "La actividad sugerida no es la correcta" );
    }
    @Test
    void testGetResenias() {
        assertEquals( "Muy buena", act.getResenias(), "Las resenias de la actividad no son las correctas" );
    }
    @Test
    void testGetTiempoLimite() {
        assertEquals( 5.0, act.getTiempoLimite(), "El tiempo limite de la actividad no es el correcto" );
    }
    @Test
    void testGetRating() {
        assertEquals( 3.2, act.getRating(), "El rating de la actividad no es el correcto" );
    }
    @Test
    void testIsCompletado() {
        assertEquals( false, act.isCompletado(), "El estado de la actividad no es el correcto (completa o incompleta)" );
    }
	
	

}
