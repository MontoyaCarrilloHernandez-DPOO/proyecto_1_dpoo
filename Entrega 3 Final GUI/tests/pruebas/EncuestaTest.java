package pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import learningPaths.Actividad;
import learningPaths.PreguntaAbierta;
import usuarios.Estudiante;

public class EncuestaTest {
	
	private Actividad act;
	private PreguntaAbierta pra1;
	private PreguntaAbierta pra2;
	private ArrayList<PreguntaAbierta> preguntas;
	private String objetivo;
	private String titulo;
	private String nivel;
	private Actividad prerequisitos;
	private Actividad sugerido;
	private String resenias;
	private double rating;
	private float tiempoLimite;
	private boolean completado;
	
	
	@BeforeEach
	public void setUp() {
	
	}
	
	@AfterEach
	public void tearDown() {
    }

}

