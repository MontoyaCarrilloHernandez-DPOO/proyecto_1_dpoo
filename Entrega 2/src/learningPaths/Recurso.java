package learningPaths;

import java.util.ArrayList;

public class Recurso extends Actividad {

	public String tipo;
	
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

	
	public Recurso(String tipo, String objetivo,String titulo, String nivel, Actividad prerequisistos, Actividad sugeridos,
			ArrayList<String> resenias, float tiempoLimite, double rating, boolean completado) {
		//actividad
		super(objetivo, titulo, nivel, prerequisistos, sugeridos, resenias, tiempoLimite, rating, completado);
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

}
