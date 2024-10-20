package learningPaths;
//TODO implementar Abstracta actividad
public class Recurso {

	public String tipo;
	public String estado;
	
	public Recurso(String tipo, String estado) {
		this.tipo = tipo;
		this.estado = estado;
	}

	public String getTipo() {
		return tipo;
	}

	public String getEstado() {
		return estado;
	}

	protected void setEstado(String estado) {
		this.estado = estado;
	}
	
}
