package events;
import se.sics.kompics.*;


public class JoinResponse extends Response
{
	String message;
	
	public JoinResponse(Request request)
	{ 
		super(request);
	}
	
	public void setMessage(String msg)
	{
		message=msg;
	}

	public String getMessage() {
		return message;
	}
}
