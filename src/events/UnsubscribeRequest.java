package events;

import se.sics.kompics.Request;
import util.Topic;

public class UnsubscribeRequest extends Request 
{
	Topic topic;

	public UnsubscribeRequest(Topic topic) {
		this.topic = topic;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	

}
