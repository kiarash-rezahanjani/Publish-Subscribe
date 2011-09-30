package ports;

import javax.sql.rowset.JoinRowSet;

import Events.*;
import se.sics.kompics.PortType;
import se.sics.kompics.Positive;

public class NodePort extends PortType {{

	positive(JoinResponse.class);
	positive(LatestPostResponse.class);
	positive(NewPost.class);
	positive(NewTopic.class);
	positive(RegisterResponse.class);
	negative(CreatePost.class);
	negative(CreateTopic.class);
	negative(LatestPostsRequest.class);
	negative(JoinRequest.class);
	negative(RegisterRequest.class);
}}
