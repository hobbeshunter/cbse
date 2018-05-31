package productionmgnt.services;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import commontypes.datatypes.Product;
import commontypes.services.IProductionMgnt;
import productionmgnt.datatypes.Process;
import productionmgnt.machines.Finisher;
import productionmgnt.machines.Painter;
import productionmgnt.machines.Printer;

public class ProductionMgnt implements IProductionMgnt {

	private List<Process> processes = new LinkedList<>();
	private int idCounter = 0;
	private BlockingQueue<Process> printQueue = new LinkedBlockingQueue<>();
	private BlockingQueue<Process> paintQueue = new LinkedBlockingQueue<>();
	private BlockingQueue<Process> finishQueue = new LinkedBlockingQueue<>();

	private Printer printer;
	private Painter painter;
	private Finisher finisher;

	public ProductionMgnt() {
		this.printer = new Printer(printQueue, this);
		this.printer.start();
		this.painter = new Painter(paintQueue, this);
		this.painter.start();
		this.finisher = new Finisher(finishQueue, this);
		this.finisher.start();
	}

	@Override
	public String comissionProduct(Product product) {
		Process p = new Process("product" + idCounter++, product);
		processes.add(p);
		forwardProcess(p);
		System.out.println("Commissioned new product for production");
		return p.getId();
	}

	@Override
	public String getStatus(String id) {
		for (Process p : this.processes) {
			if (id.equals(p.getId())) {
				return p.getStatus().toString();
			}
		}
		return null;
	}

	public void forwardProcess(Process p) {
		try {
			switch (p.getStatus()) {
			case waiting:
				printQueue.put(p);
				break;
			case printing:
				paintQueue.put(p);
				break;
			case painting:
				finishQueue.put(p);
				break;
			case finishing:
				// TODO notify invoice
				System.out.println("Process finished");
			default:
				break;
			}
		} catch (InterruptedException e) {
		}
	}

}
