package listener;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.ListenerAdapter;
import gov.nasa.jpf.jvm.ClassFile;
import gov.nasa.jpf.report.Publisher;
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


// @author Yonis Abokar 

public class checkStates extends ListenerAdapter implements SearchListener, VMListener {

        private int backPropogation = 0;
        private int expandNode = 0;


        @Override
	public void choiceGeneratorAdvanced(VM vm, ChoiceGenerator<?> currentCG) {
		// TODO Auto-generated method stub
		super.choiceGeneratorAdvanced(vm, currentCG);
		System.out.println("");
	}

	@Override
	public void choiceGeneratorProcessed(VM vm, ChoiceGenerator<?> processedCG) {
		// TODO Auto-generated method stub
		super.choiceGeneratorProcessed(vm, processedCG);
	}

	@Override
	public void choiceGeneratorRegistered(VM vm, ChoiceGenerator<?> nextCG, ThreadInfo currentThread,
			Instruction executedInstruction) {
		// TODO Auto-generated method stub
		super.choiceGeneratorRegistered(vm, nextCG, currentThread, executedInstruction);
	}

	@Override
	public void choiceGeneratorSet(VM vm, ChoiceGenerator<?> newCG) {
		// TODO Auto-generated method stub
		super.choiceGeneratorSet(vm, newCG);
	}

	@Override
	public void classLoaded(VM vm, ClassInfo loadedClass) {
		// TODO Auto-generated method stub
		super.classLoaded(vm, loadedClass);
	}

	@Override
	public void exceptionBailout(VM vm, ThreadInfo currentThread) {
		// TODO Auto-generated method stub
		super.exceptionBailout(vm, currentThread);
	}

	@Override
	public void exceptionHandled(VM vm, ThreadInfo currentThread) {
		// TODO Auto-generated method stub
		super.exceptionHandled(vm, currentThread);
	}

	@Override
	public void exceptionThrown(VM vm, ThreadInfo currentThread, ElementInfo thrownException) {
		// TODO Auto-generated method stub
		super.exceptionThrown(vm, currentThread, thrownException);
	}

	@Override
	public void executeInstruction(VM vm, ThreadInfo currentThread, Instruction instructionToExecute) {
		// TODO Auto-generated method stub
		super.executeInstruction(vm, currentThread, instructionToExecute);
	}

	@Override
	public void gcBegin(VM vm) {
		// TODO Auto-generated method stub
		super.gcBegin(vm);
	}

	@Override
	public void gcEnd(VM vm) {
		// TODO Auto-generated method stub
		super.gcEnd(vm);
	}

	@Override
	public void instructionExecuted(VM vm, ThreadInfo currentThread, Instruction nextInstruction,
			Instruction executedInstruction) {
		// TODO Auto-generated method stub
		super.instructionExecuted(vm, currentThread, nextInstruction, executedInstruction);
	}

	@Override
	public void loadClass(VM vm, ClassFile cf) {
		// TODO Auto-generated method stub
		super.loadClass(vm, cf);
	}

	@Override
	public void methodEntered(VM vm, ThreadInfo currentThread, MethodInfo enteredMethod) {
		// TODO Auto-generated method stub
	    //	super.methodEntered(vm, currentThread, enteredMethod);
	
	    	if (enteredMethod.toString().equals("backPropogation")) {
		    
		    backPropogation++;
		    System.out.println("The expandNode count is"+expandNode);
		    
		}

	        if (enteredMethod.toString().equals("enteredMethod")) {
		    
		    expandNode++;
		    
		}
		
		System.out.println("The backpropogation count"+backPropogation);
		System.out.println("The expandNode count is"+expandNode);


	}

	@Override
	public void methodExited(VM vm, ThreadInfo currentThread, MethodInfo exitedMethod) {
		// TODO Auto-generated method stub
		super.methodExited(vm, currentThread, exitedMethod);

	}

	@Override
	public void objectCreated(VM vm, ThreadInfo currentThread, ElementInfo newObject) {
		// TODO Auto-generated method stub
		super.objectCreated(vm, currentThread, newObject);
	}

	@Override
	public void objectExposed(VM vm, ThreadInfo currentThread, ElementInfo fieldOwnerObject,
			ElementInfo exposedObject) {
		// TODO Auto-generated method stub
		super.objectExposed(vm, currentThread, fieldOwnerObject, exposedObject);
	}

	@Override
	public void objectLocked(VM vm, ThreadInfo currentThread, ElementInfo lockedObject) {
		// TODO Auto-generated method stub
		super.objectLocked(vm, currentThread, lockedObject);
	}

	@Override
	public void objectNotify(VM vm, ThreadInfo currentThread, ElementInfo notifyingObject) {
		// TODO Auto-generated method stub
		super.objectNotify(vm, currentThread, notifyingObject);
	}

	@Override
	public void objectNotifyAll(VM vm, ThreadInfo currentThread, ElementInfo notifyingObject) {
		// TODO Auto-generated method stub
		super.objectNotifyAll(vm, currentThread, notifyingObject);
	}

	@Override
	public void objectReleased(VM vm, ThreadInfo currentThread, ElementInfo releasedObject) {
		// TODO Auto-generated method stub
		super.objectReleased(vm, currentThread, releasedObject);
	}

	@Override
	public void objectShared(VM vm, ThreadInfo currentThread, ElementInfo sharedObject) {
		// TODO Auto-generated method stub
		super.objectShared(vm, currentThread, sharedObject);
	}

	@Override
	public void objectUnlocked(VM vm, ThreadInfo currentThread, ElementInfo unlockedObject) {
		// TODO Auto-generated method stub
		super.objectUnlocked(vm, currentThread, unlockedObject);
	}

	@Override
	public void objectWait(VM vm, ThreadInfo currentThread, ElementInfo waitingObject) {
		// TODO Auto-generated method stub
		super.objectWait(vm, currentThread, waitingObject);
	}

	@Override
	public void propertyViolated(Search search) {
		// TODO Auto-generated method stub
		super.propertyViolated(search);
	}

	@Override
	public void publishConstraintHit(Publisher publisher) {
		// TODO Auto-generated method stub
		super.publishConstraintHit(publisher);
	}

	@Override
	public void publishFinished(Publisher publisher) {
		// TODO Auto-generated method stub
		super.publishFinished(publisher);
	}

	@Override
	public void publishProbe(Publisher publisher) {
		// TODO Auto-generated method stub
		super.publishProbe(publisher);
	}

	@Override
	public void publishPropertyViolation(Publisher publisher) {
		// TODO Auto-generated method stub
		super.publishPropertyViolation(publisher);
	}

	@Override
	public void publishStart(Publisher publisher) {
		// TODO Auto-generated method stub
		super.publishStart(publisher);
	}

	@Override
	public void publishTransition(Publisher publisher) {
		// TODO Auto-generated method stub
		super.publishTransition(publisher);
	}

	@Override
	public void searchConstraintHit(Search search) {
		// TODO Auto-generated method stub
		super.searchConstraintHit(search);
	}

	@Override
	public void searchFinished(Search search) {
		// TODO Auto-generated method stub
		super.searchFinished(search);
	}

	@Override
	public void searchProbed(Search search) {
		// TODO Auto-generated method stub
		super.searchProbed(search);
	}

	@Override
	public void searchStarted(Search search) {
		// TODO Auto-generated method stub
		super.searchStarted(search);
	}

	@Override
	public void stateAdvanced(Search search) {
		// TODO Auto-generated method stub
		super.stateAdvanced(search);
	}

	@Override
	public void stateBacktracked(Search search) {
		// TODO Auto-generated method stub
		super.stateBacktracked(search);
	}

	@Override
	public void stateProcessed(Search search) {
		// TODO Auto-generated method stub
		super.stateProcessed(search);
	}

	@Override
	public void statePurged(Search search) {
		// TODO Auto-generated method stub
		super.statePurged(search);
	}

	@Override
	public void stateRestored(Search search) {
		// TODO Auto-generated method stub
		super.stateRestored(search);
	}

	@Override
	public void stateStored(Search search) {
		// TODO Auto-generated method stub
		super.stateStored(search);
	}

	@Override
	public void threadBlocked(VM vm, ThreadInfo blockedThread, ElementInfo lock) {
		// TODO Auto-generated method stub
		super.threadBlocked(vm, blockedThread, lock);
	}

	@Override
	public void threadInterrupted(VM vm, ThreadInfo interruptedThread) {
		// TODO Auto-generated method stub
		super.threadInterrupted(vm, interruptedThread);
	}

	@Override
	public void threadNotified(VM vm, ThreadInfo notifiedThread) {
		// TODO Auto-generated method stub
		super.threadNotified(vm, notifiedThread);
	}

	@Override
	public void threadScheduled(VM vm, ThreadInfo scheduledThread) {
		// TODO Auto-generated method stub
		super.threadScheduled(vm, scheduledThread);
	}

	@Override
	public void threadStarted(VM vm, ThreadInfo startedThread) {
		// TODO Auto-generated method stub
		super.threadStarted(vm, startedThread);
	}

	@Override
	public void threadTerminated(VM vm, ThreadInfo terminatedThread) {
		// TODO Auto-generated method stub
		super.threadTerminated(vm, terminatedThread);
	}

	@Override
	public void threadWaiting(VM vm, ThreadInfo waitingThread) {
		// TODO Auto-generated method stub
		super.threadWaiting(vm, waitingThread);
	}

	@Override
	public void vmInitialized(VM vm) {
		// TODO Auto-generated method stub
		super.vmInitialized(vm);
	}

	
}
