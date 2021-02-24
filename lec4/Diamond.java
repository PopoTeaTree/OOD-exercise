import java.awt.*;
import java.util.ArrayList;

/**
 * Simple class representing a diamond object.
 *
 *   Created 24 August 2017 for Exercise 3
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
public class Diamond extends AbstractShape
{

    /**
     * keep horizontal axis for perimeter calculations
     */
    private int horizontalAxis;

    /**
     * keep vertical axis for perimeter calculations
     */
    private int verticalAxis;

    /**
     * Constructor creates a new diamond by specifying an x,y
     * for the top point of the diamond, plus vertical and
     * horizontal axis lengths.
     * @param     x        X coord of first vertex
     * @param     y        Y coord of first vertex
     * @param     vAxis    Vertical axis length
     * @param     hAxis    Horizontal axis length
     */
    public Diamond(int x, int y, int vAxis, int hAxis)
    {
       super();
       // make the axes be even numbers
       if ((vAxis % 2) > 0)
	   vAxis += 1;
       if ((hAxis % 2) > 0)
	   hAxis += 1;
       horizontalAxis = hAxis;
       verticalAxis = vAxis;
       anchor = new Point(x,y);
       vertices.add(anchor);
       vertices.add(new Point(x+hAxis/2,y+vAxis/2));
       vertices.add(new Point(x,y+vAxis));
       vertices.add(new Point(x-hAxis/2,y+vAxis/2));
    }

    /**
     * Calculate the perimeter of this diamond.
     * This is four times the length of one side.
     * @return perimeter value
     */
    public double calcPerimeter()
    {
        Point p1 = anchor;
	    Point p2 = vertices.get(1);
        double len = Math.sqrt(Math.pow(p1.x - p2.x,2) +
                               Math.pow(p1.y - p2.y,2));
        return len * 4;
    }

    /**
     * Calculate the area of this diamond
     * This is the product of the axes, divided by 2.
     * @return area value
     */
    public double calcArea()
    {
        return (double) (horizontalAxis * verticalAxis) / 2;
    }

    /**
     * A toString() method which will override the one provided
     * by the Object class.
     * This is public method used by calcPerimeter and calcArea.
     * @return diamond information including a conner, vertical axis
     * horizontal axis
     */
    public String toString()
    {
        int x = (int) anchor.getX();    /* x coordinate of a diamond */
        int y = (int) anchor.getY();    /* y coordinate of a diamond */
        /* format a diamond data string */
        String diamondFormat = String.format("Diamond at x=%d y=%d with vertical axis length %d and horizontal axis length %d"
                                            ,x,y,verticalAxis,horizontalAxis);
        return diamondFormat;
    }
}
