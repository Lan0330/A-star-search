import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Main function
 * @author Lan
 *
 */
public class PenPlotter {

	public static void main(String[] args) {
		
		try{
	          Scanner line = new Scanner(new FileReader(args[0])); 
	          
	          State state = new State();
	        
	          String[] coordinates;
	          while(line.hasNextLine()){
	        	  String input = line.nextLine();
	        	 
	        	  coordinates = input.split("\\b");
	        	  int x1 = Integer.parseInt(coordinates[5]);
	        	  int y1 = Integer.parseInt(coordinates[7]);
	        	  int x2 = Integer.parseInt(coordinates[11]);
	        	  int y2 = Integer.parseInt(coordinates[13]);
			  
	        	  Node n1 = new Node(x1,y1,x2,y2);
	        	  double g1 = state.startPoint(n1);
	        	  n1.setG(g1);        	
	        	  Node n2 = new Node(x2,y2,x1,y1);
	        	  double g2 = state.startPoint(n2);
	        	  n2.setG(g2);
	        	  
	        	  state.addTodraw(n1);
	        	  state.addTodraw(n2);
	        	  state.addTodraw2(n1);
	        	  state.addTodraw2(n2);
	        	  
	          }
	          AStar aStar = new AStar(state);
	        
	          aStar.aStarSearch();

	      }
	      catch (FileNotFoundException e) {}
	}
}
