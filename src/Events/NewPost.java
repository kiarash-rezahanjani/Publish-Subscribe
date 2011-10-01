package Events;

import se.sics.kompics.Event;
import util.Post;

public class NewPost extends Event 
{
	Post post;

	public NewPost(Post post) 
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