package persistencia;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import usuarios.Estudiante;
import learningPaths.LearningPath;
import usuarios.Profesor;
import org.json.JSONObject;
import org.json.JSONArray;

public class PersistenciaLearningPath {
	//read
	ArrayList<LearningPath> lp = new ArrayList<LearningPath>();
	String content = new String(Files.readAllBytes(Paths.get("./datos/LearningPaths.json")));
	JSONArray lpc = new JSONArray(content);
	for (int i=0; i< lpc.length();i++) {
		JSONObject lpi = lpc.getJSONObject(i);
		
		String titulo = lpi.getString("titulo");
		String objetivo = lpi.getString("objetivo");
		String descripcion = lpi.getString("descripcion");
		String metadatos = lpi.getString("metadatos");
		
		Double duracion = lpi.getDouble("duracion");
		Double dificultad = lpi.getDouble("dificultad");
		Double rating = lpi.getDouble("rating");

		//estudiantes
		
		JSONArray estudiantesArray = lpi.getJSONArray("estudiantes");
        ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
        for (int j = 0; j < estudiantesArray.length(); j++) {
            //TODO:estudiantes
        	JSONObject learningPathJson = learningPathsArray.getJSONObject(j);
            PersistenciaLearningPath learningPath ;
            
        }
        
        //actividades
        JSONArray learningPathsArray = lpi.getJSONArray("LearningPath");
        ArrayList<LearningPath> learningPaths = new ArrayList<LearningPath>();
        for (int j = 0; j < learningPathsArray.length(); j++) {
        	JSONObject learningPathJson = learningPathsArray.getJSONObject(j);
        	PersistenciaLearningPath learningPath ;
        	LearningPath learningPathT;
        	learningPaths.addLast(learningPathT);
        }
        
	}
}}

		
	

