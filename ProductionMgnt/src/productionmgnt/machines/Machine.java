package productionmgnt.machines;

import java.util.concurrent.BlockingQueue;

import productionmgnt.datatypes.Process;
import productionmgnt.services.ProductionMgnt;

public abstract class Machine implements Runnable {
	private BlockingQueue<Process> queue;
	private Thread t;
	private String machineName;
	private ProductionMgnt production;
	
	public Machine(String name, BlockingQueue<Process> queue, ProductionMgnt production) {
		this.machineName = name;
		this.queue = queue;
		this.production = production;
	}

	public void run() {
		try {
			while(true) {
				Process p = queue.take();
				process(p);
				Thread.sleep(1000);
				production.forwardProcess(p);
			}
		} catch (InterruptedException e) {
			System.out.println("Machine " + machineName + " interrupted.");
		}
		System.out.println("Machine " + machineName + " exiting.");
	}
	
	public abstract void process(Process p);

	public void start() {
		System.out.println("Starting " + machineName);
		if (t == null) {
			t = new Thread(this, machineName);
			t.start();
		}
	}

}
