package invoicemgnt.services;

import java.util.ArrayList;
import java.util.List;

import commontypes.services.IInvoiceMgnt;
import invoicemgnt.datatype.Invoice;

public class InvoiceMgnt implements IInvoiceMgnt {
	
	private List<Invoice> invoices;
	
	public InvoiceMgnt() {
		this.invoices = new ArrayList<Invoice>();
	}
	
	public List<Invoice> getInvoices(){return new ArrayList<Invoice>(invoices);}
	
	@Override
	public void addInvoice (String id) {
		Invoice invoice = new Invoice(id);
		invoices.add(invoice);
	}
	
	@Override
	public void removeInvoice(String id) {
		for (Invoice invoice : invoices) 
			if (invoice.getId().equals(id))
				invoices.remove(invoice);
		
	}
	
	public Invoice getInvoice(String id) {
		for (Invoice invoice : invoices) 
			if (invoice.getId().equals(id))
				return invoice;
		return null;
	}

}
