package Task1;

import src.*;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import java.util.Vector;

import Events.InitEvent;

import se.sics.kompics.ComponentDefinition;
import se.sics.kompics.Handler;
import se.sics.kompics.address.Address;
import se.sics.kompics.network.Network;
import se.sics.kompics.p2p.bootstrap.P2pBootstrap;
import se.sics.kompics.p2p.bootstrap.client.BootstrapClient;
import se.sics.kompics.p2p.bootstrap.client.BootstrapClientInit;
import se.sics.kompics.p2p.fd.FailureDetector;
import se.sics.kompics.p2p.fd.ping.PingFailureDetector;
import se.sics.kompics.p2p.fd.ping.PingFailureDetectorInit;
import se.sics.kompics.timer.Timer;

public class Client extends ComponentDefinition
{
 
	int rand;
	
	public Client() 
	{
		//fdRequests = new HashMap<Address, UUID>();
		//fdPeers = new HashMap<Address, PeerAddress>();
		//bootstrap = create(BootstrapClient.class);
		rand = new Random(System.currentTimeMillis());

		fd = create(PingFailureDetector.class);
		
		
		connect(network, fd.getNegative(Network.class));
		connect(network, bootstrap.getNegative(Network.class));
		connect(timer, fd.getNegative(Timer.class));
		connect(timer, bootstrap.getNegative(Timer.class));
		
		subscribe(handleInit, control);
		subscribe(handleJoinResponse, msPeerPort);
		subscribe(handleLatestPostReponse, timer);
		subscribe(handleNewPost, fd.getPositive(FailureDetector.class));
		subscribe(handle, network);
		
	
	}
	
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
}
