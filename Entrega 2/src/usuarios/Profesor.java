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
	public void calificar(LearningPath lp, PreguntaAbierta pregunta) {
		if(lp.getPropietario().equals(this.nombre)) {
			//TODO: implementar, no se pudo implementar
			
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
