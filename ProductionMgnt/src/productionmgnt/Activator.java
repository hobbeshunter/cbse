package productionmgnt;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import commontypes.services.IProductionMgnt;
import productionmgnt.services.ProductionMgnt;

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

		bundleContext.registerService(IProductionMgnt.class, new ProductionMgnt(), null);
		System.out.println("ProductionMgnt online");
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
