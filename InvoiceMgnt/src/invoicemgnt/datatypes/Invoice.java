package invoicemgnt.datatypes;

import java.util.List;

import commontypes.datatypes.Product;
import customermgnt.datatypes.Customer;

import java.util.LinkedList;

public class Invoice {
	private Customer customer;
	private String id;
	private List<Product> products;
	private double value;
	private int quantity;

	public Invoice(Customer customer, String id, List<Product> products, double value, int quantity) {
		super();
		this.id = id;
		this.customer = customer;
		this.products = new LinkedList<Product>();
		this.value = value;
		this.quantity = quantity;
	}

	public Invoice(String id) {
		super();
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Invoice:" + id + "For:" + customer + "Containing:" + products + "Price:" + value + "Quantity:"
				+ quantity;
	}

}
