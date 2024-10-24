package learningPaths;
import learningPaths.Actividad;
import persistencia.*;
import learningPaths.LearningPath;
import usuarios.Estudiante;
import java.util.ArrayList;
import java.util.List;

public class Progreso {
	private String estudiante;
	private LearningPath learningPath;
	private ArrayList<Actividad> actividadesCompletadas;
	private ArrayList<Actividad> actividadesIncompletas;
	
	
	public Progreso(LearningPath learningPath, String login)
	{
		this.learningPath = learningPath;
		this.estudiante = login;
	}
	
	public void setNewLearningPath(LearningPath learningPath)
	{
		this.learningPath = learningPath;
		this.actividadesIncompletas = learningPath.getActividades();
		this.actividadesCompletadas = null ;
	}
	
	public void anadirCompletasQuitarIncompleta(Actividad actividad)
	{
		this.actividadesCompletadas.add(actividad);
		this.actividadesIncompletas.remove(actividad);
	}
	
	public LearningPath getLearningPath()
	{
		return this.learningPath;
	}
	
	public ArrayList<Actividad> getActividadesCompletas()
	{
		return this.actividadesCompletadas;
	}
	
	public ArrayList<Actividad> getActividadesIncompletas()
	{
		return this.actividadesIncompletas;
	}
	
	public double calcularProgreso()
	{
		double progreso = this.actividadesCompletadas.size()/this.learningPath.actividades.size();
		return progreso*100;
	}

	public String getEstudiante() {
		return this.estudiante;
	}

}
