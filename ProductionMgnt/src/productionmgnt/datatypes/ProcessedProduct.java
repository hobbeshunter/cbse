package productionmgnt.datatypes;

import commontypes.datatypes.Product;

public class ProcessedProduct {
	
	private String status;
	private Product product;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
