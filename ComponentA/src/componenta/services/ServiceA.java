package componenta.services;


import commontypes.services.IServiceA;
import commontypes.services.IServiceB;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.BundleContext;

public class ServiceA implements IServiceA {

	private BundleContext context;

	public ServiceA(BundleContext context) {
		this.context = context;
	}

	@Override
	public void methodA() {
		ServiceReference<IServiceB> serviceReference = context.getServiceReference(IServiceB.class);
		IServiceB service = context.getService(serviceReference);

		if (service != null) {
			System.out.println("In methodA of ServiceA. Parameter=" + service.getParameter());
		}
	}

}
