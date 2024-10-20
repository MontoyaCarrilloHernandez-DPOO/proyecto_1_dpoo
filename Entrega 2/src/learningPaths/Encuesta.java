package learningPaths;

import java.util.ArrayList;

public class Encuesta extends Actividad {
	public boolean enviado;
	private ArrayList<PreguntaAbierta> preguntas;
	public String enunciado;
	public String respuestaGuia;
	
	//actividad
	public String objetivo;
	public String titulo;
	public String nivel;
	public Actividad prerequisistos;
	public Actividad sugeridos;
	public ArrayList<String> resenias;
	public int rating;
	public float ratings;
	public float tiempoLimite;
	public float resultado;
	public boolean completado;

	public Encuesta(String respuestaGuia, String eneunciado, boolean enviado, ArrayList<PreguntaAbierta> preguntas,
			String enunciado,String objetivo,String titulo, String nivel, Actividad prerequisistos, Actividad sugeridos,
			ArrayList<String> resenias, float tiempoLimite, float resultado, int rating, boolean completado) {
		//actividad
		super(objetivo, titulo, nivel, prerequisistos, sugeridos, resenias, tiempoLimite, resultado, rating, completado);
		this.enviado = enviado;
		this.preguntas = preguntas;
	}


	public boolean isEnviado() {
		return enviado;
	}


	private ArrayList<PreguntaAbierta> getPreguntas() {
		return preguntas;
	}


	protected void setEnviado(boolean enviado) {
		this.enviado = enviado;
	}


	public String getEnunciados(ArrayList<PreguntaAbierta> preguntas) {
		String enunciado = "";
		for (PreguntaAbierta pregunta:preguntas) {
			enunciado += pregunta.getEnunciado();
			enunciado += "\n \n \n";
		}
		return enunciado;
	}


	@Override
	public void setCompletado() {
		this.completado = true;
	}
}
