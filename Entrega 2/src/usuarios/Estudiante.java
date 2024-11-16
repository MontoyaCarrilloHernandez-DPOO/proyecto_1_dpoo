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
	public HashMap<Integer, String> respuestas; // la llave es un entero que es la llave primaria en la base de datos
	public Progreso progreso;
	
	public Estudiante(String contrasenia, String nombre, String apellido, String login)
	{
		super(contrasenia, nombre, apellido, login);
		this.historialLearningPaths = new ArrayList<LearningPath>();
		this.respuestas = new HashMap<Integer, String>();
		
	}
	
	public ArrayList<LearningPath> getHistorialLearningPaths(){
		return this.historialLearningPaths;
	}
	
	public Actividad getActualActividad() {
		return actualActividad;
	}

	public LearningPath getActualLearningPath() {
		return actualLearningPath;
	}
	
	public Progreso getProgreso() {
		return progreso;
	}

	public HashMap<Integer, String> getRespuestas() {
		return respuestas;
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
			this.respuestas = new HashMap<Integer, String>();
			
			learningPath.anadirEstudiantes(this);
			
			ModificarDatos modificar = new ModificarDatos();
			modificar.cambiarDatosEstudiante(this.login, this.historialLearningPaths, this.actualLearningPath, this.actualActividad, this.respuestas, this.progreso);
			modificar.cambiarDatosProgreso(progreso);
			
		}
		else {
			throw new LPException();
		}
	}
	
	public void unenroll() {
		
		actualLearningPath = null;
		progreso = null;
		actualActividad = null;
		respuestas = null;
		ModificarDatos modificar = new ModificarDatos();
		modificar.cambiarDatosEstudiante(this.login, this.historialLearningPaths, this.actualLearningPath, this.actualActividad, this.respuestas, this.progreso);
		
	}
	
	public boolean verificarActividadEnLP(Actividad actividad) {
		//false si no pertenece una actividad al lp al que esta inscrito el estudiante true si si
		LearningPath lp = this.actualLearningPath;
		if(lp.getActividades().contains(actividad)) {
			return true;
		}
		else {
		return false;}
	}
	
	public void comenzarActividad(Actividad actividad) {
		if(actualActividad == null&& verificarActividadEnLP(actividad)==true) {
			this.actualActividad = actividad;
			ModificarDatos modificar = new ModificarDatos();
			modificar.cambiarDatosEstudiante(this.login, this.historialLearningPaths, this.actualLearningPath, this.actualActividad, this.respuestas, this.progreso);
			
		}
	}
	
	public void terminarActividad() {
		this.progreso.anadirCompletasQuitarIncompleta(actualActividad);
		this.actualActividad = null;
		
	}
	
	public void responder(String respuesta, int indice) {
		respuestas.put(indice, respuesta); //CUANDO SE IMPLEMENTE ESTO, SE DEBE VERIFICAR QUE QUEDE EL ID QUE QUEREMOS
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
		/*
		else {
		for (int i=0; i< respuestasAc.size();i++) {
			respuestas.put(preguntas.get(i), respuestasAc.get(i));
		}
		actividad.setCompletado();
		*/
		
		//TODO Implementar para que el cambie los datos en la DB
		System.out.println("Actividad marcada como completada con exito");				
	}
	
	public boolean viendoActividad() {
		if(this.actualActividad.equals(null)) {
			return false;
		}else {
			return true;
			}
	}
}
