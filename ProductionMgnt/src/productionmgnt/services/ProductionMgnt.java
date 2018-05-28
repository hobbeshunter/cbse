package productionmgnt.services;

import java.util.LinkedList;
import java.util.List;

import commontypes.datatypes.Product;
import commontypes.services.IProductionMgnt;
import productionmgnt.datatypes.ProcessedProduct;

public class ProductionMgnt implements IProductionMgnt {
	
	private List<ProcessedProduct> processedProducts;
	
	public ProductionMgnt() {
		processedProducts = new LinkedList<ProcessedProduct>();
	}

	@Override
	public String comissionProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStatus(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
