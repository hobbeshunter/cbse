package customermgnt;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import commontypes.services.ICustomerMgnt;
import customermgnt.services.CustomerMgnt;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;

		bundleContext.registerService(ICustomerMgnt.class, new CustomerMgnt(), null);
		System.out.println("CustomerMgnt online");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
