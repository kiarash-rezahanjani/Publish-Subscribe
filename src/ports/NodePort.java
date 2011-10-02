package ports;

import javax.sql.rowset.JoinRowSet;

import events.*;

import se.sics.kompics.PortType;
import se.sics.kompics.Positive;

public class NodePort extends PortType {{

	//outgoing from server
	positive(JoinResponse.class);
	positive(LatestPostResponse.class);
	positive(NewPost.class);
	positive(NewTopic.class);
	positive(RegisterResponse.class);
	positive(SubscriptionResponse.class);
	positive(UnsubscribeResponse.class);
	
	//incoming to server
	negative(CreatePost.class);
	negative(CreateTopic.class);
	negative(LatestPostsRequest.class);
	negative(JoinRequest.class);
	negative(RegisterRequest.class);
	negative(SubscriptionRequest.class);
	negative(UnsubscribeResponse.class);
}}
