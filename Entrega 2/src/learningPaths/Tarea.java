package learningPaths;

import java.util.ArrayList;

//TODO implementar abstacta actividad
public class Tarea extends Actividad{

	public boolean estado;
	//actividad
	public String objetivo;
	public String titulo;
	public String nivel;
	public Actividad prerequisistos;
	public Actividad sugeridos;
	public ArrayList<String> resenias;
	public double rating;
	public ArrayList<Integer> ratings;
	public float tiempoLimite;
	public boolean completado;

	
	public Tarea(boolean enviado, boolean estado,String objetivo,String titulo, String nivel, Actividad prerequisistos, Actividad sugeridos,
			ArrayList<String> resenias, float tiempoLimite, double rating, boolean completado) {
		//actividad
		super(objetivo, titulo, nivel, prerequisistos, sugeridos, resenias, tiempoLimite, rating, completado);
		this.estado = estado;
	}
	public boolean isEstado() {
		return estado;
	}
	protected void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
