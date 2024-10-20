package learningPaths;
//TODO implementar abstacta actividad
public class Tarea {
	public boolean enviado;
	public boolean estado;
	
	public Tarea(boolean enviado, boolean estado) {
		this.enviado = enviado;
		this.estado = estado;
	}
	public boolean isEnviado() {
		return enviado;
	}
	public boolean isEstado() {
		return estado;
	}
	protected void setEnviado(boolean enviado) {
		this.enviado = enviado;
	}
	protected void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
