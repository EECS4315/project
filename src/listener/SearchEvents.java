package listener;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import gov.nasa.jpf.jvm.ClassFile;
import gov.nasa.jpf.search.Search;
import gov.nasa.jpf.search.SearchListener;
import gov.nasa.jpf.search.SearchListenerAdapter;
import gov.nasa.jpf.vm.ChoiceGenerator;
import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.MethodInfo;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.VM;
import gov.nasa.jpf.vm.VMListener;

/*
 * @author Jamie Dishy
 */
public class SearchEvents extends SearchListenerAdapter implements SearchListener, VMListener {
	private int source;
	private int target;

	private PrintWriter writer;
	
	private int maxAmountNonDetermisim;
	

	public SearchEvents() {
		this.source = -1;
		this.target = -1;
		this.maxAmountNonDetermisim = 0;
	}

	
	@Override
	public void propertyViolated(Search arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void searchConstraintHit(Search arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void searchFinished(Search search) {
		this.writer.println("}");
		this.writer.close();
		System.out.printf("%n======================================================%n");
		System.out.printf("maximum amount of nondeterminism: %d choice(s)%n", this.maxAmountNonDetermisim);
	}

	@Override
	public void searchProbed(Search arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void searchStarted(Search search) {
		String name = search.getVM().getSUTName() + ".dot";
		try {
			this.writer = new PrintWriter(name);
			this.writer.println("digraph statespace {");
			this.writer.println("node [style=filled]");
			this.writer.println("0 [fillcolor=green]");
		} catch (FileNotFoundException e) {
			System.out.println("Listener could not write to file " + name);
			search.terminate();
		}

	}

	@Override
	public void stateAdvanced(Search search) {
		this.source = this.target;
		this.target = search.getStateId();
		if (this.source != -1) {
			this.writer.printf("%d -> %d%n", source, target);
		}
		if (search.isEndState()) {
			writer.printf("%d [fillcolor=red]%n", target);
		}
	}

	@Override
	public void stateBacktracked(Search arg0) {
		this.target = arg0.getStateId();

	}

	@Override
	public void stateProcessed(Search arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void statePurged(Search arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void stateRestored(Search arg0) {
		this.target = arg0.getStateId();

	}

	@Override
	public void choiceGeneratorAdvanced(VM arg0, ChoiceGenerator<?> arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void choiceGeneratorProcessed(VM arg0, ChoiceGenerator<?> arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void choiceGeneratorRegistered(VM arg0, ChoiceGenerator<?> arg1, ThreadInfo arg2, Instruction arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void choiceGeneratorSet(VM arg0, ChoiceGenerator<?> newCG) {
		this.maxAmountNonDetermisim = Math.max(this.maxAmountNonDetermisim, newCG.getTotalNumberOfChoices());
	}

	@Override
	public void classLoaded(VM arg0, ClassInfo arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exceptionBailout(VM arg0, ThreadInfo arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exceptionHandled(VM arg0, ThreadInfo arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exceptionThrown(VM arg0, ThreadInfo arg1, ElementInfo arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executeInstruction(VM arg0, ThreadInfo arg1, Instruction arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gcBegin(VM arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gcEnd(VM arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void instructionExecuted(VM arg0, ThreadInfo arg1, Instruction arg2, Instruction arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadClass(VM arg0, ClassFile arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void methodEntered(VM arg0, ThreadInfo arg1, MethodInfo arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void methodExited(VM arg0, ThreadInfo arg1, MethodInfo arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void objectCreated(VM arg0, ThreadInfo arg1, ElementInfo arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void objectExposed(VM arg0, ThreadInfo arg1, ElementInfo arg2, ElementInfo arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void objectLocked(VM arg0, ThreadInfo arg1, ElementInfo arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void objectNotify(VM arg0, ThreadInfo arg1, ElementInfo arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void objectNotifyAll(VM arg0, ThreadInfo arg1, ElementInfo arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void objectReleased(VM arg0, ThreadInfo arg1, ElementInfo arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void objectShared(VM arg0, ThreadInfo arg1, ElementInfo arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void objectUnlocked(VM arg0, ThreadInfo arg1, ElementInfo arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void objectWait(VM arg0, ThreadInfo arg1, ElementInfo arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void threadBlocked(VM arg0, ThreadInfo arg1, ElementInfo arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void threadInterrupted(VM arg0, ThreadInfo arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void threadNotified(VM arg0, ThreadInfo arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void threadScheduled(VM arg0, ThreadInfo arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void threadStarted(VM arg0, ThreadInfo arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void threadTerminated(VM arg0, ThreadInfo arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void threadWaiting(VM arg0, ThreadInfo arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vmInitialized(VM arg0) {
		// TODO Auto-generated method stub
		
	}

}
