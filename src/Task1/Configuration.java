package Task1;

import src.*;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;

import se.sics.kompics.address.Address;
import se.sics.kompics.network.NetworkConfiguration;
import se.sics.kompics.network.Transport;
import se.sics.kompics.p2p.bootstrap.BootstrapConfiguration;
import se.sics.kompics.p2p.fd.ping.PingFailureDetectorConfiguration;

public class Configuration {
	
	public static BigInteger SOURCE_ID = BigInteger.ZERO;
	
	public InetAddress ip = null;
	{
		try {
			ip = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
		}
	}
	
	int networkPort = 8081;
	int webPort = 8080;
	int bootId = Integer.MAX_VALUE;

//	Address bootServerAddress = new Address(ip, networkPort, bootId);
	Address server = new Address(ip, networkPort, 0);

//	BootstrapConfiguration bootConfiguration = new BootstrapConfiguration(bootServerAddress, 60000, 4000, 3, 30000, webPort, webPort);
	PingFailureDetectorConfiguration fdConfiguration = new PingFailureDetectorConfiguration(10000, 50000, 5000, 1000, Transport.TCP);
//	NetworkConfiguration networkConfiguration = new NetworkConfiguration(ip, networkPort, 0);
//	PeerConfiguration peerConfiguration = new PeerConfiguration(3, 10000);

//-------------------------------------------------------------------	
	public void set() throws IOException {
		
		String c = File.createTempFile("ping.fd.", ".conf").getAbsolutePath();
		fdConfiguration.store(c);
		System.setProperty("ping.fd.configuration", c);
/*		
		c = File.createTempFile("bootstrap.", ".conf").getAbsolutePath();
		bootConfiguration.store(c);
		System.setProperty("bootstrap.configuration", c);	
		
		c = File.createTempFile("network.", ".conf").getAbsolutePath();
		networkConfiguration.store(c);
		System.setProperty("network.configuration", c);

		c = File.createTempFile("ms.", ".conf").getAbsolutePath();
		peerConfiguration.store(c);
		System.setProperty("ms.configuration", c);
*/
	}
}
