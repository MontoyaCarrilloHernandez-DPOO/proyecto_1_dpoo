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
	public ArrayList<Actividad> listaActividades;
	public AnadirDatos anadirDatos;
	
	public Controlador() {
		this.listaEstudiantes = new ArrayList<>();
		this.listaProfesores = new ArrayList<>();
		this.listaLearningPaths = new ArrayList<>();
		this.anadirDatos = new AnadirDatos();
		
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
		Profesor miProfesor = new Profesor(contrasenia, nombre, apellido, login, null);
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
		
		//TODO
		if (tipo == "Quiz") {
			anadirDatos.nuevoQuiz(tipo, tipo, tipo, 0, 0, tipo, 0, 0, false, 0, 0, false, tipo);
		}
		else if (tipo == "Recurso") {
			anadirDatos.nuevoRecurso(tipo, tipo, tipo, 0, 0, tipo, 0, 0, false, tipo);
		}
		else if (tipo == "Tarea") {
			anadirDatos.nuevaTarea(tipo, tipo, tipo, 0, 0, tipo, 0, 0, false, tipo);
		}

		else if (tipo == "Examen") {
			anadirDatos.nuevoExamen(false, 0, 0, tipo, tipo, tipo, tipo, tipo, tipo, 0, 0, tipo, 0, 0, false);
		}

		else if (tipo == "Encuesta") {
			anadirDatos.nuevaEncuesta(tipo, tipo, tipo, 0, 0, tipo, 0, 0, false, false, tipo, tipo, tipo);
		}

		
		
		
	}
}
