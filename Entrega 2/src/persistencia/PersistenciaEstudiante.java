package persistencia;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import usuarios.Estudiante;
import learningPaths.LearningPath;
import usuarios.Profesor;
import org.json.JSONObject;
import org.json.JSONArray;

public class PersistenciaEstudiante {
	//read
	ArrayList<Estudiante> estudiantesF = new ArrayList<>();
	String content = new String(Files.readAllBytes(Paths.get("./datos/Estudiante.json")));
	JSONArray estudiantes = new JSONArray(content);
	for (int i=0; i< estudiantes.length();i++) {
		JSONObject estudiante = estudiantes.getJSONObject(i);
		String nombre = estudiante.getString("nombre");
		String apellido = estudiante.getString("apellido");
		String login = estudiante.getString("login");
		String contrasenia = estudiante.getString("contrasenia");
		
		JSONArray learningPathsArray = estudiante.getJSONArray("LearningPath");
		
        ArrayList<LearningPath> learningPaths = new ArrayList<LearningPath>();
        for (int j = 0; j < learningPathsArray.length(); j++) {
            JSONObject learningPathJson = learningPathsArray.getJSONObject(j);
            PersistenciaLearningPath learningPath ;
            LearningPath learningPathT;
            learningPaths.addLast(learningPathT);
        }

		Profesor profe = new Profesor(contrasenia,nombre,apellido,login,learningPaths);
		profesoresF.addLast(profe);
	}
}
