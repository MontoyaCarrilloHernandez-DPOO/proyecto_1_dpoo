package learningPaths;

import java.util.ArrayList;

import usuarios.Estudiante;

@SuppressWarnings("unused")
public class LearningPath {
	public String titulo;
	public double duracion;
	public double dificultad;
	public double rating;
	public String descripcion;
	public String objetivo;
	public String metadatos;
	protected ArrayList<Actividad> actividades;
	protected ArrayList<Estudiante> estudiantes;
	
	public LearningPath(String titulo, double duracion, double dificultad, double rating, String descripcion,
			String objetivo, String metadatos, ArrayList<Actividad> actividades, ArrayList<Estudiante> estudiantes) {
		this.titulo = titulo;
		this.duracion = duracion;
		this.dificultad = dificultad;
		this.rating = rating;
		this.descripcion = descripcion;
		this.objetivo = objetivo;
		this.metadatos = metadatos;
		this.actividades = actividades;
		this.estudiantes = estudiantes;
	}
	private String getTitulo() {
		return titulo;
	}
	private void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	private double getDuracion() {
		return duracion;
	}
	private void setDuracion(double duracion) {
		this.duracion = duracion;
	}
	private double getDificultad() {
		return dificultad;
	}
	private void setDificultad(double dificultad) {
		this.dificultad = dificultad;
	}
	private double getRating() {
		return rating;
	}
	private void setRating(double rating) {
		this.rating = rating;
	}
	private String getDescripcion() {
		return descripcion;
	}
	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	private String getObjetivo() {
		return objetivo;
	}
	private void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	private String getMetadatos() {
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
	private ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	private void setEstudiantes(ArrayList<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
}
