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
	public int rating;
	public ArrayList<Integer> ratings;
	public double tiempoLimite;
	public double resultado;
	public boolean completado;

	
	public Tarea(boolean enviado, boolean estado,String objetivo,String titulo, String nivel, Actividad prerequisistos, Actividad sugeridos,
			ArrayList<String> resenias, double tiempoLimite, double resultado, int rating, boolean completado) {
		//actividad
		super(objetivo, titulo, nivel, prerequisistos, sugeridos, resenias, tiempoLimite, resultado, rating, completado);
		this.estado = estado;
	}
	public boolean isEstado() {
		return estado;
	}
	protected void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
