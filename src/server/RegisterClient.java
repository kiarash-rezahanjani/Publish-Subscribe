package server;

public class RegisterClient {
	
	int lastNumber;
	
	public RegisterClient()
	{
		lastNumber=0;
	}

	public int getClientID()
	{
		return lastNumber++;
	}
}
