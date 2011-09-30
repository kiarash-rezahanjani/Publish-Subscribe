package Events;

import se.sics.kompics.Request;
import se.sics.kompics.Response;

public class RegisterResponse extends Response {
	
	int registrationNumber;
	
	public RegisterResponse(Request request){
		super(request);
	}

	/**
	 * @return the registrationNumber
	 */
	public int getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * @param registrationNumber the registrationNumber to set
	 */
	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	

}
