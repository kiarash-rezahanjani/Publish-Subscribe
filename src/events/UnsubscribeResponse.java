package events;

import se.sics.kompics.Request;
import se.sics.kompics.Response;
import util.Topic;

public class UnsubscribeResponse extends Response{
	
	Topic topic;
	
	public Topic getTopic() {
		return topic;
	}
	
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	public UnsubscribeResponse(Request request)
	{
		super(request);
	
	}

}
