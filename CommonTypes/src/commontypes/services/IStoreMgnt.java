package commontypes.services;

import commontypes.datatypes.Product;

public interface IStoreMgnt {
	
	//return customerId
	public long register(String name);
	public boolean approveCustomer(long customerId, long verificationToken);
	public boolean login(long customerId);
	//snake case for better reading. i'm sorry.
	public boolean upload(Object customer_3D_print_job);
	public void deliver(Product product);
}
