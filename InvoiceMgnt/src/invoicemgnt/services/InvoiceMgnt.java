package invoicemgnt.services;

import java.util.ArrayList;
import java.util.List;

import commontypes.datatypes.Product;
import commontypes.services.IInvoiceMgnt;
import invoicemgnt.datatypes.Invoice;

public class InvoiceMgnt implements IInvoiceMgnt {

	private List<Invoice> invoices = new ArrayList<Invoice>();
	private int idCounter = 0;

	public List<Invoice> getInvoices() {
		return new ArrayList<Invoice>(invoices);
	}

	@Override
	public String addInvoice(long customerId, List<Product> ps) {
		Invoice i = new Invoice("invoice" + idCounter++, customerId, ps);
		invoices.add(i);
		System.out.println("New Invoice: " + i);
		return i.getId();
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
