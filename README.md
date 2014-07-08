A-star-search
=============
/** 
    by Lan Gao 
    comp2911 ass2 2014 semester 1
    
*/

A java program to solve Pen Plotter Problem by using A star search.


Sample Input

For example, the following input should draw a simple star shaped figure with six lines radiating from the point (4, 4). The format and meaning of the input is as follows (comments are for explanation only and should not appear in the actual input):

Line between 4 1 and 4 4    # draw a line between (4,1) and (4,4)
Line between 4 4 and 4 7    # draw a line between (4,4) and (4,7)
Line between 2 6 and 4 4    # draw a line between (2,6) and (4,4)
Line between 4 4 and 6 2    # draw a line between (4,4) and (6,2)
Line between 6 6 and 4 4    # draw a line between (6,6) and (4,4)
Line between 2 2 and 4 4    # draw a line between (2,2) and (4,4)

Sample Output

The output corresponding to the above input is as follows. The first line in the output should give the number of nodes n expanded in your search, the number of nodes taken off the queue, which will vary according to the heuristic used. The second line of the output should give the cost of the solution found as a number rounded to two decimal places, which is the total distance travelled by the pen including both drawing and moving), and should be the same regardless of the heuristic. The remainder of the output gives the sequence of actions that make up an optimal solution.

n nodes expanded
cost = 24.61
Move from 0 0 to 2 2
Draw from 2 2 to 4 4
Draw from 4 4 to 6 6
Move from 6 6 to 4 7
Draw from 4 7 to 4 4
Draw from 4 4 to 4 1
Move from 4 1 to 6 2
Draw from 6 2 to 4 4
Draw from 4 4 to 2 6
