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
	
	protected void enroll(LearningPath learningPath) throws LPException {
		if (actualLearningPath == null && !historialLearningPaths.contains(learningPath)) {
			this.actualLearningPath = learningPath;
			this.progreso = new Progreso(learningPath);
			this.historialLearningPaths.add(learningPath);
		}
		else {
			throw new LPException();
		}
	}
	
	protected void unenroll(LearningPath learningPath) {
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
		//TODO
		this.actualActividad = null;
	}
	
	public double getProgreso() {
		double miProgreso = progreso.calcularProgreso();
		return miProgreso;
	}
	
	private void responder(String respuesta, PreguntaAbierta pregunta) {
		//TODO
	}
	
	public boolean viendoActividad() {
		if(this.actualActividad.equals(null)) {
			return true;
		}else {
			return false;
			}
	}
}
