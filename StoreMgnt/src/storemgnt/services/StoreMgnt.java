package storemgnt.services;


import commontypes.datatypes.Product;
import commontypes.services.ICustomerMgnt;
import commontypes.services.IProductionMgnt;
import commontypes.services.IStoreMgnt;
import storemgnt.datatypes.Session;
import storemgnt.datatypes.Store;
import storemgnt.datatypes.StoreSessionState;

import org.osgi.framework.ServiceReference;
import org.osgi.framework.BundleContext;

public class StoreMgnt implements IStoreMgnt{
	
	private BundleContext context;
	private ICustomerMgnt customerService;
	//private IInvoiceMgnt invoceSercice;
	private IProductionMgnt productionService;
	private Store store;

	public StoreMgnt(BundleContext context) {
		this.context = context;
		this.store = new Store(new Session(-1, StoreSessionState.GUEST));
	}

	@Override
	public long register(String name) {
		return this.customerService.addCustomer(name);
	}

	@Override
	public boolean approveCustomer(long customerId, long verificationToken) {
		//if everything fine and token is ok, then:
		this.store.setSession(new Session(customerId, StoreSessionState.AUTHORIZED));
		return true;
	}

	@Override
	public boolean login(long customerId) {
		//if everything fine with login values and such:
		this.store.setSession(new Session(customerId, StoreSessionState.AUTHORIZED));
		return true;
	}

	@Override
	public boolean upload(Object customer_3d_print_job) {
		//WOOAH! SOME MAGIC UPLOAD-SERIVCE IS TRIGGERED,
		//that turns printJob into Product specification
		// Product p = magicUploadService(customer_3d_print_job)
		Product p = new Product();
		//if this.invoiceService.isPaid?, then:
		this.productionService.comissionProduct(p);
		return true;
		//else, then:
		//return false;
	}

	@Override
	public void deliver(Product product) {
		// TODO Auto-generated method stub
		// GOTO post office.
		// CALL customer.
		System.out.println("delivered.");
	}
	
}
