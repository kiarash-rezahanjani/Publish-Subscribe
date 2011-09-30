package Task1;

import ports.NodePort;
import Events.InitEvent;
import Events.JoinRequest;
import Events.JoinResponse;
import Events.LatestPostResponse;
import Events.NewPost;
import Events.NewTopic;
import Events.RegisterRequest;
import Events.RegisterResponse;

import se.sics.kompics.ComponentDefinition;
import se.sics.kompics.Handler;
import se.sics.kompics.Positive;
import se.sics.kompics.Start;

public class Client extends ComponentDefinition
{

	Positive<NodePort> clientPort = requires(NodePort.class);
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
				System.out.println("Client No: "+myRegistrationNumber+ " Rec Message From Server..");
			}
		};
		
		Handler<NewTopic> handleNewTopic = new Handler<NewTopic>() {
			public void handle(NewTopic event) 
			{

			}
		};
		
		Handler<NewPost> handleNewPost = new Handler<NewPost>() {
			public void handle(NewPost event) 
			{

			}
		};
		
		Handler<LatestPostResponse> handleLatestPostsResponse = new Handler<LatestPostResponse>() {
			public void handle(LatestPostResponse event) 
			{

			}
		};
		
		Handler<RegisterResponse> handleRegisterResponse = new Handler<RegisterResponse>() {
			public void handle(RegisterResponse event) 
			{
				myRegistrationNumber = event.getRegistrationNumber();
			}
		};
		
	/*	Handler<PeerFailureSuspicion> handleClientFailureSuspicion = new Handler<PeerFailureSuspicion>() {
			public void handle(PeerFailureSuspicion event) 
			{

			}
		}; */
}
