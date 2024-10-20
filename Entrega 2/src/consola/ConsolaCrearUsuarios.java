package consola;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.Controlador;
import usuarios.Estudiante;
import usuarios.Profesor;
import usuarios.Usuario;
import learningPaths.LearningPath;


public class ConsolaCrearUsuarios extends ConsolaBasica
{

    private final String[] opcionesCrearUsuario = new String[]{ "Nuevo estudiante", "Nuevo profesor", "Regresar al menu principal" };

    private Controlador sistema;
    
    public ConsolaCrearUsuarios(Controlador sistema)
    {
    	this.sistema = sistema;
    }
    
    public void mostrarOpciones() throws SQLException
    {
    	Usuario nuevoUsuario = null;
        boolean regresar = false;

        while( nuevoUsuario == null && !regresar )
        {

            int opcionSeleccionada = mostrarMenu( "Menú de creación de usuario", opcionesCrearUsuario );
            if( opcionSeleccionada == 1 )
            {
                nuevoUsuario = crearNuevoEstudiante(sistema);
            }
            else if( opcionSeleccionada == 2 )
            {
            	nuevoUsuario = crearNuevoProfesor(sistema);
            }
            else if( opcionSeleccionada == 3 )
            {
                regresar = true;
            }
        }

    }

    private Estudiante crearNuevoEstudiante(Controlador sistema) throws SQLException
    {
    	String nombre = pedirCadena( "Ingresa tu nombre " );
    	String apellido = pedirCadena( "Ingresa tu apellido " );
    	String login = pedirCadena( "Ingresa tu login (primera parte de tu correo antes del @) " );
    	String contrasenia = pedirCadena( "Ingresa tu constrasena " );
    	Estudiante miEstudiante = sistema.crearEstudiante(nombre, apellido, login, contrasenia);
    	return miEstudiante;
    }


    private Profesor crearNuevoProfesor(Controlador sistema) throws SQLException
    {
    	String nombre = pedirCadena( "Ingresa tu nombre " );
    	String apellido = pedirCadena( "Ingresa tu apellido " );
    	String login = pedirCadena( "Ingresa tu login (primera parte de tu correo antes del @) " );
    	String contrasenia = pedirCadena( "Ingresa tu constrasena " );
    	Profesor miProfesor = sistema.crearProfesor(nombre, apellido, login, contrasenia);
		return miProfesor;
    }



}
