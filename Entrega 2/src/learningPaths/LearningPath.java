package learningPaths;

import java.util.ArrayList;

import usuarios.Estudiante;

@SuppressWarnings("unused")
public class LearningPath {
	public String titulo;
	public String propietario;
	public float duracion;
	public float dificultad;
	public float rating;
	public String descripcion;
	public String objetivo;
	public String metadatos;
	protected ArrayList<Actividad> actividades;
	protected ArrayList<Estudiante> estudiantes;
	
	public LearningPath(String propietario, String titulo, float duracion, float dificultad, float rating, String descripcion,
			String objetivo, String metadatos, ArrayList<Actividad> actividades, ArrayList<Estudiante> estudiantes) {
		this.titulo = titulo;
		this.propietario = propietario;
		this.duracion = duracion;
		this.dificultad = dificultad;
		this.rating = rating;
		this.descripcion = descripcion;
		this.objetivo = objetivo;
		this.metadatos = metadatos;
		this.actividades = actividades;
		this.estudiantes = estudiantes;
	}
	public String getTitulo() {
		return titulo;
	}
	protected void setPropietario(String nombre) {
		this.propietario=nombre;
	}
	public String getPropietario() {
		return propietario;
	}
	protected void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public float getDuracion() {
		return duracion;
	}
	private void setDuracion(float duracion) {
		this.duracion = duracion;
	}
	public float getDificultad() {
		return dificultad;
	}
	private void setDificultad(float dificultad) {
		this.dificultad = dificultad;
	}
	public float getRating() {
		return rating;
	}
	private void setRating(float rating) {
		this.rating = rating;
	}
	public String getDescripcion() {
		return descripcion;
	}
	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getObjetivo() {
		return objetivo;
	}
	private void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public String getMetadatos() {
		return metadatos;
	}
	private void setMetadatos(String metadatos) {
		this.metadatos = metadatos;
	}
	public ArrayList<Actividad> getActividades() {
		return actividades;
	}
	private void setActividades(ArrayList<Actividad> actividades) {
		this.actividades = actividades;
	}
	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	private void setEstudiantes(ArrayList<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
}
