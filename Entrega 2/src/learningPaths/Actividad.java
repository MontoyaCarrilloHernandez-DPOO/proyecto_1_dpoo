package learningPaths;

import java.util.ArrayList;

public class Actividad {
	public String objetivo;
	public String nivel;
	public ArrayList<Actividad> prerequisistos;
	public ArrayList<Actividad> sugeridos;
	public ArrayList<String> resenias;
	public double tiempoLimite;
	public double resultado;
	public double reting;
	public boolean completado;
	public Actividad(String objetivo, String nivel, ArrayList<Actividad> prerequisistos, ArrayList<Actividad> sugeridos,
			ArrayList<String> resenias, double tiempoLimite, double resultado, double reting, boolean completado) {
		this.objetivo = objetivo;
		this.nivel = nivel;
		this.prerequisistos = prerequisistos;
		this.sugeridos = sugeridos;
		this.resenias = resenias;
		this.tiempoLimite = tiempoLimite;
		this.resultado = resultado;
		this.reting = reting;
		this.completado = completado;
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
	public double getReting() {
		return reting;
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
	protected void setReting(double reting) {
		this.reting = reting;
	}
	public void setCompletado(boolean completado) {
		this.completado = completado;
	}

	
}
