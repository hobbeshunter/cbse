package storemgnt.datatypes;

public class Store {
	
	private final String version;
	private ShoppingCart cart;
	private Session session;
	
	public Store(Session session) {
		this.version = "1.0.0";
		this.session = session;
		this.cart = new ShoppingCart(session.getCustomerId());
	}
	
	public String getVersion() {
		return version;
	}
	
	public ShoppingCart getCart() {
		return cart;
	}
	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
}
