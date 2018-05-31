package customermgnt.services;

import java.util.LinkedList;
import java.util.List;

import commontypes.services.ICustomerMgnt;
import customermgnt.datatypes.Customer;

public class CustomerMgnt implements ICustomerMgnt {

	private List<Customer> customers;
	private int id_counter = 0;

	public CustomerMgnt() {
		this.customers = new LinkedList<Customer>();
	}

	@Override
	public long addCustomer(String name) {
		Customer c = new Customer(id_counter, name);
		customers.add(c);
		id_counter++;
		return c.getId();
	}

	@Override
	public boolean removeCustomer(long id) {
		for (Customer c : customers) {
			if (c.getId() == id) {
				customers.remove(c);
				return true;
			}
		}
		return false;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

}
