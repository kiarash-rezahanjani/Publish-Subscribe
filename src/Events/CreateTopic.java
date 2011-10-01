package Events;

import se.sics.kompics.Request;
import util.Topic;

public class CreateTopic extends Request
{

	Topic topic;

	public CreateTopic(Topic topic) 
	{	
		this.topic = topic;
	}

	public Topic getTopic() 
	{
		return topic;
	}

	public void setTopic(Topic topic) 
	{
		this.topic = topic;
	}
	
}
