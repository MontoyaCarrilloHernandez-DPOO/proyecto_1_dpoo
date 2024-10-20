package learningPaths;

import java.util.ArrayList;

import usuarios.Estudiante;

public class Examen extends Actividad {
	
	public boolean exitoso;
	public double notaObtenida;
	public double notaMinima;
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
	public ArrayList<Integer> ratings;
	public double tiempoLimite;
	public double resultado;
	public boolean completado;
	
	public Examen(boolean enviado, boolean exitoso, double notaObtenida, double notaMinima,
			ArrayList<PreguntaAbierta> preguntas, String enunciado,String respuestaGuia,String objetivo,String titulo, String nivel, Actividad prerequisistos, Actividad sugeridos,
			ArrayList<String> resenias, double tiempoLimite, double resultado, int rating, boolean completado) {
		
		//actividad
		super(objetivo, titulo, nivel, prerequisistos, sugeridos, resenias, tiempoLimite, resultado, rating, completado);
		this.exitoso = exitoso;
		this.notaObtenida = notaObtenida;
		this.notaMinima = notaMinima;
		this.preguntas = preguntas;
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


	public void setCompletado(Estudiante estudiante) {
		this.completado = true;
		
	}

		
}
