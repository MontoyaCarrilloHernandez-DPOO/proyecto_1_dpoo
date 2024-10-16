package persistencia;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


import learningPaths.LearningPath;
import usuarios.Profesor;
import org.json.JSONObject;
import org.json.JSONArray;



public class PeristenciaProfesor {
	
	//read
	ArrayList<Profesor> profesoresF = new ArrayList<>();
	String content = new String(Files.readAllBytes(Paths.get("./datos/Profesores.json")));
	JSONArray profesores = new JSONArray(content);
	for (int i=0; i< profesores.length();i++) {
		JSONObject profesor = profesores.getJSONObject(i);
		String nombre = profesor.getString("nombre");
		String apellido = profesor.getString("apellido");
		String login = profesor.getString("login");
		String contrasenia = profesor.getString("contrasenia");
		JSONArray learningPathsArray = profesor.getJSONArray("LearningPath");
		
        ArrayList<LearningPath> learningPaths = new ArrayList<LearningPath>();
        for (int j = 0; j < learningPathsArray.length(); j++) {
            JSONObject learningPathJson = learningPathsArray.getJSONObject(j);
            //TODO: hacer persistencia llamada a la de learning path
            PersistenciaLearningPath learningPath ;
            LearningPath learningPathT;
            learningPaths.addLast(learningPathT);
        }

		Profesor profe = new Profesor(contrasenia,nombre,apellido,login,learningPaths);
		profesoresF.addLast(profe);
	}
	
}
