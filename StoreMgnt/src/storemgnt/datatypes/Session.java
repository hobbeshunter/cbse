package storemgnt.datatypes;

public class Session {

	
	private final long customerId;
	private StoreSessionState state;
	
	
	public Session(long customerId, StoreSessionState state) {
		this.customerId = customerId;
		this.state = state;	
	}

	public StoreSessionState getState() {
		return state;
	}

	public void setState(StoreSessionState state) {
		this.state = state;
	}

	public long getCustomerId() {
		return customerId;
	}
	
}
