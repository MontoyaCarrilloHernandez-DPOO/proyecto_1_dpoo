package pruebas;

import java.util.ArrayList;

import learningPaths.Actividad;
import usuarios.Estudiante;

public class ActividadTest {
	private Actividad act;
	private Actividad act_prerrequisito;
	private Actividad act_sugerida;
	private Estudiante est;
	
	@BeforeEach
    public void setUp() {
		act = new Actividad("Aprender EDA","EDA Act", "Medio", act_prerrequisito, act_sugerida, "Muy buena", 5.0, 3.2, false);
	}
	
	@Test
	public void testActividad() {
		assertEquals( "Aprender EDA", act.getObjetivo(), "El objetivo de la actividad no es el correcto" );
		assertEquals( "EDA Act", act.getTitulo(), "El titulo de la actividad no es el correcto" );
		assertEquals( "Medio", act.getNivel(), "El nivel de la actividad no es el correcto" );
		assertEquals( act_prerrequisito, act.getPrerequisistos(), "El prerrequisito de la actividad no es el correcto" );
		assertEquals( act_sugerida, act.getSugeridos(), "La actividad sugerida no es la correcta" );
		assertEquals( "Muy buena", act.getResenias(), "Las resenias de la actividad no son las correctas" );
		assertEquals( 5.0, act.getTiempoLimite(), "El tiempo limite de la actividad no es el correcto" );
		assertEquals( 3.2, act.getRating(), "El rating de la actividad no es el correcto" );
		assertEquals( false, act.isCompletado(), "El estado de la actividad no es el correcto (completa o incompleta)" );
	}
	
	@Test
	public void testAdvertenciaPrerrequisitos() {
		
	}
}
