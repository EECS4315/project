package listener;

import gov.nasa.jpf.ListenerAdapter;
import gov.nasa.jpf.search.Search;
import gov.nasa.jpf.search.SearchListener;
import gov.nasa.jpf.vm.VMListener;

// author Yonis Abokar

public class MonteCarloDepth extends ListenerAdapter implements SearchListener {


	public  void stateAdvanced(Search search) {
		
		System.out.println("The state for the game is" + search.getDepth());
		
	}


    	public void stateBacktracked(Search search) {
		
		System.out.println("The depth for state backtracked" + search.getDepth());
		
	}

	
	
	
	
	
	
}
