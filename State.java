import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * State class to show the state of nodes
 * @author Lan
 *
 */
public class State implements Heuristic{

	private PriorityQueue<Node> todraw;
	private ArrayList<Node> todraw2;


	/**
	 * To make a new state
	 */
	public State(){
		 todraw = new PriorityQueue<Node>();
		 todraw2 = new ArrayList<Node>();
	
	}
	
	/**
	 * Add a node in todraw list
	 * @param n
	 */
	public void addTodraw(Node n){
		todraw.add(n);
	
	}
	
    /**
     * Delete a node in todraw list
     * @param n
     */
	public void deleteTodraw(Node n){
		todraw.remove(n);
	}
	

	/**
	 * Get the todraw list in PriorityQueue
	 * @return
	 */
	public PriorityQueue<Node> getTodraw(){
		return todraw;
	}
	
	/**
	 * Get the todraw list in ArrayList
	 * @return
	 */
	public ArrayList<Node> getTodraw2() {
		return todraw2;
	}
	
	/**
	 * Add a node in todraw list
	 * @param n
	 */
	public void addTodraw2(Node n){
		todraw2.add(n);	
	}
	
	/**
	 * Delete a node in todraw list
	 * @param n
	 */
	public void deleteTodraw2(Node n){
		todraw2.remove(n);
	
	}
	
	/**
	 * Print todraw list
	 */
	public void printTodraw(){
		for(Node n:todraw){
			System.out.println(n.getx1()+" "+n.gety1()+" "+n.getx2()+" "+n.gety2()+" "+n.getH()+" "+n.getG());
		}
	}
	


	/**
	 * Return the initial value of h of a node
	 */
	@Override
	public double startPoint(Node n) {
	
		    double distance = 0;
			int x1 = n.getx1();
			int y1 = n.gety1();
			double sqrx1 = Math.pow(x1, 2);
			double sqry1 = Math.pow(y1, 2);
			distance = Math.sqrt(sqrx1+sqry1);
	
		return distance;

	}
 
	/**
	 * Return expected H value
	 */
    @Override
	public double setHeuristic(Node n) {
		ArrayList<Node> array = n.getTodraw();
		int length = 0;
		for(Node node: array) {
			length += node.getLength();
		}
		length = length/2;
		
		//AStar aStar = new AStar(state);
		return length;
		//return 0;
    }
   
 
    
    
}
