package server;

import java.util.ArrayList;
import java.util.List;

import util.*;


public class TopicManager 
{
	String title;
	Object hashedTitle;
	int latestPostSeqNo;
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLatestPostSeqNo() {
		return latestPostSeqNo;
	}

	public void setLatestPostSeqNo(int latestPostSeqNo) {
		this.latestPostSeqNo = latestPostSeqNo;
	}

	List<Post> posts = new ArrayList<Post>();
	List<Subscriber> subscribers = new ArrayList<Subscriber>();
	
	public TopicManager(String title, Object hashedTitle)
	{
		this.title=title;
		latestPostSeqNo=-1;// read from file later
		this.hashedTitle=hashedTitle;
		
	}
	
	public TopicManager(String title)
	{
		this.title=title;
		latestPostSeqNo=-1;// read from file later
		//hashedTitle=hash...
	}
 
	public List<Post> getAllPostFrom(int postSeqNo)
	{
		int nextPostSeqNo=postSeqNo++;
		
		if(posts.get(nextPostSeqNo).getSeqNo() != nextPostSeqNo)
			System.out.println("Error my friend: getAllPostFrom(int postSeqNo)");
		
		return posts.subList(nextPostSeqNo, posts.size()-1);
	}
	
	public void addPost(Post post)
	{
		post.setSeqNo(this.getNextPostSeqNo());
		posts.add(post);
	}
	
	public void removePost(Post post)
	{
		//watch out the seq numbers and index relation
		posts.remove(post);
	}
	
	public void addSubscriber(Subscriber sub)
	{
		subscribers.add(sub);
	}
	
	public void removeSubscriber(Subscriber sub)
	{
		subscribers.remove(sub);
	}
	
	private int getNextPostSeqNo()
	{
		return latestPostSeqNo++; 	
	}

	
}
