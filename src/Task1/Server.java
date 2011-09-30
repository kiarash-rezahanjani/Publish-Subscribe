package Task1;
import Events.*;

import id2210.system.peer.PeerAddress;

import java.util.Random;
import java.util.Vector;

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
import src.*;

public class Server extends ComponentDefinition
{

	Address myAddress;
	PeerAddress myPeerAdress;
	Component fd;
	Random rand;
	
	public Server() 
	{
		//fdRequests = new HashMap<Address, UUID>();
		//fdPeers = new HashMap<Address, PeerAddress>();
		//server=Configuration.server;
		//bootStrapServer= create(BootstrapServer.class);
		
		fd = create(PingFailureDetector.class);
		rand = new Random(System.currentTimeMillis());
		
		connect(network, fd.getNegative(Network.class));
		connect(network, bootstrap.getNegative(Network.class));
		connect(timer, fd.getNegative(Timer.class));
		connect(timer, bootstrap.getNegative(Timer.class));
		
		subscribe(handleInit, control);
		subscribe(handleJoinRequest, );
		subscribe(handleCreateTopic, );
		subscribe(handleCreatePost, );
		subscribe(handleLatestPostsRequest, );
		subscribe(handleClientFailureSuspicion, fd.getPositive(FailureDetector.class));
		

	}
	
	
	//-------------------------------------------------------------------
	// This handler initiates the Peer component.	
	//-------------------------------------------------------------------
		Handler<InitEvent> handleInit = new Handler<InitEvent>() {
			public void handle(InitEvent init) {
				/*
				peerSelf = init.getMSPeerSelf();
				self = peerSelf.getPeerAddress();
				friends = new Vector<PeerAddress>();
				msgPeriod = init.getMSConfiguration().getSnapshotPeriod();

				viewSize = init.getMSConfiguration().getViewSize();

				trigger(new BootstrapClientInit(self, init.getBootstrapConfiguration()), bootstrap.getControl());
				trigger(new PingFailureDetectorInit(self, init.getFdConfiguration()), fd.getControl());
			*/
			}
		};
		
		Handler<JoinRequest> handleJoinRequest = new Handler<JoinRequest>() {
			public void handle(JoinRequest event) 
			{

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
		
		Handler<PeerFailureSuspicion> handleClientFailureSuspicion = new Handler<PeerFailureSuspicion>() {
			public void handle(PeerFailureSuspicion event) 
			{

			}
		};
}
