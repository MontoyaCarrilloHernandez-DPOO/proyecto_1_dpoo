package Excepciones;
@SuppressWarnings("serial")
public class PRExceptions extends Exception
{
	public PRExceptions()
    {
        super( );
    }
    @Override
    public String getMessage( )
    {
        String m = "No ha visto los prerequisitos para esta actividad, considere hacer primero las actividades anteriores\n";
		return m;
	    }
	}
