package usuarios;
import learningPaths.LearningPath;
import learningPaths.Actividad;
import learningPaths.PreguntaAbierta;
import java.util.HashMap;
import java.util.ArrayList;
import Excepciones.LPException;
import learningPaths.Progreso;

public class Estudiante extends Usuario{
	private ArrayList<LearningPath> historialLearningPaths;
	private LearningPath actualLearningPath;
	public Actividad actualActividad;
	protected HashMap<PreguntaAbierta, String> respuestas;
	public Progreso progreso;
	
	public Estudiante(String contrasenia, String nombre, String apellido, String login)
	{
		super(contrasenia, nombre, apellido, login);
	}
	

	
	public void ratear(int rating, Actividad actividad) {
		actividad.ratear(rating);
	}
	
	public void enroll(LearningPath learningPath) throws LPException {
		if (actualLearningPath == null && !historialLearningPaths.contains(learningPath)) {
			this.actualLearningPath = learningPath;
			this.progreso = new Progreso(learningPath);
			this.historialLearningPaths.add(learningPath);
		}
		else {
			throw new LPException();
		}
	}
	
	public void unenroll() {
		this.actualLearningPath = null;
		this.progreso = null;
	}
	
	private boolean verificarActividadEnLP(Actividad actividad) {
		//false si no pertenece una actividad al lp al que esta inscrito el estudiante true si si
		LearningPath lp = this.actualLearningPath;
		if(lp.getActividades().contains(actividad)) {
			return true;
		}
		return false;
	}
	
	protected void comenzarActividad(Actividad actividad) {
		if(actividad.equals(null)&& verificarActividadEnLP(actividad)==true) {
			this.actualActividad = actividad;
			
		}
	}
	
	protected void terminarActividad() {
		this.progreso.anadirCompletasQuitarIncompleta(actualActividad);
		this.actualActividad = null;
		
	}
	
	public double getProgreso() {
		double miProgreso = progreso.calcularProgreso();
		return miProgreso;
	}
	
	public void responder(String respuesta, PreguntaAbierta pregunta) {
		respuestas.put(pregunta, respuesta);
	}
	
	public void marcarCompletado(ArrayList<String> respuestasAc, ArrayList<PreguntaAbierta> preguntas, Actividad actividad) {
		//Las actividades que le entren a esta funcion deben de ser de tipo examen o encuesta.
		if(respuestasAc.size()!=preguntas.size()) {
			if(respuestasAc.size()<preguntas.size()) {
				System.out.println("Hay mas preguntas que respuestas, responda todas las preguntas");				
			}else {				
				System.out.println("Hay mas respuestas que preguntas");				
			}
		}
		else {
		for (int i=0; i< respuestasAc.size();i++) {
			respuestas.put(preguntas.get(i), respuestasAc.get(i));
		}
		actividad.setCompletado();
		System.out.println("Actividad marcada como completada con exito");				
	}
	}
	
	public boolean viendoActividad() {
		if(this.actualActividad.equals(null)) {
			return true;
		}else {
			return false;
			}
	}
}
