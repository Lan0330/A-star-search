
import java.util.ArrayList;

/**
 * AStar class which including A* search algorithm
 * @author Lan
 *
 */
public class AStar {
	
	private State state;
	
	/**
	 * Construct a new AStar
	 * @param state
	 */
	public AStar(State state) {
		this.state = state;
	}
	
	/**
	 * Return the node with minimum F value in an arrayList
	 * @param array
	 * @return
	 */
	public Node minimun(ArrayList<Node> array) {
		double f = array.get(0).getG() + array.get(0).getH();
		Node node = array.get(0);
		for (Node n:array) {
			if ((n.getG() + n.getH()) < f) {
				f = n.getG() + n.getH();
				node = n;
			}
		}
		return node;
	}
	
	/**
	 * Return the max number of nodes in path in an arrayList
	 * @param array
	 * @return
	 */
	public int maxPathSize(ArrayList<Node> array) {
		int max = array.get(0).pathSize();
		for (Node n:array) {
			if (n.pathSize() > max) {
				max = n.pathSize();
			}
		}
		
		return max;
	}

	/**
	 * A* search to find the shortest path
	 */
	public void aStarSearch(){
		
		ArrayList<Node> todraw2 = state.getTodraw2();
		int count = 0;		   

		for(Node n:todraw2) {
			n.setTodraw(todraw2);
		
		}
		
	    Node min = minimun(todraw2);
		 
	    while(min.ifEmptyTodraw() != 1) {
	    	
	    	if (min.getPath().size() == 0) {
	    		
	    		min.addPath(min);
	    		min.removeTodraw(min);
	    		Node min2 = new Node(min.getx2(),min.gety2(),min.getx1(),min.gety1());
	    		min.removeTodraw(min2);
	    		min.setG(min.getG()+min.getLength());
	    		double h = state.setHeuristic(min);
	    		min.setH(h);
	    		
	    	} else {
	    		
	    		Node end = min.pathEnd();
	
	    		int x1 = end.getx2();
	    		int y1 = end.gety2();
	    		
	    		Node min3 = new Node(min.getx1(),min.gety1(),min.getx2(),min.gety2());
	    		min3.setG(min.getG());
	    		min3.setPath(min.getPath());
	    		min3.setTodraw(min.getTodraw());
	    		double h = state.setHeuristic(min3);
	    		min3.setH(h);
	    		
	    		while (min.todrawSize()>0) {
	    			
		    		Node min2 = new Node(min3.getx1(),min3.gety1(),min3.getx2(),min3.gety2());
		    		min2.setG(min3.getG());
		    		min2.setPath(min3.getPath());
		    		min2.setTodraw(min3.getTodraw());
		    		Node next = min.getOneTodraw(x1, y1);
		    		min.removeTodraw(next);
		    		min2.removeTodraw(next);
		    		Node next2 = new Node(next.getx2(),next.gety2(),next.getx1(),next.gety1());
		    		min.removeTodraw(next2);
		    		min2.removeTodraw(next2);
		    		
		    		min2.addPath(next);
		    		double sqrx = Math.pow(x1-next.getx1(),2);
		    		double sqry = Math.pow(y1-next.gety1(),2);
		    		double d = Math.sqrt(sqrx+sqry);
		    		double length = next.getLength();
		    		double g = min2.getG();
		    		double totalG = d+length+g;
		    		min2.setG(totalG);
		    		double h2 = state.setHeuristic(min2);
		    		min2.setH(h2);
		    	
		    		todraw2.add(min2);
	    		
	    		}
	    		todraw2.remove(min);	    		
	    	}
	    		min = minimun(todraw2);  
	    		count++;	    		    	
	    }
 
		Node result = minimun(todraw2);
		String cost = String.format("%.2f", result.getG());
		System.out.println(count+" nodes expanded");
		System.out.println("cost = "+cost);
		
		ArrayList<Node> nodePath = result.getPath();
	
		printResult(nodePath);
		
	}

	/**
	 * Print the shortest path we found
	 * @param array
	 */
	public void printResult(ArrayList<Node> array) {
		ArrayList<Node> nodePath = array;
		int x2 = 0;
		int y2 = 0;
		for(int i=0; i<nodePath.size(); i++) {
			Node n = nodePath.get(i);
			if (i == 0) {
				if ((n.getx1() == 0) && (n.gety1() == 0)) {
					System.out.println("Draw from 0 0 to "+n.getx2()+" "+n.gety2());
					x2 = n.getx2();
					y2 = n.gety2();
				} else {
			
					System.out.println("Move from 0 0 to "+n.getx1()+" "+n.gety1());
					System.out.println("Draw from "+n.getx1()+" "+n.gety1()+" to "+n.getx2()+" "+n.gety2());
					x2 = n.getx2();
					y2 = n.gety2();
				}
			} else {		
				
				if ((n.getx1() == x2) && (n.gety1() == y2)) {
					System.out.println("Draw from "+n.getx1()+" "+n.gety1()+" to "+n.getx2()+" "+n.gety2());
					x2 = n.getx2();
					y2 = n.gety2();
				} else {
					System.out.println("Move from "+x2+" "+y2+" to "+n.getx1()+" "+n.gety1());
					System.out.println("Draw from "+n.getx1()+" "+n.gety1()+" to "+n.getx2()+" "+n.gety2());
					x2 = n.getx2();
					y2 = n.gety2();
				}
				
			}
		}
		
	}
	

	
	
}
