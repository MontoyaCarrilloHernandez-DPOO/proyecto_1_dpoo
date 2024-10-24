package persistencia;
import persistencia.AnadirDatos;
import usuarios.Estudiante;
import usuarios.Profesor;
import learningPaths.LearningPath;
import learningPaths.*;

import java.sql.SQLException;
import java.util.ArrayList;


@SuppressWarnings("unused")
public class Controlador {
	
	public ArrayList<Estudiante> listaEstudiantes;
	public ArrayList<Profesor> listaProfesores;
	public ArrayList<LearningPath> listaLearningPaths;
	public ArrayList<Actividad> listaActividades = new ArrayList<>();
	public Actividad actividadVacia = new Actividad("","ActividadVacia","basico",null,null,"",9925,5,false);
	private AnadirDatos anadirDatos;
	private ModificarDatos modificarDatos;
	
	
	public Controlador() {
		this.listaEstudiantes = new ArrayList<>();
		this.listaProfesores = new ArrayList<>();
		this.listaLearningPaths = new ArrayList<>();
		this.anadirDatos = new AnadirDatos();
		this.listaActividades = new ArrayList<>();
		this.listaActividades.addLast(new Actividad("",".",".",actividadVacia,actividadVacia,"",9925,5,false));
		
	}
	
	public void comprobarConexion()
    {
		DBConnection connectTest = new DBConnection();
    }

	
	public Estudiante crearEstudiante(String nombre, String apellido, String login, String contrasenia) throws SQLException 
	{ 
		Estudiante miEstudiante = new Estudiante(contrasenia, nombre, apellido, login);
		listaEstudiantes.add(miEstudiante);
		
		/**
		 * Acá ponemos al estudiante en la base de datos
		*/
		
		anadirDatos.nuevoEstudiante(nombre, apellido, login, contrasenia);
		
		return miEstudiante;
		
	}
	
	public Profesor crearProfesor(String nombre, String apellido, String login, String contrasenia) throws SQLException 
	{
		Profesor miProfesor = new Profesor(contrasenia, nombre, apellido, login, null,null);
		listaProfesores.add(miProfesor);
		
		/**
		 * Acá ponemos al profesor en la base de datos
		*/
		anadirDatos.nuevoProfesor(nombre, apellido, login, contrasenia);
		
		
		return miProfesor;
	}
	public LearningPath crearLearningPath() throws SQLException 
	{ 
		//TODO
		LearningPath miLP = new LearningPath(null, null, 0, 0, 0, null, null, null, listaActividades, listaEstudiantes);
		listaLearningPaths.add(miLP);
		
		/**
		 * Acá ponemos en la base de datos
		*/
		
		anadirDatos.nuevoLearningPath(null, null, null, null, null, 0, 0, 0, null);
		
		return miLP;

	}
	
	public void crearActividad(Actividad act, String tipo) throws SQLException {
		anadirDatos.nuevaActividad(act.getObjetivo(), act.getTitulo(), act.getNivel(), act.getPrerequisistos().getTitulo(),act.getSugeridos().getTitulo(), act.getResenias(),(float) act.getRating(), (float) act.getTiempoLimite(),act.isCompletado(), tipo, act.getTiempoLimite());
	}
	
	public void crearQuiz(Quiz quiz) throws SQLException {
		anadirDatos.nuevoQuiz(quiz.getObjetivo(), quiz.getTitulo(), quiz.getNivel(), quiz.getPrerequisistos().getTitulo(), quiz.getSugeridos().getTitulo(), quiz.getResenias(), (float) quiz.getRating(), (float) quiz.getTiempoLimite(), quiz.isCompletado(), quiz.getNotaMinima(), quiz.getNotaObtenida(), false, quiz.getEnunciadoPreguntas());
		this.listaActividades.add(quiz);
		crearActividad(quiz , "QUIZES");
	}
	public void crearRecurso(Recurso recurso) throws SQLException {
		anadirDatos.nuevoRecurso(recurso.getObjetivo(),recurso.getTitulo(), recurso.getNivel(), recurso.getPrerequisistos().getTitulo(),recurso.getSugeridos().getTitulo(),recurso.getResenias(),(float) recurso.getRating(),(float) recurso.getTiempoLimite(),false, recurso.getTipo());
		crearActividad(recurso , "RECURSOS");
		this.listaActividades.add(recurso);
	}
	public void crearTarea(Tarea tarea) throws SQLException {
		anadirDatos.nuevaTarea(tarea.getObjetivo(),tarea.getTitulo(),tarea.getNivel(),tarea.getPrerequisistos().getTitulo(), tarea.getSugeridos().getTitulo(),tarea.getResenias(),(float) tarea.getRating(),(float) tarea.getTiempoLimite(),false,tarea.isEstado());
		crearActividad(tarea , "TAREAS");
		this.listaActividades.add(tarea);
	}
	public void crearEncuesta(Encuesta encuesta) throws SQLException {
		anadirDatos.nuevaEncuesta(encuesta.getObjetivo(),encuesta.getTitulo(),encuesta.getNivel(),encuesta.getPrerequisistos().getTitulo(),encuesta.getSugeridos().getTitulo(),encuesta.getResenias(),(float) encuesta.getRating(),(float) encuesta.getTiempoLimite(),encuesta.isCompletado(),encuesta.isEnviado(), encuesta.getEnunciados(), encuesta.getRespuestasGuias());
		crearActividad(encuesta , "ENCUESTAS");
		this.listaActividades.add(encuesta);
	}

	public void crearExamen(Examen examen) throws SQLException {
		anadirDatos.nuevoExamen(examen.exitoso,examen.getNotaObtenida(),examen.getNotaMinima(),examen.getEnunciados(),examen.getRespuestaGuia(),examen.getObjetivo(),examen.getTitulo(),examen.getNivel(),examen.getPrerequisistos().getTitulo(),examen.getSugeridos().getTitulo(),examen.getResenias(), (float) examen.getRating(), (float) examen.getTiempoLimite(),examen.isCompletado());
		crearActividad(examen , "EXAMENES");
		this.listaActividades.add(examen);
	}
}
