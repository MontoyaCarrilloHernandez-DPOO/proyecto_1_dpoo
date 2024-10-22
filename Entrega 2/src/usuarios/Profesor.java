package usuarios;

import java.util.ArrayList;

import learningPaths.Actividad;
import learningPaths.LearningPath;
import learningPaths.PreguntaAbierta;

public class Profesor extends Usuario{
	public ArrayList<LearningPath> learningPaths;
	public ArrayList<Actividad> actividades;
	public Profesor(String contrasenia, String nombre, String apellido, String login,ArrayList<LearningPath> learningPaths) {	
		super(contrasenia, nombre, apellido, login);
		this.learningPaths = learningPaths;
	}
	public void crearLearningPath(ArrayList<Actividad> actividades,ArrayList<Estudiante> estudiantes,String titulo,String descripcion,String objetivo, String metadatos,double duracion,double dificultad,double rating) {
		LearningPath lp = new LearningPath(this.nombre,titulo+"."+this.nombre ,duracion,dificultad,rating,descripcion,objetivo,metadatos,actividades,estudiantes);
		this.learningPaths.addLast(lp);
		
		//TODO:implementar que al crear el lp se guarde en el DB
	}
	
	public void crearActividad(String nombre, String objetivo, String nivel,
			double duracion, Actividad prerequisito,
			Actividad sugerido, float tiempoLimite,
			double resultado, double rating, String resenias) {
		Actividad actividad = new Actividad(objetivo, nombre, nivel, prerequisito, sugerido, resenias, tiempoLimite, rating, false);
		actividades.add(actividad);
		
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
	public void duplicarLP(LearningPath lp) {
		crearLearningPath(lp.getActividades(),lp.getEstudiantes(),lp.getTitulo(),lp.getDescripcion(),lp.getObjetivo(),lp.getMetadatos(),lp.getDuracion(),lp.getDificultad(),lp.getRating());	
	}
	private ArrayList<Estudiante> getEstudiantesAsociados(LearningPath lp){
		return lp.getEstudiantes();
	}
	
}
