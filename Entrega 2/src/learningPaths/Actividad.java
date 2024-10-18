package learningPaths;

import java.util.ArrayList;

import Excepciones.PRExceptions;
import usuarios.Estudiante;

public abstract class Actividad {

	public String objetivo;
	public String titulo;
	public String nivel;
	public ArrayList<Actividad> prerequisistos;
	public ArrayList<Actividad> sugeridos;
	public ArrayList<String> resenias;
	public int rating;
	public double tiempoLimite;
	public double resultado;
	public boolean completado;
	
	
	public Actividad(String objetivo,String titulo, String nivel, ArrayList<Actividad> prerequisistos, ArrayList<Actividad> sugeridos,
			ArrayList<String> resenias, double tiempoLimite, double resultado, int rating, boolean completado) {
		this.objetivo = objetivo;
		this.nivel = nivel;
		this.prerequisistos = prerequisistos;
		this.sugeridos = sugeridos;
		this.resenias = resenias;
		this.tiempoLimite = tiempoLimite;
		this.resultado = resultado;
		this.rating = rating;
		this.completado = completado;
		this.titulo = titulo;
	}
	
	public abstract void setCompletado();
	
	
	public String getTitulo() {
		return titulo;
	}

	public String getObjetivo() {
		return objetivo;
	}
	
	public String getNivel() {
		return nivel;
	}
	
	public ArrayList<Actividad> getPrerequisistos() {
		return prerequisistos;
	}
	
	public ArrayList<Actividad> getSugeridos() {
		return sugeridos;
	}
	
	public ArrayList<String> getResenias() {
		return resenias;
	}
	
	public double getTiempoLimite() {
		return tiempoLimite;
	}
	
	public double getResultado() {
		return resultado;
	}
	
	public int getRating() {
		return rating;
	}
	
	public boolean isCompletado() {
		return completado;
	}
	
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
		
	public void setPrerequisistos(ArrayList<Actividad> prerequisistos) {
		this.prerequisistos = prerequisistos;
	}
	
	public void setSugeridos(ArrayList<Actividad> sugeridos) {
		this.sugeridos = sugeridos;
	}
	
	public void setResenias(ArrayList<String> resenias) {
		this.resenias = resenias;
	}
	
	public void setTiempoLimite(double tiempoLimite) {
		this.tiempoLimite = tiempoLimite;
	}
	
	protected void setResultado(double resultado) {
		this.resultado = resultado;
	}
	
	protected void setReting(int rating) {
		this.rating = rating;
	}
	
	protected void advertenciaPrerequisitos(Actividad actividadPR, Estudiante estudiante) throws PRExceptions {
		int flag = 0;
		for (Actividad actividadV:estudiante.progreso.getActividadesCompletas()) {
			if(actividadV.equals(actividadPR)) {
				flag +=1;
			}
		}
		if(flag==1) {
		}else {
			System.out.println("Cuidado no cumple los prerequisitos para ver la actividad, puede verla pero bajo su riesgo.");
		}
	}
}

