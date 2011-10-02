package events;

import se.sics.kompics.Request;
import se.sics.kompics.Response;
import util.Post;

import java.util.*;

public class LatestPostResponse extends Response 
{
	List<Post> postList;
	
	public LatestPostResponse(Request request, List<Post> postList)
	{
		super(request);
		this.postList = postList;
	}

	public List<Post> getPostList() {
		return postList;
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}

}
