package commontypes.services;

import commontypes.datatypes.Product;

public interface IProductionMgnt {
	/**
	 * 
	 * @param product Product to queue for production
	 * @return id of @Product in ProductionProcess
	 */
	public String comissionProduct(Product product);
	
	/**
	 * 
	 * @param id
	 * @return status of production
	 */
	public String getStatus(String id);

}
