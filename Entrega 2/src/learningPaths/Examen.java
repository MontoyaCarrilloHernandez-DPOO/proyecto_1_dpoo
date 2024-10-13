package learningPaths;

import java.util.ArrayList;

public class Examen extends PreguntaAbierta {
	public boolean enviado;
	public boolean exitoso;
	public double notaObtenida;
	public double notaMinima;
	private ArrayList<PreguntaAbierta> preguntas;
	public String enunciado;
	public String respuestaGuia;
	
	
	public Examen(boolean enviado, boolean exitoso, double notaObtenida, double notaMinima,
			ArrayList<PreguntaAbierta> preguntas, String enunciado,String respuestaGuia) {
		super(respuestaGuia, enunciado );
		this.enviado = enviado;
		this.exitoso = exitoso;
		this.notaObtenida = notaObtenida;
		this.notaMinima = notaMinima;
		this.preguntas = preguntas;
	}


	public boolean isEnviado() {
		return enviado;
	}


	public boolean isExitoso() {
		return exitoso;
	}


	public double getNotaObtenida() {
		return notaObtenida;
	}


	public double getNotaMinima() {
		return notaMinima;
	}


	public ArrayList<PreguntaAbierta> getPreguntas() {
		return preguntas;
	}


	protected void setEnviado(boolean enviado) {
		this.enviado = enviado;
	}


	protected void setExitoso(boolean exitoso) {
		if (this.notaMinima <= this.notaObtenida) {
			this.exitoso=true;
		} else {
			this.exitoso = false;
		}
	}


	protected void setNotaObtenida(double notaObtenida) {
		this.notaObtenida = notaObtenida;
	}


	protected void setPreguntas(ArrayList<PreguntaAbierta> preguntas) {
		this.preguntas = preguntas;
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
