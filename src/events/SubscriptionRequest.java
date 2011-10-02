package events;

import se.sics.kompics.Request;
import util.Topic;

public class SubscriptionRequest extends Request 
{
	Topic topic;

	public SubscriptionRequest(Topic topic) {
		this.topic = topic;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	

}
