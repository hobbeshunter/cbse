package osgiminimalexample;

import commontypes.services.IServiceA;
import commontypes.services.IServiceB;

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
	}
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}