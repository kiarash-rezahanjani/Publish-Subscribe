package events;

import se.sics.kompics.Request;
import se.sics.kompics.Response;

public class SubscriptionResponse extends Response{
	
	boolean accepted;
	
	public SubscriptionResponse(Request request)
	{
		super(request);
		accepted=false;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	

}
