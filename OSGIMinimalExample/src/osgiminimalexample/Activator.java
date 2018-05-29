package osgiminimalexample;

import commontypes.datatypes.Product;
import commontypes.services.IServiceA;
import commontypes.services.IServiceB;
import commontypes.services.IStoreMgnt;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;


public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		
		System.out.println("OSGI Minimal Example started");
		

		ServiceReference<IServiceA> serviceReference = context.getServiceReference(IServiceA.class);
		if (serviceReference==null) { 
			System.out.println("service not found for: "+IServiceA.class.getCanonicalName());
		} else {
			IServiceA service = context.getService(serviceReference);
	
			if (service != null) {
				service.methodA();
			}
		}
		ServiceReference<IStoreMgnt> storeReference = context.getServiceReference(IStoreMgnt.class);
		IStoreMgnt storeService = context.getService(storeReference); 
		long customerId = storeService.register("M3T_Team");
		System.out.println("new Customer registered. Id: " + customerId);
		boolean approved = storeService.approveCustomer(customerId, new Long(12341324));
		System.out.println("new Customer approved: " + approved);
		boolean loggedIn = storeService.login(customerId);
		System.out.println("Customer logged in: " + loggedIn);
		storeService.upload("My_First_Project.xml");
		storeService.deliver(new Product());
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
