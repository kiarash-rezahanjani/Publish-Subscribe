package Events;

import se.sics.kompics.Request;
import util.*;

public class CreatePost extends Request
{

	Post post;

	public CreatePost(Post post) 
	{
		this.post = post;
	}
	
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}



}
