package consola;
import java.sql.SQLException;

import persistencia.Controlador;

public class ConsolaCrearControlador extends ConsolaBasica{
	public ConsolaCrearControlador() {}
	
	public Controlador crear() throws SQLException
	{
		Controlador miControlador = new Controlador();
		miControlador.comprobarConexion();
		return miControlador;
	}

}
