package usuarios;

import java.util.ArrayList;

import learningPaths.Actividad;
import learningPaths.LearningPath;

public class Profesor extends Usuario{
	public ArrayList<LearningPath> learningPaths;
	public Profesor(String contrasenia, String nombre, String apellido, String login,ArrayList<LearningPath> learningPaths) {	
		super(contrasenia, nombre, apellido, login);
		this.learningPaths = learningPaths;
	}
	private void crearLearningPath(ArrayList<Actividad> actividades) {
		
	}
	private void crearLearningPath(String nombre, String objetivo, double duracion, ArrayList<Actividad> prerequisitos, ArrayList<Actividad> sugeridos, double timepoLimite, double resultado, double rating, String reseña) {
		LearningPath lp = new LearningPath();
	}
	private ArrayList<String> verResenias(){
		
		
		return null;
	}
	
}
