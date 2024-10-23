package learningPaths;

import java.util.ArrayList;

import usuarios.Estudiante;

public class Examen extends Actividad {
	
	public boolean exitoso;
	public float notaObtenida;
	public float notaMinima;
	private ArrayList<PreguntaAbierta> preguntas;
	public static final String tipo = "EXAMENES";
	//actividad
	public String objetivo;
	public String titulo;
	public String nivel;
	public Actividad prerequisistos;
	public Actividad sugeridos;
	public String resenias;
	public int rating;
	public float tiempoLimite;
	public boolean completado;
	
	public Examen(boolean enviado, boolean exitoso, float notaObtenida, float notaMinima,
			ArrayList<PreguntaAbierta> preguntas,String objetivo,String titulo, String nivel, Actividad prerequisistos, Actividad sugeridos,
			String resenias, float tiempoLimite, double rating, boolean completado) {
		
		//actividad
		super(objetivo, titulo, nivel, prerequisistos, sugeridos, resenias, tiempoLimite, rating, completado);
		this.exitoso = exitoso;
		this.notaObtenida = notaObtenida;
		this.notaMinima = notaMinima;
		this.preguntas = preguntas;
	}

	public boolean isExitoso() {
		return exitoso;
	}


	public float getNotaObtenida() {
		return notaObtenida;
	}


	public float getNotaMinima() {
		return notaMinima;
	}


	public ArrayList<PreguntaAbierta> getPreguntas() {
		return preguntas;
	}


	protected void setExitoso(boolean exitoso) {
		if (this.notaMinima <= this.notaObtenida) {
			this.exitoso=true;
		} else {
			this.exitoso = false;
		}
	}


	protected void setNotaObtenida(float notaObtenida) {
		this.notaObtenida = notaObtenida;
	}


	protected void setPreguntas(ArrayList<PreguntaAbierta> preguntas) {
		this.preguntas = preguntas;
	}
	
	public String getEnunciados() {
		preguntas = getPreguntas();
		String enunciado = "";
		for (PreguntaAbierta pregunta:preguntas) {
			enunciado += pregunta.getEnunciado();
			enunciado += ",";
		}
		return enunciado;
	}
	public String getRespuestaGuia() {
		preguntas = getPreguntas();
		String enunciado = "";
		for (PreguntaAbierta pregunta:preguntas) {
			enunciado += pregunta.getRespuestaGuia();
			enunciado += ",";
		}
		return enunciado;
	}


	public void setCompletado(Estudiante estudiante) {
		this.completado = true;
		
	}

		
}
