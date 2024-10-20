package learningPaths;

import java.util.ArrayList;
//TODO Implementar Abstracta actividad
public class Quiz extends PreguntaCerrada{
	public String respuestaCorrecta;
	public String justificacion;
	public String enunciado;
	public String opcionA;
	public String opcionB;
	public String opcionC;
	public String opcionD;
	public double notaMinima;
	public double notaObtenida;
	public boolean exitoso;
	private ArrayList<PreguntaCerrada> preguntas;
	
	public Quiz(String respuestaCorrecta, String justificacion, String enunciado, String opcionA, String opcionB,
			String opcionC, String opcionD, double notaMinima, double notaObtenida,boolean exitoso, ArrayList<PreguntaCerrada> preguntas) {
		super(respuestaCorrecta, justificacion, enunciado, opcionA, opcionB, opcionC, opcionD);
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
