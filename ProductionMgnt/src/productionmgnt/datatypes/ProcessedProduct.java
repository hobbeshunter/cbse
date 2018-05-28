package productionmgnt.datatypes;

import commontypes.datatypes.Product;

public class ProcessedProduct {
	
	private String id;
	private String status;
	private Product product;
	
	public ProcessedProduct(String id, Product product) {
		this.setId(id);
		this.product = product;
		this.status = "waiting";
	}

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
