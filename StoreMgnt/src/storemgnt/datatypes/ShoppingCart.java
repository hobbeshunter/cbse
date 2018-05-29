package storemgnt.datatypes;

import commontypes.datatypes.Product;

import java.util.LinkedList;
import java.util.List;

class ShoppingCart {

	private final long customerId;
	private List<Product> items;
	//depends on Invoice which is not implemented yet
	//private float sum;
	public ShoppingCart(long customerId) {
		super();
		this.customerId = customerId;
		this.items = new LinkedList<Product>();
	}
	
	public List<Product> getItems() {
		return items;
	}
	
	public void setItems(List<Product> items) {
		this.items = items;
	}
	
	public long getCustomerId() {
		return customerId;
	}
	
}
