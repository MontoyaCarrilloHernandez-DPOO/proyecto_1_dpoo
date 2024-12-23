package usuarios;

import learningPaths.Actividad;

public class Usuario {
	public String contrasenia;
	public String nombre;
	public String apellido;
	public String login;
	
	public Usuario(String contrasenia, String nombre, String apellido, String login) {
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.apellido = apellido;
		this.login = login;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getLogin() {
		return login;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	private void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public void reseniar(String resenia, Actividad actividad) {
		String anterioresResenias = actividad.getResenias();
		actividad.setResenias(anterioresResenias + resenia);
	}
	
	public void ratear(double rating, Actividad actividad) {
		actividad.ratear(rating);
	}
	public boolean getAuth(String login, String contrasenia) {
		boolean flag = false;
		if(login.equals(this.login) && contrasenia.equals(this.contrasenia)) {
			flag = true;
		}
		return flag;
	}

}
