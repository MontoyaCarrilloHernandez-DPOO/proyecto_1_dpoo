package usuarios;
import learningPaths.LearningPath;
import learningPaths.Actividad;
import learningPaths.PreguntaAbierta;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import Excepciones.LPException;
import learningPaths.Progreso;

public class Estudiante {
	private ArrayList<LearningPath> historialLearningPaths;
	private LearningPath actualLearningPath;
	private Actividad actualActividad;
	protected HashMap<PreguntaAbierta, String> respuestas;
	private Progreso progreso;
	
	public Estudiante(LearningPath learningPath, Actividad actividad)
	{
		this.actualLearningPath = learningPath;
		this.actualActividad = actividad;
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
	
	protected void comenzarActividad() {
		//TODO
		
	}
	
	public double getProgreso() {
		double miProgreso = progreso.calcularProgreso();
		return miProgreso;
	}
	
	private void responder(String respuesta, PreguntaAbierta pregunta) {
		//TODO
	}
	
	
	
	
}
