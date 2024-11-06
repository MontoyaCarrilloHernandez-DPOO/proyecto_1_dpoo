package learningPaths;

import java.util.ArrayList;

import Excepciones.PRExceptions;
import usuarios.Estudiante;

public class Actividad {

	public String objetivo;
	public String titulo;
	public String nivel;
	public Actividad prerequisistos;
	public Actividad sugeridos;
	public String resenias;
	public double rating;
	public float tiempoLimite;
	public boolean completado;
	
	
	public Actividad(String objetivo,String titulo, String nivel, Actividad prerequisistos, Actividad sugeridos,
			String resenias, float tiempoLimite, double rating, boolean completado) {
		this.objetivo = objetivo;
		this.nivel = nivel;
		this.prerequisistos = prerequisistos;
		this.sugeridos = sugeridos;
		this.resenias = resenias;
		this.tiempoLimite = tiempoLimite;
		this.rating = rating;
		this.completado = completado;
		this.titulo = titulo;
	}
	
	public void setCompletado() {
		this.completado = true;
	}
	
	
	public String getTitulo() {
		return titulo;
	}

	public String getObjetivo() {
		return objetivo;
	}
	
	public String getNivel() {
		return nivel;
	}
	
	public Actividad getPrerequisistos() {
		return prerequisistos;
	}
	
	public Actividad getSugeridos() {
		return sugeridos;
	}
	
	public String getResenias() {
		return resenias;
	}
	
	public double getTiempoLimite() {
		return tiempoLimite;
	}
	
	
	public double getRating() {
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
		
	public void setPrerequisistos(Actividad prerequisistos) {
		this.prerequisistos = prerequisistos;
	}
	
	public void setSugeridos(Actividad sugeridos) {
		this.sugeridos = sugeridos;
	}
	
	public void setResenias(String resenias) {
		this.resenias = resenias;
	}
	
	public void setTiempoLimite(float tiempoLimite) {
		this.tiempoLimite = tiempoLimite;
	}
	
	
	protected void setRating() {
		this.rating = 5;
	}
	
	protected boolean advertenciaPrerequisitos(Actividad actividadPR, Estudiante estudiante) throws PRExceptions {
		int flag = 0;
		for (Actividad actividadV:estudiante.progreso.getActividadesCompletas()) {
			if(actividadV.equals(actividadPR)) {
				flag +=1;
				break;
			}
		}
		if(flag==1) {
			return true;
		}
		else {
			System.out.println("Cuidado no cumple los prerequisitos para ver la actividad, puede verla pero bajo su riesgo.");
			return false;
		}
	}
	
	public void ratear(double rating) {
		this.rating = (this.rating + rating)/1.2;
	}
}

