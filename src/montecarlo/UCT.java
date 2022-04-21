package montecarlo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import tree.Node;

public class UCT {

    public static double uctValue(int totalVisit, double nodeWinScore, int nodeVisit) {
        if (nodeVisit == 0) {
            return Integer.MAX_VALUE;
        }
//        System.out.println((nodeWinScore / (double) nodeVisit) + 1.41 * Math.sqrt(Math.log(totalVisit) / (double) nodeVisit));
        return (nodeWinScore / (double) nodeVisit) + 1.41 * Math.sqrt(Math.log(totalVisit) / (double) nodeVisit);
    }

    static Node findBestNodeWithUCT(Node node) {
        int parentVisit = node.getState().getVisitCount();
        return getMax(parentVisit, node.getChildArray());
    
    }
    
    static Node getMax(int parentVisit, List<Node> collection) {
    	Node result = null;
    	double first_value = Double.MIN_VALUE;
    	for (Node node : collection) {
    		if (first_value < uctValue(parentVisit, node.getState().getWinScore(), node.getState().getVisitCount())) {
    			result = node;
    			first_value = uctValue(parentVisit, node.getState().getWinScore(), node.getState().getVisitCount());
    		}
    	}
    	if (result==null) {
    		result = collection.get(0);
    	}
    	return result;
    }
}