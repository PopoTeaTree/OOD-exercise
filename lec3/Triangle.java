import java.awt.*;
import java.util.ArrayList;
import java.lang.Math;

/**
 * Simple class representing a triangle object. Designed
 * to show the idea of visibility, methods, class data, etc.
 *
 *   Created by Sally Goldin, 9 December 2011
 *   Modified 16 Dec 2011 to fix triangle area calculations
 *   Modified 19 Aug 2017 to draw itself, keep collection of
 *   all triangles
 *
 *   Modified 02 January 2020 to use abstract class
 *   by Thitiporn Sukpartcharoen (Popo) ID: 60070503419
 */
public class Triangle extends AbstractShape
{
   /** X coordinates of three points defining the triangle */
   private int xcoord[] = new int[3];

   /** Y coordinates of three points defining the triangle */
   private int ycoord[] = new int[3];

    /** figure number for a particular square */
    private int figureNumber = -1;

    /** color to use for drawing a particular square */
    private Color drawColor = null;

    /** also keep the length of left side in X coordinate*/
    private int xLeft = 0;
    /** also keep the length of left side in Y coordinate */
    private int yLeft = 0;
    /** also keep the length of right side in X coordinate */
    private int xRight = 0;
    /** also keep the length of right side in Y coordinate */
    private int yRight = 0;

   /**
    * Constructor creates a new Triangle by setting the
    * values of the sets of vertext coordinates.
    * Also increments counter, sets drawing color adn stores in allFigures.
    * @param     anchor    Upper point
    * @param     x2        X coord of second vertex
    * @param     y2        Y coord of second vertex
    * @param     x3        X coord of third vertex
    * @param     y3        Y coord of third vertex
    */
    public Triangle(Point anchor, int x2, int y2, int x3, int y3)
    {
       int x1 = (int) anchor.getX();
       int y1 = (int) anchor.getY();
       xcoord[0] = x1;
       xcoord[1] = x2;
       xcoord[2] = x3;
       ycoord[0] = y1;
       ycoord[1] = y2;
       ycoord[2] = y3;
       xLeft = x1-x2;                  // initail left distance in X coordinate
       yLeft = y1-y2;                  // initail left distance in y coordinate
       xRight = x1-x3;                 // initail right distance in X coordinate
       yRight = y1-y3;                 // initail right distance in y coordinate
       counter++;
       figureNumber = counter;
       allFigures.add(this);
       drawColor = colors[counter % 5]; // set so will always be same color
    }

    /**
     * Move the triangle somewhere else, determined by new
     * upper left x and y.
     * The function re-initializes the other coordinates in the array
     * to keep the figure square.
     * @param   newAnchor    New upper left point
     */
    public void move(Point newAnchor)
    {
        int upperX = (int) newAnchor.getX();            /* get x coordinate of the new anchor point*/
        int upperY = (int) newAnchor.getY();            /* get y coordinate of the new anchor point*/
        // int positionAnchor = vertices.indexOf(anchor);  /* get index of the old achor point */
        // vertices.set(positionAnchor,newAnchor);         // set new anchor point
        xcoord[0] = upperX;
        ycoord[0] = upperY;
        xcoord[1] = upperX + xLeft;                      // left side
        ycoord[1] = upperY + yLeft;
        xcoord[2] = upperX + xRight;                     // right side
        ycoord[2] = upperX + yRight;
        // anchor = newAnchor;
    }

    /**
     * calculate the perimeter of this triangle
     * @return perimeter value
     */
    public double calcPerimeter()
    {
	    double perimeter = 0;
        for (int i = 1; i < 4; i++)
	    {
	        perimeter = perimeter + calcLength(i);
	    }
        return perimeter;
    }

    /**
     * calculate the area of this triangle
     * @return area value
     */
    public double calcArea()
    {
        /* area formula is
        |Ax(By - Cy) + Bx(Cy - Ay) + Cx(Ay - By)|/2
        */
        int numerator = xcoord[0] * (ycoord[1] - ycoord[2]);
        numerator += xcoord[1] * (ycoord[2] - ycoord[0]);
        numerator += xcoord[2] * (ycoord[0] - ycoord[1]);
        return (double) Math.abs(numerator) / 2;
    }


    /**
     * Calculate the length of one side of the triangle.
     * This is private method used by calcPerimeter and calcArea.
     * @param  which    1,2 or 3, for which side
     * @return length of side, or -1 if 'which' is out of range.
     */
    private double calcLength(int which)
    {
	    double len = -1;
        int index1 = -1;
        int index2 = -1;
        switch (which)
        {
            case 1:
                index1 = 0;
                index2 = 1;
                break;
            case 2:
                index1 = 1;
                index2 = 2;
                break;
            case 3:
                index1 = 0;
                index2 = 2;
                break;
	        default:
                System.out.println("Invalid argument to calcLength!");
	    }
        if (index1 >= 0)
	    {
            len = Math.sqrt(Math.pow(xcoord[index1] - xcoord[index2],2) +
                            Math.pow(ycoord[index1] - ycoord[index2],2));
	    }
	    return len;
    }

    /**
     * Draw the triangle. The passed graphics2D contains
     * the information necessary for this.
     * @param graphics Class with info to do the drawing
     */
    public void draw(Graphics2D graphics)
    {
        graphics.setPaint(drawColor);
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        for (int i = 0; i < 3; i++)
        {
            int pt1 = i;
            int pt2 = (i+1) % 3;
            x1 = xcoord[pt1];
            y1 = ycoord[pt1];
            x2 = xcoord[pt2];
            y2 = ycoord[pt2];
            x1 *=10;    /* multiply by 10 so we can use small numbers for coords*/
            y1 *=10;
            x2 *=10;
            y2 *=10;
            graphics.drawLine(x1,y1,x2,y2);
        }
        /* label in the center */
        graphics.setColor(Color.BLACK);
        graphics.drawString(new String(" " + figureNumber),(x1 + x2)/2,
                    (y1 + y2)/2);
    }

}
