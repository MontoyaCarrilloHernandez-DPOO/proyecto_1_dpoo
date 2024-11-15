package pruebas;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import learningPaths.Actividad;
import learningPaths.Examen;
import learningPaths.PreguntaAbierta;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class ExamenTest {
	private Actividad prerequisitos;
	private Actividad sugeridos;
	private ArrayList<PreguntaAbierta> preguntas;
	private Examen examen1; // examen sin presentar
	private Examen examen2; // examen presentado
	
	@BeforeEach
	void setUp() {
		prerequisitos = new Actividad("Aprender Java","Programacion en Java","Basico",null,null,"Muy bueno",5,5,false);
		sugeridos = new Actividad("Persistencia en Java","Persistencia","Medio",null,null,"Muy bueno",5,5,false);
		
		ArrayList<PreguntaAbierta> preguntas = new ArrayList<PreguntaAbierta>();

		preguntas.addLast(new PreguntaAbierta("La respuesta deberia tener los principales aspectos de como funciona una clase", "Como funciona una clase en Java?"));
        preguntas.addLast(new PreguntaAbierta("La respuesta deberia tener los principales aspectos de como funciona la herencia", "Como funciona la herencia en Java?"));
        preguntas.addLast(new PreguntaAbierta("La respuesta deberia ser falso con una justificacion valida","Una clase puede tener mas de una herencia?"));
        
        examen1 = new Examen(false,false,(float) 0,(float) 5,preguntas,"Calificar conocimiento en Java","DPOO p1","Medio",prerequisitos,sugeridos,"Muy facil",(float) 5,5.0,false);
        examen2 = new Examen(true,true,(float) 3.5,(float) 5,preguntas,"Calificar conocimiento en Java","DPOO p1","Medio",prerequisitos,sugeridos,"Muy facil",(float) 5,5.0,true);
        
	}
	
	@AfterEach
    void tearDown() {
    }
	
	@Test
    void testIsExitoso() {
		assertEquals(false, examen1.isExitoso(), "El examen 1 no es exitoso" );
		assertEquals(true, examen2.isExitoso(), "El examen 2 es exitoso" );
	}
	
	@Test
	void testGetNotaObtenida() {
        assertEquals((float) 0, examen1.getNotaObtenida(), "La nota obtenida del examen 1 no es correcta" );
        assertEquals((float) 3.5, examen2.getNotaObtenida(), "La nota obtenida del examen 2 no es correcta" );
    }
	
    @Test
    void testGetNotaMinima() {
    	assertEquals((float) 5, examen1.getNotaMinima(), "La nota minima del examen 1 no es correcta" );
        assertEquals((float) 5, examen2.getNotaMinima(), "La nota minima del examen 2 no es correcta" );
    }
    
    @Test
    void testGetPreguntas() {
    	assertNull( preguntas, "Las preguntas del examen 1 no son correctas" );
    	
    }
    @Test
    void testGetEnunciados() {
    	String enunciado1 = "Como funciona una clase en Java?,Como funciona la herencia en Java?,Una clase puede tener mas de una herencia?,";
        assertEquals(enunciado1, examen1.getEnunciados(), "Los enunciados del examen 1 no son correctos" );
        assertEquals(enunciado1, examen2.getEnunciados(), "Los enunciados del examen 2 no son correctos" );
    }
    @Test
    void testGetRespuestaGuia() {
    		String respuestaGuia1 = "La respuesta deberia tener los principales aspectos de como funciona una clase, La respuesta deberia tener los principales aspectos de como funciona la herencia, La respuesta deberia ser falso con una justificacion valida, ";
        assertEquals(respuestaGuia1, examen1.getRespuestaGuia(), "La respuesta guia del examen 1 no es correcta" );
    }
	
}
