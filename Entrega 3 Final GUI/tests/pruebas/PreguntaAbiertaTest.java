package pruebas;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;


import learningPaths.PreguntaAbierta;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
public class PreguntaAbiertaTest {
	
	private PreguntaAbierta preguntaAbierta;
	
    @BeforeEach
    void setUp( ) {
        preguntaAbierta = new PreguntaAbierta("La respuesta debe contener las palabras si, entonces y porque", "Cual es el metodo cientifico?");
    }
    
    @AfterEach
    void tearDown( ) {
        preguntaAbierta = null;
    }
    
    @Test
    void testGetRespuestaGuia( ) {
        assertEquals( "La respuesta debe contener las palabras si, entonces y porque", preguntaAbierta.getRespuestaGuia(), "El método getRespuestaGuia no funciona correctamente" );
    }
    
    @Test
    void testGetEnunciado( ) {
        assertEquals( "Cual es el metodo cientifico?", preguntaAbierta.getEnunciado(), "El método getEnunciado no funciona correctamente" );
    }
}
