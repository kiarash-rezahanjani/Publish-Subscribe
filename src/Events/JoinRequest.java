package Events;
import se.sics.kompics.*;

public class JoinRequest extends Request
{
	String message;
	
	public void setMessage(String msg)
	{
		message=msg;
	}

	public String getMessage() {
		return message;
	}

}
