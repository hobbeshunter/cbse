package invoicemgnt.datatypes;

import java.util.List;

import commontypes.datatypes.Product;

import java.util.LinkedList;

public class Invoice {
	private String id;
	private long customerId;
	private List<Product> products;

	public Invoice(String id, long customerId, List<Product> products) {
		this.id = id;
		this.customerId = customerId;
		this.products = new LinkedList<Product>();
	}

	public long getCustomerId() {
		return customerId;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Invoice for customer: " + customerId;
	}

	public String getId() {
		return id;
	}

}
