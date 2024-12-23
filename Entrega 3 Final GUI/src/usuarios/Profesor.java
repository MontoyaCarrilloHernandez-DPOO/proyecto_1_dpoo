package usuarios;
import learningPaths.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import consola.ConsolaBasica;
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
		
		LearningPath lp = new LearningPath(this.login,titulo ,duracion,dificultad,rating,descripcion,objetivo,metadatos,actividades, null );
		
		
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
	
	public Estudiante calificar(Estudiante estudiante, String nombreExamen,float nota) {
		
		
		RecogerDatos recogerDatos = new RecogerDatos();
        ArrayList<Integer> ids = recogerDatos.getIDdeRTA(estudiante, nombreExamen);
        for(Integer id : ids) {
        	if(!estudiante.respuestas.get(id).equals(null)) {
        		estudiante.respuestas.remove(id);
        
        	}
        	Progreso progreso = estudiante.getProgreso();
        	Examen examen = (Examen) recogerDatos.getActividadDeString(nombreExamen);
        	examen.setNotaObtenida(nota);
        	if(nota>= examen.getNotaMinima()) {
        		progreso.anadirCompletasQuitarIncompleta(examen);
        		estudiante.progreso = progreso;
        	}
        	
        	}
		
		return estudiante;
		}
		
		
		
	
	public void duplicarLP(LearningPath lp) throws SQLException {
		crearLearningPath(lp.getActividades(),lp.getTitulo()+"."+this.login,lp.getDescripcion(),lp.getObjetivo(),lp.getMetadatos(),lp.getDuracion(),lp.getDificultad(),lp.getRating());	
	}
	
	public LearningPath duplicarLPRetornoLP(LearningPath lp) throws SQLException {
		LearningPath lpd = new LearningPath(this.login,lp.getTitulo()+"."+this.login ,lp.getDuracion(),lp.getDificultad(),lp.getRating(),lp.getDescripcion(),lp.getObjetivo(),lp.getMetadatos(),lp.getActividades(), null );
		return lpd;
	}
	
	public ArrayList<Estudiante> getEstudiantesAsociados(LearningPath lp){
		return lp.getEstudiantes();
	}
	
	public void anadirActs(Actividad act) {
		this.actividades.addLast(act);
	}
	
	
}
