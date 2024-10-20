package consola;

import java.sql.SQLException;
import usuarios.Estudiante;


public class ConsolaResumirLP extends ConsolaBasica {
	
	private final String[] opcionesMenuEstudianteLP = new String[]{ "Continuar con tu actividad actual", "Reseniar tu actividad actual", "Ratear tu actividad actual","Volver al menú principal" };
	private Estudiante miEstudiante;
	
	public ConsolaResumirLP(Estudiante estudiante) {
		this.miEstudiante = estudiante;
	}
	
	
	public void mostrarOpciones() throws SQLException
    {
        boolean regresar = false;

        while( !regresar )
        {

            int opcionSeleccionada = mostrarMenu( "Menú de Progreso", opcionesMenuEstudianteLP );
            if( opcionSeleccionada == 1 )
            {
                //TODO
            }
            else if( opcionSeleccionada == 2 )
            {
            	String resenia = pedirCadena("Ingresa tu resenia");
            	miEstudiante.ratear(resenia, miEstudiante.actualActividad);
            }
            else if( opcionSeleccionada == 3 )
            {
            	int rating = pedirNumero("Ingresa tu rating (recuerda que es un entero sobre 5)");
            	miEstudiante.reseniar(rating, miEstudiante.actualActividad);
            }
            else if( opcionSeleccionada == 4 )
            {
                regresar = true;
            }
            mostrarOpciones();
        }

    }

}
