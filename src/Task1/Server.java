package Task1;
import Events.*;
import server.*;

import java.util.Random;
import java.util.Vector;
import ports.*;

import se.sics.kompics.*;
import se.sics.kompics.address.Address;
import se.sics.kompics.network.Network;
import se.sics.kompics.p2p.bootstrap.client.BootstrapClient;
import se.sics.kompics.p2p.bootstrap.client.BootstrapClientInit;
import se.sics.kompics.p2p.bootstrap.server.BootstrapServer;
import se.sics.kompics.p2p.fd.FailureDetector;
import se.sics.kompics.p2p.fd.PeerFailureSuspicion;
import se.sics.kompics.p2p.fd.ping.PingFailureDetector;
import se.sics.kompics.p2p.fd.ping.PingFailureDetectorInit;
import se.sics.kompics.timer.Timer;

public class Server extends ComponentDefinition
{
	Negative<NodePort> serverPort = provides(NodePort.class);
	RegisterClient registration =new RegisterClient();
	
	public Server() 
	{
			
		//connect(network, fd.getNegative(Network.class));
		
		
		subscribe(handleInit, control);
		subscribe(handleJoinRequest,serverPort);
		subscribe(handleCreateTopic,serverPort);
		subscribe(handleCreatePost,serverPort );
		subscribe(handleLatestPostsRequest,serverPort );
		subscribe(handleRegisterRequest,serverPort );
	//	subscribe(handleClientFailureSuspicion, fd.getPositive(FailureDetector.class));
		

	}
	
	
	//-------------------------------------------------------------------
	// This handler initiates the Peer component.	
	//-------------------------------------------------------------------
		Handler<Start> handleInit = new Handler<Start>() {
			public void handle(Start init) 
			{
				System.out.println("Server started..");
			}
		};
		
		Handler<JoinRequest> handleJoinRequest = new Handler<JoinRequest>() {
			public void handle(JoinRequest event) 
			{
				System.out.println("Server rec message from client.."+ event.getMessage());
				trigger(new JoinResponse(event), serverPort);
			}
		};
		
		Handler<CreateTopic> handleCreateTopic = new Handler<CreateTopic>() {
			public void handle(CreateTopic event) 
			{

			}
		};
		
		Handler<CreatePost> handleCreatePost = new Handler<CreatePost>() {
			public void handle(CreatePost event) 
			{

			}
		};
		
		Handler<LatestPostsRequest> handleLatestPostsRequest = new Handler<LatestPostsRequest>() {
			public void handle(LatestPostsRequest event) 
			{

			}
		};
		
		Handler<RegisterRequest> handleRegisterRequest = new Handler<RegisterRequest>() {
			public void handle(RegisterRequest event) 
			{
				RegisterResponse response= new RegisterResponse(event);
				response.setRegistrationNumber(registration.getClientID());
				trigger(response, serverPort);
			}
		};
		
	/*	Handler<PeerFailureSuspicion> handleClientFailureSuspicion = new Handler<PeerFailureSuspicion>() {
			public void handle(PeerFailureSuspicion event) 
			{

			}
		}; */
}
