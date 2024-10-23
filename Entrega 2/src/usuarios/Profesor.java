package usuarios;
import learningPaths.*;
import java.sql.SQLException;
import java.util.ArrayList;

import learningPaths.Actividad;
import learningPaths.LearningPath;
import learningPaths.PreguntaAbierta;
import persistencia.AnadirDatos;

public class Profesor extends Usuario{
	public ArrayList<LearningPath> learningPaths;
	public ArrayList<Actividad> actividades;
	public Profesor(String contrasenia, String nombre, String apellido, String login,ArrayList<LearningPath> learningPaths) {	
		super(contrasenia, nombre, apellido, login);
		this.learningPaths = learningPaths;
	}
	
	//Importante: al crear un learning path, este no debería preocuparse por no tener una lista de estudiantes asociada. Ellos luego se meten y no hay problema :)
	public void crearLearningPath(ArrayList<Actividad> actividades,String titulo,String descripcion,String objetivo, String metadatos,double duracion,double dificultad,double rating) throws SQLException {
		LearningPath lp = new LearningPath(this.nombre,titulo+"."+this.nombre ,duracion,dificultad,rating,descripcion,objetivo,metadatos,actividades, null );
		this.learningPaths.addLast(lp);
		
		AnadirDatos anadir = new AnadirDatos();
		String actividadesStr = "";
		for (Actividad act : actividades) {
			actividadesStr+=act.titulo+",";
		}
		anadir.nuevoLearningPath(titulo+"."+this.nombre, descripcion, objetivo, this.nombre, metadatos, (float)dificultad, (float)duracion, (float)rating, actividadesStr);
	}
	
	public void crearActividad(String nombre, String objetivo, String nivel,
			double duracion, Actividad prerequisito,
			Actividad sugerido, float tiempoLimite,
			double resultado, double rating, String resenias, int tipo) {
		Actividad actividad = new Actividad(objetivo, nombre, nivel, prerequisito, sugerido, resenias, tiempoLimite, rating, false);
		actividades.add(actividad);
		if(tipo == 1) {
			//Quiz
			//TODO COMPLETAR CON PERSISTENCIA DB
			Quiz quiz = new Quiz(resenias, resenias, resenias, resenias, resenias, resenias, resenias, tiempoLimite, tiempoLimite, false, null, resenias, resenias, resenias, actividad, actividad, resenias, tiempoLimite, rating, false);
		}
		if(tipo == 2) {
			//Recurso
		}
		else if(tipo == 3) {
			//Tarea
		}
		else if(tipo == 4) {
			//Examen
		}
		else if(tipo == 5) {
			//Encuesta
		}
		
			
		//TODO:implementar que al crear la actividad se guarde en el DB

	}
	
	public String verResenias(String nombre){
		for(Actividad actividad:actividades) {
			if(nombre.equals(actividad.getTitulo())) {
				return actividad.getResenias();
			}
		}
		return null;
	}
	public void calificar(LearningPath lp, PreguntaAbierta pregunta) {
		if(lp.getPropietario().equals(this.nombre)) {
			//TODO: implementar, no se pudo implementar porque soy un chimpance que no programo actividad como abstracta y no puedo acceder al tipo de actividad, recordar pensar la proxima vez
			
		}
	}
	public void duplicarLP(LearningPath lp) throws SQLException {
		crearLearningPath(lp.getActividades(),lp.getTitulo(),lp.getDescripcion(),lp.getObjetivo(),lp.getMetadatos(),lp.getDuracion(),lp.getDificultad(),lp.getRating());	
	}
	private ArrayList<Estudiante> getEstudiantesAsociados(LearningPath lp){
		return lp.getEstudiantes();
	}
	
}
