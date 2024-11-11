package pruebas;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;


import learningPaths.PreguntaCerrada;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
	
public class PreguntaCerradaTest {

	private PreguntaCerrada preguntaCerrada;
	
	@BeforeEach
    void setUp( ) {
		preguntaCerrada = new PreguntaCerrada("opcionC", "Justificación", "¿Cuál es la capital de España?", "Madrid", "Barcelona", "Sevilla", "Valencia");
	}
	@AfterEach
	void tearDown( ) {
    }
	@Test
    void testGetEnunciado( ) {
        assertEquals( "¿Cuál es la capital de España?", preguntaCerrada.getEnunciado( ), "El enunciado de la pregunta no es el correcto" );
    }
	@Test
    void testGetOpcionA( ) {
        assertEquals( "Madrid", preguntaCerrada.getOpcionA( ), "La opción A de la pregunta no es la correcta" );
    }
	@Test
    void testGetOpcionB( ) {
        assertEquals( "Barcelona", preguntaCerrada.getOpcionB( ), "La opción B de la pregunta no es la correcta" );
    }
	@Test
    void testGetOpcionC( ) {
        assertEquals( "Sevilla", preguntaCerrada.getOpcionC( ), "La opción C de la pregunta no es la correcta" );
    }
	@Test
    void testGetOpcionD( ) {
        assertEquals( "Valencia", preguntaCerrada.getOpcionD( ), "La opción D de la pregunta no es la correcta" );
    }
}
