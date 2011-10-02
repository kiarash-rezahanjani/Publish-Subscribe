package events;

import se.sics.kompics.Event;
import util.Topic;

public class NewTopic extends Event{
	
	Topic topic;

	public NewTopic(Topic topic) 
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
