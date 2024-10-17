package consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public abstract class ConsolaBasica
{
	protected String pedirCadena( String mensaje )
    {
        try
        {
            System.out.print( mensaje + ": " );
            BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
            String input = reader.readLine( );
            return input;
        }
        catch( IOException e )
        {
            System.out.println( "Error leyendo de la consola" );
        }
        return "error";
    }
	
	protected boolean pedirConfirmacion( String mensaje )
    {
        try
        {
            System.out.print( mensaje + " (Responda 'si' o 'no' ) " );
            BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
            String input = reader.readLine( ).toLowerCase( );
            boolean respuesta = false;
            if( input.equals( "si" ) || input.equals( "sí" ) || input.equals( "s" ) )
                respuesta = true;

            return respuesta;
        }
        catch( IOException e )
        {
            System.out.println( "Error leyendo de la consola" );
        }
        return false;
    }


    protected int pedirEntero( String mensaje )
    {
        int valorResultado = Integer.MIN_VALUE;
        while( valorResultado == Integer.MIN_VALUE )
        {
            try
            {
                System.out.print( mensaje + ": " );
                BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
                String input = reader.readLine( );
                int numero = Integer.parseInt( input );
                valorResultado = numero;
            }
            catch( NumberFormatException nfe )
            {
                System.out.println( "El valor digitado no es un entero" );
            }
            catch( IOException e )
            {
                System.out.println( "Error leyendo de la consola" );
            }
        }
        return valorResultado;
    }

    protected double pedirNumero( String mensaje )
    {
        double valorResultado = Integer.MIN_VALUE;
        while( valorResultado == Integer.MIN_VALUE )
        {
            try
            {
                System.out.print( mensaje + ": " );
                BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
                String input = reader.readLine( );
                double numero = Double.parseDouble( input );
                valorResultado = numero;
            }
            catch( NumberFormatException nfe )
            {
                System.out.println( "El valor digitado no es un entero" );
            }
            catch( IOException e )
            {
                System.out.println( "Error leyendo de la consola" );
            }
        }
        return valorResultado;
    }

    protected String pedirOpcion( Collection<? extends Object> coleccionOpciones )
    {
        String[] opciones = new String[coleccionOpciones.size( )];
        int pos = 0;
        for( Iterator<? extends Object> iterator = coleccionOpciones.iterator( ); iterator.hasNext( ); pos++ )
        {
            opciones[ pos ] = iterator.next( ).toString( );
        }

        System.out.println( "Seleccione una de las siguientes opciones:" );
        for( int i = 1; i <= opciones.length; i++ )
        {
            System.out.println( " " + i + ". " + opciones[ i - 1 ] );
        }

        String opcion = pedirCadena( "\nEscriba el número que corresponde a la opción deseada" );
        try
        {
            int opcionSeleccionada = Integer.parseInt( opcion );
            if( opcionSeleccionada > 0 && opcionSeleccionada <= opciones.length )
                return opciones[ opcionSeleccionada - 1 ];
            else
            {
                System.out.println( "Esa no es una opción válida. Digite solamente números entre 1 y " + opciones.length );
                return pedirOpcion( coleccionOpciones );
            }
        }
        catch( NumberFormatException nfe )
        {
            System.out.println( "Esa no es una opción válida. Digite solamente números." );
            return pedirOpcion( coleccionOpciones );
        }
    }

  
    protected int mostrarMenu( String nombreMenu, String[] opciones )
    {
        System.out.println( "\n---------------------" );
        System.out.println( nombreMenu );
        System.out.println( "---------------------" );

        for( int i = 1; i <= opciones.length; i++ )
        {
            System.out.println( " " + i + ". " + opciones[ i - 1 ] );
        }
        String opcion = pedirCadena( "Escoja la opción deseada" );
        try
        {
            int opcionSeleccionada = Integer.parseInt( opcion );
            if( opcionSeleccionada > 0 && opcionSeleccionada <= opciones.length )
                return opcionSeleccionada;
            else
            {
                System.out.println( "Esa no es una opción válida. Digite solamente números entre 1 y " + opciones.length );
                return mostrarMenu( nombreMenu, opciones );
            }
        }
        catch( NumberFormatException nfe )
        {
            System.out.println( "Esa no es una opción válida. Digite solamente números." );
            return mostrarMenu( nombreMenu, opciones );
        }
    }

    // TODO Esto se usaría para ver los estados de los Learning Paths, listado de estudiantes para el profesdor, etc.
    /**
    protected void mostrarEstadoActual( int cantidadSurtidores, Collection<TipoGasolina> tiposGasolina, String[] nombresEmpleados )
    {
        mostrarInformacionBasica( cantidadSurtidores, tiposGasolina );
        System.out.println( "Los empleados son: " + Arrays.toString( nombresEmpleados ) );
        System.out.println( "******************\n" );
    }


    protected void mostrarEstadoActual( int cantidadSurtidores, Collection<TipoGasolina> tiposGasolina, Collection<Empleado> empleados )
    {
        mostrarInformacionBasica( cantidadSurtidores, tiposGasolina );
        System.out.println( "Los empleados son: " );
        for( Empleado empleado : empleados )
        {
            System.out.println( "   - " + empleado.getNombre( ) + " tiene " + empleado.getCantidadDinero( ) + " pesos" );
        }
        System.out.println( "******************\n" );
    }


    private void mostrarInformacionBasica( int cantidadSurtidores, Collection<TipoGasolina> tiposGasolina )
    {
        System.out.println( "\n******************" );
        System.out.println( "ESTADO ACTUAL" );
        System.out.println( "La gasolinera tiene actualmente " + cantidadSurtidores + ( cantidadSurtidores > 1 ? " surtidores" : " surtidor" ) );
        System.out.println( "Los tipos de gasolina disponible son:" );
        for( TipoGasolina tipo : tiposGasolina )
        {
            String galonesDisponibles = String.format( "%.2f", tipo.getCantidadDisponible( ) );
            System.out.println( "   - " + tipo.getNombre( ) + ": " + tipo.getPrecioPorGalon( ) + " por galón, " + galonesDisponibles + " galones disponibles" );
        }
    }
     */
}
