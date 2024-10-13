package learningPaths;

import java.util.ArrayList;

public class Encuesta extends PreguntaAbierta {
	public boolean enviado;
	private ArrayList<PreguntaAbierta> preguntas;
	public String enunciado;
	public String respuestaGuia;
	

	public Encuesta(String respuestaGuia, String eneunciado, boolean enviado, ArrayList<PreguntaAbierta> preguntas,
			String enunciado) {
		super(respuestaGuia, eneunciado);
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
}
