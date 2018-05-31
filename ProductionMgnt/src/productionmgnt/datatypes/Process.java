package productionmgnt.datatypes;

import commontypes.datatypes.Product;

public class Process {
	
	private String id;
	private ProcessStatus status;
	private Product product;
	
	public Process(String id, Product product) {
		this.setId(id);
		this.product = product;
		this.status = ProcessStatus.waiting;
	}

	public ProcessStatus getStatus() {
		return status;
	}

	public void setStatus(ProcessStatus status) {
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
