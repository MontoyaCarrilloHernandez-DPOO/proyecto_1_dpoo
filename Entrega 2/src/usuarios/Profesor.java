package usuarios;
import learningPaths.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import learningPaths.Actividad;
import learningPaths.LearningPath;
import learningPaths.PreguntaAbierta;
import persistencia.AnadirDatos;
import persistencia.RecogerDatos;

public class Profesor extends Usuario{
	public ArrayList<LearningPath> learningPaths;
	public ArrayList<Actividad> actividades;
	
	public Profesor(String contrasenia, String nombre, String apellido, String login,ArrayList<LearningPath> learningPaths,ArrayList<Actividad> actividades) {	
		
		super(contrasenia, nombre, apellido, login);
		
		if (actividades==null ){
			this.actividades = new ArrayList<Actividad>();
		}
		else if (actividades.isEmpty()) {
			this.actividades = new ArrayList<Actividad>();
		}
		else {
			this.actividades = actividades;
		}
		
		if (learningPaths == null) {
			this.learningPaths = new ArrayList<LearningPath>();
		}
		else if (learningPaths.isEmpty()) {
			this.learningPaths = new ArrayList<LearningPath>();
		}
		else {
		this.learningPaths = learningPaths;}

		
	}
	
	
	public ArrayList<LearningPath> getLearningPaths() {
		return learningPaths;
	}
	
	//Importante: al crear un learning path, este no debería preocuparse por no tener una lista de estudiantes asociada. Ellos luego se meten y no hay problema :)
	public void crearLearningPath(ArrayList<Actividad> actividades,String titulo,String descripcion,String objetivo, String metadatos,float duracion,float dificultad,float rating) throws SQLException {
		
		LearningPath lp = new LearningPath(this.nombre,titulo ,duracion,dificultad,rating,descripcion,objetivo,metadatos,actividades, null );
		
		
		this.learningPaths.addLast(lp);
		
	}
	
	
	public String verResenias(String nombre){
		for(Actividad actividad:actividades) {
			if(nombre.equals(actividad.getTitulo())) {
				return actividad.getResenias();
			}
		}
		return null;
	}
	
	public void calificar(Estudiante estudiante) {
		HashMap<Integer,String> respuestas = estudiante.getRespuestas();
		
		for (Integer id:respuestas.keySet()) {
			RecogerDatos datos = new RecogerDatos();
			PreguntaAbierta miPreg = datos.getPreguntaAbiertasDeID(id);
			System.out.println("La pregunta era " + miPreg.enunciado);
			System.out.println("La respuesta guía es " + miPreg.respuestaGuia);
			System.out.println("La respuesta del estudiante es " + respuestas.get(id));
			//Ahora el profesor la califica, dice si sí o no y sigue. Se debe modificar el progreso. Mirar si primero pued
			//calificar actividades antes de estudiantes.
		}
		}
		
		
		
	
	public void duplicarLP(LearningPath lp) throws SQLException {
		crearLearningPath(lp.getActividades(),lp.getTitulo()+"."+this.nombre,lp.getDescripcion(),lp.getObjetivo(),lp.getMetadatos(),lp.getDuracion(),lp.getDificultad(),lp.getRating());	
	}
	
	public ArrayList<Estudiante> getEstudiantesAsociados(LearningPath lp){
		return lp.getEstudiantes();
	}
	
	public void anadirActs(Actividad act) {
		this.actividades.addLast(act);
	}
	
	
}
