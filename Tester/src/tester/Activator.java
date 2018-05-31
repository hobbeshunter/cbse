package tester;

import java.util.LinkedList;
import java.util.List;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import commontypes.datatypes.Product;
import commontypes.services.ICustomerMgnt;
import commontypes.services.IInvoiceMgnt;
import commontypes.services.IProductionMgnt;
//import commontypes.services.IStoreMgnt;

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

		ServiceReference<ICustomerMgnt> customerMgntReference = context.getServiceReference(ICustomerMgnt.class);
		if (customerMgntReference == null) {
			System.out.println("service not found for: " + ICustomerMgnt.class.getCanonicalName());
			return;
		}

		ICustomerMgnt customerMgnt = context.getService(customerMgntReference);
		if (customerMgnt == null) {
			return;
		}

		long hansId = customerMgnt.addCustomer("Hans");
		Product hansFirstProduct = new Product();
		hansFirstProduct.setCustomerId(hansId);

		ServiceReference<IProductionMgnt> productionMgntReference = context.getServiceReference(IProductionMgnt.class);
		if (productionMgntReference == null) {
			System.out.println("service not found for: " + IProductionMgnt.class.getCanonicalName());
			return;
		}

		IProductionMgnt productionMgnt = context.getService(productionMgntReference);
		if (productionMgnt == null) {
			return;
		}

		productionMgnt.comissionProduct(hansFirstProduct);

		ServiceReference<IInvoiceMgnt> invoiceMgntReference = context.getServiceReference(IInvoiceMgnt.class);
		if (invoiceMgntReference == null) {
			System.out.println("service not found for: " + IInvoiceMgnt.class.getCanonicalName());
			return;
		}

		IInvoiceMgnt invoiceMgnt = context.getService(invoiceMgntReference);
		if (invoiceMgnt == null) {
			return;
		}

		List<Product> hansProducts = new LinkedList<>();
		hansProducts.add(hansFirstProduct);
		invoiceMgnt.addInvoice(hansId, hansProducts);

		// ServiceReference<IStoreMgnt> storeMgntReference =
		// context.getServiceReference(IStoreMgnt.class);
		// if (storeMgntReference == null) {
		// System.out.println("service not found for: " +
		// IStoreMgnt.class.getCanonicalName());
		// return;
		// }
		//
		// IStoreMgnt storeMgnt = context.getService(storeMgntReference);
		// if (storeMgnt == null) {
		// return;
		// }

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
