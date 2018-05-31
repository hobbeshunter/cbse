package productionmgnt.machines;

import java.util.concurrent.BlockingQueue;

import productionmgnt.datatypes.Process;
import productionmgnt.datatypes.ProcessStatus;
import productionmgnt.services.ProductionMgnt;

public class Painter extends Machine {

	public Painter(BlockingQueue<Process> queue, ProductionMgnt production) {
		super("Painter", queue, production);
	}

	@Override
	public void process(Process p) {
		p.setStatus(ProcessStatus.painting);
		System.out.println("Paint product");
	}

}