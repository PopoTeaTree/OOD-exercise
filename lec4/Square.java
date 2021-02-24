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
 *   Modified 09 February 2020 by Thitiporn Sukpartcharoen
 *   (Popo) 60070503419
 *    add a toString() method which will override the one provided
 *   by the Object class. This method should be declared as
 *   follows:
 *   public String toString()
 *   Inside the method, create and return a string that gives more useful
 *   information about the shape. For example, the toString() method
 *   for Square might return:
 *   Square at x=100, y=120 with sides 80
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
    
    /**
     * A toString() method which will override the one provided
     * by the Object class.
     * This is public method used by calcPerimeter and calcArea.
     * @return square information including a conner and sides
     */
	public String toString()
    {
        int x = (int) anchor.getX();    /* x coordinate of a square */
        int y = (int) anchor.getY();    /* y coordinate of a square */
        /* format a square data string */
        String squareFormat = String.format("Square at x=%d y=%d with sides %d"
                                            ,x,y,oneside);
        return squareFormat;
    }
}