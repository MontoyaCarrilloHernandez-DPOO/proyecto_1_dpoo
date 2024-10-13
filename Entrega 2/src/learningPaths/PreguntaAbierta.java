package learningPaths;

public class PreguntaAbierta {
	private String respuestaGuia;
	public String eneunciado;
	
	public PreguntaAbierta(String respuestaGuia, String eneunciado) {
		this.respuestaGuia = respuestaGuia;
		this.eneunciado = eneunciado;
	}

	public String getRespuestaGuia() {
		return respuestaGuia;
	}

	public String getEnunciado() {
		return eneunciado;
	}
	 
}
