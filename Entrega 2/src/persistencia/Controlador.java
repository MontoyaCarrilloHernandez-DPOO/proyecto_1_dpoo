package persistencia;
import persistencia.AnadirEstudiante;
import usuarios.Estudiante;
import usuarios.Profesor;
import learningPaths.LearningPath;

import java.sql.SQLException;
import java.util.ArrayList;


public class Controlador {
	
	private ArrayList<Estudiante> listaEstudiantes;
	private ArrayList<Profesor> listaProfesores;
	private ArrayList<LearningPath> listaLearningPaths;
	
	public Controlador() {
		this.listaEstudiantes = new ArrayList<>();
		this.listaProfesores = new ArrayList<>();;
		this.listaLearningPaths = new ArrayList<>();;
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
		AnadirEstudiante nuevo = new AnadirEstudiante();
		nuevo.nuevoEstudiante(nombre, apellido, login, contrasenia);
		
		return miEstudiante;
		
	}
	
	public Profesor crearProfesor(String nombre, String apellido, String login, String contrasenia) 
	{//TODO Complear la creacion de profesor desde su clase
		Profesor miProfesor = new Profesor(contrasenia, nombre, apellido, login, null);
		listaProfesores.add(miProfesor);
		
		/**
		 * Acá ponemos al profesor en la base de datos
		*/
		
		
		return miProfesor;
	}
	
}
