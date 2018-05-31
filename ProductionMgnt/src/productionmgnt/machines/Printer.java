package productionmgnt.machines;

import java.util.concurrent.BlockingQueue;

import productionmgnt.datatypes.Process;
import productionmgnt.datatypes.ProcessStatus;
import productionmgnt.services.ProductionMgnt;

public class Printer extends Machine {

	public Printer(BlockingQueue<Process> queue, ProductionMgnt production) {
		super("Printer", queue, production);
	}

	@Override
	public void process(Process p) {
		p.setStatus(ProcessStatus.printing);
		System.out.println("Print product");
	}

}
