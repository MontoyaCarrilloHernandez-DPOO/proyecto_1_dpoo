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
	
	public void setActividadesCompletadas(ArrayList<Actividad> actsCompletadas) {
		this.actividadesCompletadas = actsCompletadas;
	}
	
	public void setActividadesIncompletas(ArrayList<Actividad> actsIncompletas) {
		this.actividadesIncompletas = actsIncompletas;
	}
	
	public Progreso(LearningPath learningPath, String login)
	{
		this.learningPath = learningPath;
		if (learningPath!=null) {
			this.actividadesIncompletas = learningPath.getActividades();
		}
		else {
			this.actividadesIncompletas = null;
		}
		this.actividadesCompletadas = null ;
		this.estudiante = login;
	}
	
	
	public void anadirCompletasQuitarIncompleta(Actividad actividad)
	{
		this.actividadesCompletadas.add(actividad);
		this.actividadesIncompletas.remove(actividad);
	}
	
	public LearningPath getLearningPath()
	{
		return learningPath;
	}
	
	public ArrayList<Actividad> getActividadesCompletas()
	{
		return actividadesCompletadas;
	}
	
	public ArrayList<Actividad> getActividadesIncompletas()
	{
		return actividadesIncompletas;
	}
	
	public double calcularProgreso()
	{
		double progreso;
		if (actividadesCompletadas == null) {
			progreso = 0;
		}
		else if (actividadesIncompletas == null) {
			progreso = 1;
		}
		else{
			progreso = actividadesCompletadas.size()/learningPath.actividades.size();
			}
		
		return progreso*100;
	}

	public String getEstudiante() {
		return this.estudiante;
	}

}
