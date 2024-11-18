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
			this.actividadesIncompletas = new ArrayList<Actividad>();
		}
		this.actividadesCompletadas = new ArrayList<Actividad>() ;
		this.estudiante = login;
	}
	
	
	public void anadirCompletasQuitarIncompleta(Actividad actividad)
	{	actividadesIncompletas.remove(actividad);
		actividadesCompletadas.add(actividad);
		
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
	
	public float calcularProgreso()
	{
		float progreso;
		
		if (actividadesCompletadas == null || actividadesCompletadas.isEmpty()) {
			progreso = 0;
		}
		else if (actividadesIncompletas == null || actividadesIncompletas.isEmpty()) {
			progreso = 1;
		}
		else{
			progreso = actividadesCompletadas.size()/learningPath.actividades.size();
			}
		
		System.out.println(progreso);
		return progreso*100;
	}

	public String getEstudiante() {
		return this.estudiante;
	}

}
