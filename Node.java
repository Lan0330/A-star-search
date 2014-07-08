import java.util.ArrayList;

/**
 * Node class which consists of two points
 * @author Lan
 *
 */
public class Node implements Comparable<Object>{
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private double length;
	
	private double g;
    private double h;
    
    private ArrayList<Node> path;
    private ArrayList<Node> nodeTodraw;

    /**
     * Constructor for a new node which consists of two points
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
	public Node(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;

		int sqrX = (int) Math.pow((x1-x2), 2);
		int sqrY = (int) Math.pow((y1-y2), 2);
		length = (double) Math.sqrt(sqrX+sqrY);	

		path = new ArrayList<Node>();
		nodeTodraw = new ArrayList<Node>();
		
	}
	
	/**
	 * Return the x coordinate of the first point 
	 * @return
	 */
	public int getx1(){
		return x1;
	}
	/**
	 * Return the x coordinate of the second point 
	 * @return
	 */
	public int getx2(){
		return x2;
	}
	
	/**
	 * Return the y coordinate of the first point 
	 * @return
	 */
	public int gety1(){
		return y1;
	}
	
	/**
	 * Return the y coordinate of the second point 
	 * @return
	 */
	public int gety2(){
		return y2;
	}
	
	/**
	 * Return the length between the two points in a node
	 * @return
	 */
	public double getLength(){
		
		return length;
	}
	
	/**
	 * Return G value of the node
	 * @return
	 */
	public double getG() {
		return g;
	}
	
	/**
	 * Set g value of the node
	 * @param g
	 */
	public void setG(double g) {
		this.g = g;
	}
	
	/**
	 * Return H value of the node
	 * @return
	 */
	public double getH() {
		return h;
	}
	
	/**
	 * Set the H value of the node
	 * @param h
	 */
	public void setH(double h) {
		this.h = h;
	}

	/**
	 * Add a node in its path
	 * @param n
	 */
	public void addPath(Node n) {
		Node node = new Node(n.getx1(),n.gety1(),n.getx2(),n.gety2());
		path.add(node);
	
	}
	
	/**
	 * Set the path of the node
	 * @param path
	 */
	public void setPath(ArrayList<Node> path) {
		for(int i=0;i<path.size();i++) {
			Node n = path.get(i);
			this.path.add(n);
		}
	}
	
	/**
	 * Return the end node of the path
	 * @return
	 */
	public Node pathEnd() {
		return path.get(path.size()-1);
	}
	
	/**
	 * Return the size of path in a node
	 * @return
	 */
	public int pathSize() {
		return path.size();
	}
	
	/**
	 * Return the path of the node
	 * @return
	 */
	public ArrayList<Node> getPath() {
		return path;
	}
	
	/**
	 * To test if the todrawList in the node is empty
	 * @return
	 */
	public int ifEmptyTodraw() { 
		if(nodeTodraw.size() > 0) {
			return 0;
		} else {
			return 1;
		}
	}
	
	/**
	 * Set a todrawList in a node
	 * @param array
	 */
	public void setTodraw(ArrayList<Node> array) {
		for(int i=0;i<array.size();i++) {
			Node n = array.get(i);
			nodeTodraw.add(n);
		}
		
	}
	
	/**
	 * Return the size of todrawList in a node
	 * @return
	 */
	public int todrawSize() {
		return nodeTodraw.size();
	}
	
	/**
	 * Get one node haven't drawn in todrawList
	 * @param x1
	 * @param y1
	 * @return
	 */
	public Node getOneTodraw(int x1,int y1) {
		Node n1 = nodeTodraw.get(0);
		int d = Math.abs(n1.getx1()-x1)+Math.abs(n1.gety1()-y1);
		int index = 0;
		for(int i=0;i<nodeTodraw.size();i++) {
			Node n = nodeTodraw.get(i);
			int absx = Math.abs(n.getx1()-x1);
			int absy = Math.abs(n.gety1()-y1);
			
			if ((absx+absy) < d) {
				d = absx+absy;
				index = i;
			}
		
		}
		return nodeTodraw.get(index);
	}
	
	/**
	 * Get the todrawList in a node
	 * @return
	 */
	public ArrayList<Node> getTodraw() {
		return nodeTodraw;
	}
	
	/**
	 * remove a node in todrawList
	 * @param n
	 */
	public void removeTodraw(Node n) {
		
		int x1 = n.getx1();
		int y1 = n.gety1();
		int x2 = n.getx2();
		int y2 = n.gety2();
		
		for(int i = 0; i<nodeTodraw.size();i++) {
			Node node = nodeTodraw.get(i);
			if ((node.getx1() == x1) && (node.gety1() == y1)) {
				if ((node.getx2() == x2) && (node.gety2() == y2)) {
					nodeTodraw.remove(node);
				}
				
			}
		}		
	}

	/**
	 * sort PriorityQueue in F value
	 */
	@Override
	public int compareTo(Object o) {		
		return Double.compare((this.h+this.g),(((Node) o).getH()+((Node) o).getG()));
		
	}
	



}
