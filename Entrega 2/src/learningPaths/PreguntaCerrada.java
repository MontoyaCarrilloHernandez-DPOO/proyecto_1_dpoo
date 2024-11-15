package learningPaths;

public class PreguntaCerrada {
	public String respuestaCorrecta;
	public String justificacion;
	public String enunciado;
	public String opcionA;
	public String opcionB;
	public String opcionC;
	public String opcionD;
	
	public PreguntaCerrada(String respuestaCorrecta, String justificacion, String enunciado, String opcionA,
			String opcionB, String opcionC, String opcionD) {
		super();
		this.respuestaCorrecta = respuestaCorrecta;
		this.justificacion = justificacion;
		this.enunciado = enunciado;
		this.opcionA = opcionA;
		this.opcionB = opcionB;
		this.opcionC = opcionC;
		this.opcionD = opcionD;
	}

	private String getRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	private String getJustificacion() {
		return justificacion;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public String getOpcionA() {
		return opcionA;
	}

	public String getOpcionB() {
		return opcionB;
	}

	public String getOpcionC() {
		return opcionC;
	}

	public String getOpcionD() {
		return opcionD;
	}
	
	
	
}
