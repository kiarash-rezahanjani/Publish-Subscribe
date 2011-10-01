package Task1;
import Events.*;
import server.*;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Vector;

import org.apache.commons.math.util.OpenIntToDoubleHashMap.Iterator;

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
import util.Post;
import util.Topic;

public class Server extends ComponentDefinition
{
	Negative<NodePort> serverPort = provides(NodePort.class);
	RegisterClient registration =new RegisterClient();
	HashMap<Object, TopicManager> topicList = new HashMap<Object, TopicManager>();;
	
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
				Object titleHash = ConsistentHashing.hashCode(event.getTopic().getTitle());
				TopicManager topicManager = new TopicManager(event.getTopic().getTitle() , titleHash);
				topicList.put(titleHash, topicManager);
			}
		};
		
		Handler<CreatePost> handleCreatePost = new Handler<CreatePost>() {
			public void handle(CreatePost event) 
			{
				Object hashedTitle = ConsistentHashing.hashCode( event.getPost().getTitle() );
				TopicManager tm = topicList.get(hashedTitle);
				tm.addPost(event.getPost());
				sendNewPostToSubsribers(tm, event.getPost());
			}


		};
		
		Handler<LatestPostsRequest> handleLatestPostsRequest = new Handler<LatestPostsRequest>() {
			public void handle(LatestPostsRequest event) 
			{
				HashMap<Object, Integer> subStatus = event.getSubscriptionStatus();
				Iterator it = (Iterator) subStatus.entrySet().iterator();
				//for(int i=0 ; i< subStatus.size(); i++)
				while(it.hasNext())
				{
					if(!topicList.containsKey(it.key()))
						continue;
					
					TopicManager tm = topicList.get(it.key());
					
					if(tm.getLatestPostSeqNo() <= (int)it.value())
						continue;
					
					trigger(new LatestPostResponse(event, tm.getAllPostFrom( (int) it.value())), serverPort);
					
				}
				

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
		
		private void sendNewPostToSubsribers(TopicManager tm, Post post) 
		{
			
			
		}
}
