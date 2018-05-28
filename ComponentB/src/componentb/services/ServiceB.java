package componentb.services;

import commontypes.services.IServiceB;

public class ServiceB implements IServiceB{

	@Override
	public String getParameter() {
		return "test";
	}

}
