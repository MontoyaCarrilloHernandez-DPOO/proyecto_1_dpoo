package consola;
import java.sql.SQLException;

import persistencia.Controlador;

public class ConsolaCrearControlador extends ConsolaBasica{
	public ConsolaCrearControlador() {}
	
	public Controlador crear() throws SQLException
	{
		Controlador miControlador = new Controlador();
		Controlador.comprobarConexion();
		System.out.print("Sistema creado con exito. Ya puede agregar estudiantes y profesores. Si usted es un profesor, puede crear Learning Paths y atcividades \n" );
		return miControlador;
	}

}
