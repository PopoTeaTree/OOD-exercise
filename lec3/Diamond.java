import java.awt.*;
import java.util.*;
import java.util.ArrayList;

/**
 * Simple class representing a diamond figure. Designed
 * to show the idea of visibility, methods, class data, etc.
 *
 *
 *   created 02 January 2020 to use abstract class
 *   by Thitiporn Sukpartcharoen (Popo) ID: 60070503419
 */
public class Diamond extends AbstractShape
{
   /* A diamond can be defined by an upper corner point plus or
    * minus the length of a side. However, for drawing purposes it is
    * more convenient to have four corner points in order.
    */
    /** X coordinates of four points */
    private int xcoord[] = new int[4];

    /** Y coordinates of four points */
    private int ycoord[] = new int[4];

    /** also keep the length of one side */
    private int side = 0;

    /** also keep the length of one side */
    private double twoside = 0;

    /** figure number for a particular square */
    private int figureNumber = -1;

    /** color to use for drawing a particular square */
    private Color drawColor = null;

    /**
     * Constructor creates a new Diamond by setting the values of the sets of vertex
     * coordinates. Also increments the counter and sets the figureNumber.
     *
     * @param anchor    Upper point
     * @param size      Size of diamond
     */
    public Diamond(Point anchor,int size)
    {
        int x = (int) anchor.getX();    /* get x coordinate of anchor point*/
        int y = (int) anchor.getY();    /* get y coordinate of anchor point*/
        vertices.add(anchor);           // add new point to the vertices arraylist
        side = (int) size/2;            // half of side (set to easy to calculate)
        xcoord[0] = x;
        ycoord[0] = y;
        xcoord[1] = x + side;       // right
        ycoord[1] = y - side;
        xcoord[2] = x;              // lower
        ycoord[2] = y - (2 * side);
        xcoord[3] = x - side;
        ycoord[3] = y - side;       // left
        counter++;
        figureNumber = counter;
        allFigures.add(this);
        drawColor = colors[counter % 5]; // set so will always be same color
    }

    /**
     * Move the diamond somewhere else, determined by new upper left x and y. The
     * function re-initializes the other coordinates in the array to keep the figure
     * dimond.
     *
     * @param newAnchor New upper point
     */

    public void move(Point newAnchor)
    {
        int upperX = (int) newAnchor.getX();        /* get x coordinate of the new anchor point*/
        int upperY = (int) newAnchor.getY();        /* get y coordinate of the new anchor point*/
        // int positionAnchor = vertices.indexOf(anchor);  /* get index of the old achor point */
        // vertices.set(positionAnchor,newAnchor);         // set new anchor point
        xcoord[0] = upperX;
        ycoord[0] = upperY;
        xcoord[1] = upperX + side;               // right
        ycoord[1] = upperY - side;
        xcoord[2] = upperX;                      // lower
        ycoord[2] = upperY - (2 * side);
        xcoord[3] = upperX - side;
        ycoord[3] = upperY + side;               // left
        System.out.println("-"+ newAnchor);
        System.out.println("-"+ upperX);
        System.out.println("-"+ upperY);
        System.out.println("-"+ side);
        // anchor = newAnchor;
    }

    /**
     * calculate the perimeter of this triangle
     *
     * @return perimeter value
     */
    public double calcPerimeter()
    {
        return (double) (side*1.414) * 4;
    }

    /**
     * calculate the area of this triangle
     *
     * @return area value
     */
    public double calcArea()
    {
        return (double) (side*1.414) * (side*1.414);
    }

    /**
     * Draw the diamond. The passed graphics2D contains the information necessary
     * for this.
     *
     * @param graphics Class with info to do the drawing
     */
    public void draw(final Graphics2D graphics)
    {
        graphics.setPaint(drawColor);
        int x1, y1, x2, y2;
        /*
         * cycle around the outside of the diamond starting at the upper left. Get the
         * current corner and the next corner, then draw a line between them.
         */
        for (int i = 0; i < 4; i++)
        {
            final int pt1 = i;
            final int pt2 = ((i + 1) % 4);
            x1 = xcoord[pt1];
            y1 = ycoord[pt1];
            x2 = xcoord[pt2];
            y2 = ycoord[pt2];
            x1 *= 10;   /* multiply by 10 so we can use small numbers for coords */
            y1 *= 10;
            x2 *= 10;
            y2 *= 10;
            graphics.drawLine(x1, y1, x2, y2);
        }
        /* label in the center */
        final int ulx = xcoord[0] * 10;
        final int uly = ycoord[0] * 10;
        graphics.setColor(Color.BLACK);
        graphics.drawString(new String(" " + figureNumber),(ulx + 10),(uly-10));
    }
}
