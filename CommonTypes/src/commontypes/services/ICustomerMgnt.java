package commontypes.services;

//import customermgnt.datatypes.Customer;

public interface ICustomerMgnt {
	
	public long addCustomer(String name);
	public boolean removeCustomer(long id);

}
