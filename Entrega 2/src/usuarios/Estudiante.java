package usuarios;
import learningPaths.LearningPath;
import persistencia.ModificarDatos;
import learningPaths.Actividad;
import learningPaths.PreguntaAbierta;
import java.util.HashMap;
import java.util.ArrayList;
import Excepciones.LPException;
import learningPaths.Progreso;

public class Estudiante extends Usuario{
	public ArrayList<LearningPath> historialLearningPaths;
	public LearningPath actualLearningPath;
	public Actividad actualActividad;
	public HashMap<PreguntaAbierta, String> respuestas;
	public Progreso progreso;
	
	public Estudiante(String contrasenia, String nombre, String apellido, String login)
	{
		super(contrasenia, nombre, apellido, login);
		this.historialLearningPaths = new ArrayList<LearningPath>();
		
	}
	
	public ArrayList<LearningPath> gethistorialLearningPaths(){
		return this.historialLearningPaths;
	}
	
	public void ratear(int rating, Actividad actividad) {
		actividad.ratear(rating);
	}
	
	public void enroll(LearningPath learningPath) throws LPException {
		if (!historialLearningPaths.contains(learningPath)) {
			this.actualLearningPath = learningPath;
			this.progreso = new Progreso(learningPath, this.login);
			this.historialLearningPaths.add(learningPath);
			this.actualActividad = null;
			ModificarDatos modificar = new ModificarDatos();
			modificar.cambiarDatosEstudiante(this.login, this.historialLearningPaths, this.actualLearningPath, this.actualActividad, this.respuestas, this.progreso);
			modificar.cambiarDatosProgreso(progreso);
		}
		else {
			throw new LPException();
		}
	}
	
	public void unenroll() {
		this.actualLearningPath = null;
		this.progreso = null;
		this.actualActividad = null;
		ModificarDatos modificar = new ModificarDatos();
		modificar.cambiarDatosEstudiante(this.login, this.historialLearningPaths, this.actualLearningPath, this.actualActividad, this.respuestas, this.progreso);
		
	}
	
	public boolean verificarActividadEnLP(Actividad actividad) {
		//false si no pertenece una actividad al lp al que esta inscrito el estudiante true si si
		LearningPath lp = this.actualLearningPath;
		if(lp.getActividades().contains(actividad)) {
			return true;
		}
		return false;
	}
	
	public void comenzarActividad(Actividad actividad) {
		if(actividad.equals(null)&& verificarActividadEnLP(actividad)==true) {
			this.actualActividad = actividad;
			ModificarDatos modificar = new ModificarDatos();
			modificar.cambiarDatosEstudiante(this.login, this.historialLearningPaths, this.actualLearningPath, this.actualActividad, this.respuestas, this.progreso);
			//TODO Implementar para que el cambie los datos en la DB
		}
	}
	
	public void terminarActividad() {
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
		//Que es estooo :((((((((((((
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
		//TODO Implementar para que el cambie los datos en la DB
		System.out.println("Actividad marcada como completada con exito");				
	}
	}
	
	public boolean viendoActividad() {
		if(this.actualActividad.equals(null)) {
			return false;
		}else {
			return true;
			}
	}
}
