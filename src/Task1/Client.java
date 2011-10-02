package Task1;

import ports.NodePort;

import java.util.*;

import events.*;
import se.sics.kompics.ComponentDefinition;
import se.sics.kompics.Handler;
import se.sics.kompics.Positive;
import se.sics.kompics.Start;
import util.Post;
import util.Topic;



public class Client extends ComponentDefinition
{

	Positive<NodePort> clientPort = requires(NodePort.class);
	HashMap<Object, Integer> subscriptionStatus = new HashMap<Object , Integer>(); 
	int myRegistrationNumber;
	
	public Client() 
	{		
		// connect channels and then define subscription for handlers.
		subscribe(handleInit, control);
		subscribe(handleJoinResponse,clientPort);
		subscribe(handleNewTopic,clientPort);
		subscribe(handleNewPost,clientPort );
		subscribe(handleLatestPostsResponse,clientPort );
		subscribe(handleRegisterResponse,clientPort );
	}
	
	//-------------------------------------------------------------------
	// This handler initiates the Peer component.	
	//-------------------------------------------------------------------
		Handler<Start> handleInit = new Handler<Start>() {
			public void handle(Start init) 
			{
				System.out.println("Client started..");
				trigger(new RegisterRequest(), clientPort);
				
			}
		};
		
		Handler<JoinResponse> handleJoinResponse = new Handler<JoinResponse>() {
			public void handle(JoinResponse event) 
			{
				System.out.println("Client No: " + myRegistrationNumber + " Rec JoinResponse From Server..");

				requestLatestPosts();

			}
		};
		
		Handler<NewTopic> handleNewTopic = new Handler<NewTopic>() {
			public void handle(NewTopic event) 
			{
				System.out.println("NewTopic Rec by: " + myRegistrationNumber + " Topic: " +event.getTopic().getTitle());
				
			}
		};
		
		Handler<NewPost> handleNewPost = new Handler<NewPost>() {
			public void handle(NewPost event) 
			{
				System.out.println("NewPost C-ID "+ myRegistrationNumber + " Title:" + event.getPost().getTitle() + "SeqNo " + event.getPost().getSeqNo());
			}
		};
		
		Handler<LatestPostResponse> handleLatestPostsResponse = new Handler<LatestPostResponse>() {
			public void handle(LatestPostResponse event) 
			{
				List<Post> posts = event.getPostList();
				
				for(Post post: posts)
				{
					System.out.println("ID "+ myRegistrationNumber + " Post " +  post.getSeqNo());
				}
				
				posts.get(posts.size()-1).getSeqNo();
			}
		};
		
		Handler<RegisterResponse> handleRegisterResponse = new Handler<RegisterResponse>() {
			public void handle(RegisterResponse event) 
			{
				myRegistrationNumber = event.getRegistrationNumber();
				
				//For Testing only 
				trigger(new JoinRequest(), clientPort);
				
			} 
		};
		
	/*	Handler<PeerFailureSuspicion> handleClientFailureSuspicion = new Handler<PeerFailureSuspicion>() {
			public void handle(PeerFailureSuspicion event) 
			{

			}
		}; */
		public void requestLatestPosts()
		{
			if(subscriptionStatus.size()>0)
			{
				trigger( new LatestPostsRequest(subscriptionStatus), clientPort );
				System.out.println("LatestPost Req From:" + myRegistrationNumber );
			}
		}
		
		public void subscribeTo(Topic topic)
		{
			trigger(new SubscriptionRequest(topic), clientPort);
		}
		
		public void unSubscribeFrom(Topic topic)
		{
			trigger(new UnsubscribeRequest(topic), clientPort);
		}
		
		public void createTopic(Topic topic)
		{
			
			trigger(new CreateTopic(topic), clientPort);
		}
		
		public void createPost(Post post)
		{
			trigger(new CreatePost(post), clientPort);
		}
}
