package persistencia;
import persistencia.AnadirDatos;
import usuarios.Estudiante;
import usuarios.Profesor;
import learningPaths.LearningPath;

import java.sql.SQLException;
import java.util.ArrayList;


@SuppressWarnings("unused")
public class Controlador {
	
	private ArrayList<Estudiante> listaEstudiantes;
	private ArrayList<Profesor> listaProfesores;
	private ArrayList<LearningPath> listaLearningPaths;
	private AnadirDatos anadirDatos;
	
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
	
}
