package productionmgnt.services;

import java.util.LinkedList;
import java.util.List;

import commontypes.datatypes.Product;
import commontypes.services.IProductionMgnt;
import productionmgnt.datatypes.ProcessedProduct;

public class ProductionMgnt implements IProductionMgnt {

	private List<ProcessedProduct> processedProducts;
	private int idCounter = 0;

	public ProductionMgnt() {
		processedProducts = new LinkedList<ProcessedProduct>();
	}

	@Override
	public String comissionProduct(Product product) {
		ProcessedProduct p = new ProcessedProduct("product" + idCounter++, product);
		processedProducts.add(p);

		return p.getId();
	}

	@Override
	public String getStatus(String id) {
		for (ProcessedProduct p : this.processedProducts) {
			if (id.equals(p.getId())) {
				return p.getStatus();
			}
		}
		return null;
	}

}
