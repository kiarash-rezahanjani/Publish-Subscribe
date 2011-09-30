package Task1;

	
import ports.NodePort;
import se.sics.kompics.Channel;
import se.sics.kompics.Component;
import se.sics.kompics.ComponentDefinition;
import se.sics.kompics.Handler;
import se.sics.kompics.Kompics;
import se.sics.kompics.Start;
public class MainClass extends ComponentDefinition {
	
	Component server, client1 , client2;
	Channel c1,c2;
	
	public MainClass()
	{
		server=create(Server.class);
		client1=create(Client.class);
		client2=create(Client.class);
		c1=connect(server.provided(NodePort.class), client1.required(NodePort.class));
		c2=connect(server.provided(NodePort.class), client2.required(NodePort.class));
		//trigger(new InitEvent(), Control);
	}
	
	public static void main(String[] args) 
	{
			Kompics.createAndStart(MainClass.class);
			
	}
			
}