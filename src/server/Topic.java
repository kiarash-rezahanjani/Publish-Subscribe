package server;

import java.util.ArrayList;
import java.util.List;

public class Topic 
{
	String title;
	String hashedTitle;
	int latestPostSeqNo;
	List<post> posts = new ArrayList<post>();
	List<Subscriber> subscribers = new ArrayList<Subscriber>();
	
	public Topic(String title)
	{
		this.title=title;
		latestPostSeqNo=0;
		//hashedTitle=hash...
	}
 
	public List<post> getAllPostFrom(int postSeqNo){
	 
		return null; //Remove later
	}
	public void addPost(){
		
	}
	public void removePost(){
		
	}
	public void addSubscriber(){
		
	}
	public void removeSubscriber(){
		
	}
	private int getPostSeqNo(){
		
		return 0; //Remove later
		
	}

	
}
