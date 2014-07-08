
public interface Heuristic{
	
	/**
	 * Set the initial H value at the start point(0,0)
	 */
	public double startPoint(Node n);
	
	/**
	 * Set H value
	 * @param n
	 * @return
	 */
	public double setHeuristic(Node n);
	
}
