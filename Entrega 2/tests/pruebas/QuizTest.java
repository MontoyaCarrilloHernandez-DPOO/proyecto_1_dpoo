package pruebas;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import learningPaths.*;

public class QuizTest {
	
	private Quiz quiz1;
    private Actividad prerequisito;
    private Actividad sugerido; 
    private PreguntaCerrada p1;
    private PreguntaCerrada p2;
    private PreguntaCerrada p3;
    private ArrayList<PreguntaCerrada> preguntas;
    
    
    @BeforeEach
    void setUp( ) throws Exception
    {
    	
    	prerequisito = new Actividad("Aprender IP","IP","Bajo",null,null,"muy buena",5,3.2,false);
    	sugerido = new Actividad("Aprender EDA","EDA Act", "Medio", prerequisito, prerequisito, "muy buena", 5, 3.2, false);
    
    	p1 = new PreguntaCerrada("C", "Que es mas grande","es la C pq el Mm es mas grande", "dm", "Gm", "Mm", "nm");
    p2 = new PreguntaCerrada("D", "Que es mas grande","es la C pq el Mm es mas grande", "dm", "Gm", "Mm", "nm");
    p3 = new PreguntaCerrada("A", "Que es mas grande","es la C pq el Mm es mas grande", "dm", "Gm", "Mm", "nm");
    	
    preguntas = new ArrayList<PreguntaCerrada>();
    	
    preguntas.add(p1);
    	preguntas.add(p2);
    	preguntas.add(p3);
    	
    quiz1 = new Quiz(3, 0, false, preguntas, "Ver si sabe de longitudes", "Quiz long", "Basico", prerequisito, sugerido, "Muy buena", 0, 0, false);
    }

    @AfterEach
    void tearDown( ) throws Exception
    {
    }

    @Test
    void testGetNotaObtenida() 
    {
    		assertEquals(quiz1.getNotaObtenida(),0,"La nota no es la esperada");
    		quiz1.setNotaObtenida(3);
    		assertEquals(quiz1.getNotaObtenida(),3,"La nota no es la esperada");
    }
    
    @Test
    void testGetNotaMinima() 
    {
    		assertEquals(quiz1.getNotaMinima(),3,"La nota minima no es la esperada");
    }
    @Test
    void testIsExitoso() 
    {
    		assertFalse(quiz1.isExitoso(),"La actividad no es exitosa");
    }
    
    @Test
    void testGetEnunciados() {
    	    assertEquals(quiz1.getEnunciadoPreguntas(),"es la C pq el Mm es mas grande\n \n \nes la C pq el Mm es mas grande\n \n \nes la C pq el Mm es mas grande","Los enunciados de las preguntas no son correctos");
    }
    
    @Test
    void testGetPreguntas() {
    	    assertEquals(quiz1.getPreguntas(),preguntas,"Los enunciados de las preguntas no son correctos");
    }
}
