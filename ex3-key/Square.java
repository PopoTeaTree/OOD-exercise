import java.awt.*;
import java.util.ArrayList;

/**
 * Simple class representing a square figure. Designed 
 * to show the idea of visibility, methods, class data, etc.
 *
 *   Created by Sally Goldin, 9 August 2017
 *   Modified 19 August 2017 to improve cohesion, reduce coupling
 *   by removing any need for any other class to see the data.
 *   Modified 24 August 2017 for Exercise 3, to make into a subclass
 *   of AbstractShape
 *
 *
 */
public class Square extends AbstractShape
{
   /* A square can be defined by an upper left corner point plus
    * the length of a side. We will also store the four Point object
    * in the superclass array 'vertices'
    */ 

    /** keep the length of one side */
    protected int oneside = 0;
    
    /**
     * Constructor creates a new Square by setting the
     * values of the sets of vertex coordinates.
     * @param     x        Upper left corner X
     * @param     y        Upper left corner Y
     * @param     side     Length of one side
     */
    public Square(int x, int y, int side)
    {
       super();
       oneside = side;
       anchor = new Point(x,y);
       vertices.add(new Point(x,y));
       vertices.add(new Point(x + side,y));  // upper right
       vertices.add(new Point(x + side,y + side));  // lower right
       vertices.add(new Point(x,y + side)); // lower left
    }

    /* draw, move, and drawAll are handled by the superclass */

    /**
     * calculate the perimeter of this square
     * @return perimeter value
     */
    public double calcPerimeter()
    {
        return (double) oneside * 4;
    }
    
    
    /**
     * calculate the area of this square
     * @return area value
     */
    public double calcArea()
    {
        return (double) oneside * oneside;
    }

	
}
