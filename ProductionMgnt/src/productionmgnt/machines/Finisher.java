package productionmgnt.machines;

import java.util.concurrent.BlockingQueue;

import productionmgnt.datatypes.Process;
import productionmgnt.datatypes.ProcessStatus;
import productionmgnt.services.ProductionMgnt;

public class Finisher extends Machine {

	public Finisher(BlockingQueue<Process> queue, ProductionMgnt production) {
		super("Finisher", queue, production);
	}

	@Override
	public void process(Process p) {
		p.setStatus(ProcessStatus.finishing);
		System.out.println("Finish product");
	}

}