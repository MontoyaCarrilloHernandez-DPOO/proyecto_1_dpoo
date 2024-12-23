package learningPaths;

import java.util.ArrayList;

public class Encuesta extends Actividad {
	public boolean enviado;
	public ArrayList<PreguntaAbierta> preguntas;
	
	public static final String tipo = "ENCUESTAS";
	//actividad
	public String objetivo;
	public String titulo;
	public String nivel;
	public Actividad prerequisistos;
	public Actividad sugeridos;
	public String resenias;
	public double rating;
	public float tiempoLimite;
	public float resultado;
	public boolean completado;

	public Encuesta(boolean enviado, ArrayList<PreguntaAbierta> preguntas,
			String objetivo,String titulo, String nivel, Actividad prerequisistos, Actividad sugeridos,
			String resenias, float tiempoLimite, double rating, boolean completado) {
		//actividad
		super(objetivo, titulo, nivel, prerequisistos, sugeridos, resenias, tiempoLimite, rating, completado);
		this.enviado = enviado;
		this.preguntas = preguntas;
	}


	public boolean isEnviado() {
		return enviado;
	}


	public ArrayList<PreguntaAbierta> getPreguntas() {
		return preguntas;
	}


	protected void setEnviado(boolean enviado) {
		this.enviado = enviado;
	}


	public String getEnunciados() {
		ArrayList<PreguntaAbierta> preguntas = getPreguntas();
		String enunciado = "";
		for (PreguntaAbierta pregunta:preguntas) {
			enunciado += pregunta.getEnunciado();
			enunciado += ",";
		}
		return enunciado;
	}

	public String getRespuestasGuias() {
		ArrayList<PreguntaAbierta> preguntas = getPreguntas();
		String enunciado = "";
		for (PreguntaAbierta pregunta:preguntas) {
			enunciado += pregunta.getRespuestaGuia();
			enunciado += ",";
		}
		return enunciado;
	}

	
	
}
