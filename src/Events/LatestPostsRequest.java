package events;

import java.util.HashMap;

import se.sics.kompics.Request;

public class LatestPostsRequest extends Request
{
	HashMap<Object, Integer> subscriptionStatus;

	public LatestPostsRequest(HashMap<Object, Integer> subscriptionStatus) {
		
		this.subscriptionStatus = subscriptionStatus;
	}

	public HashMap<Object, Integer> getSubscriptionStatus() {
		return subscriptionStatus;
	}

	public void setSubscriptionStatus(HashMap<Object, Integer> subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	} 

}
