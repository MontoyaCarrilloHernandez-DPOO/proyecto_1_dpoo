package learningPaths;

import java.util.ArrayList;
public class Quiz extends Actividad{
	
	public double notaMinima;
	public double notaObtenida;
	public boolean exitoso;
	private ArrayList<PreguntaCerrada> preguntas;
	
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

	
	public Quiz(String respuestaCorrecta, String justificacion, String enunciado, String opcionA, String opcionB,
			String opcionC, String opcionD, double notaMinima, double notaObtenida,boolean exitoso, ArrayList<PreguntaCerrada> preguntas,String objetivo,String titulo, String nivel, Actividad prerequisistos, Actividad sugeridos,
			ArrayList<String> resenias, double tiempoLimite, double resultado, int rating, boolean completado) {
		super(objetivo, titulo, nivel, prerequisistos, sugeridos, resenias, tiempoLimite, resultado, rating, completado);
		this.notaMinima = notaMinima;
		this.notaObtenida = notaObtenida;
		this.exitoso = exitoso;
		this.preguntas = preguntas;
	}

	public double getNotaObtenida() {
		return notaObtenida;
	}

	public boolean isExitoso() {
		return exitoso;
	}

	private ArrayList<PreguntaCerrada> getPreguntas() {
		return preguntas;
	}

	public void setNotaObtenida(double notaObtenida) {
		this.notaObtenida = notaObtenida;
	}

	public void setExitoso(boolean exitoso) {
		if(this.notaMinima <= this.notaObtenida) {
			this.exitoso = true;
		} else {
			this.exitoso = false;
		}	
	}
	
	public String getEnunciados(ArrayList<PreguntaCerrada> preguntas) {
		String enunciado = "";
		for (PreguntaCerrada pregunta:preguntas) {
			enunciado += pregunta.getEnunciado();
			enunciado += "\n \n \n";
		}
		return enunciado;
	}

}
