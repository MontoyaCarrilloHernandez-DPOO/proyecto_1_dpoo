package Excepciones;
@SuppressWarnings("serial")
public class LPException extends Exception
{
	public LPException()
    {
        super( );
    }
    @Override
    public String getMessage( )
    {
        String m = "No se puede inscribir a más de un Learning Path ni a uno cursado\n";
		return m;
	    }
	}

