package commontypes.services;

import java.util.List;

import commontypes.datatypes.Product;

public interface IInvoiceMgnt {
	
	public String addInvoice(long customerId, List<Product> ps);
	public void removeInvoice(String id);	

}
