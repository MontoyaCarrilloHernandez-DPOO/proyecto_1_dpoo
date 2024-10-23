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
