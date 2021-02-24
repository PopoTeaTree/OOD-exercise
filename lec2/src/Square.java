import java.util.*;
import java.awt.*;

/**
 * Simple class representing a square figure. Designed 
 * to show the idea of visibility, methods, class data, etc.
 *
 *   Created by Sally Goldin, 9 August 2017
 *
 *   Modified to use draw and drawAllSquare 
 *   by Thitiporn, Popo, 60070503419 - 26 Jan 2020
 */
public class Square
{
   /* A square can be defined by an upper left corner point plus
    * the length of a side. However, for drawing purposes it is
    * more convenient to have four corner points in order.
    */
   /** X coordinates of four points */
   private int xcoord[] = new int[4];

   /** Y coordinates of four points */
   private int ycoord[] = new int[4];

   /** also keep the length of one side */
   private int oneside = 0;

    /** used to cycle through display colors */
    private Color colors[] = {Color.RED, Color.GREEN, Color.BLUE,
        Color.MAGENTA, Color.ORANGE};

    /** so we can count and label triangles */ 
   private static int counter = 0;


   /**
    * Constructor creates a new Square by setting the
    * values of the sets of vertex coordinates.
    * @param     x        Upper left corner X
    * @param     y        Upper left corner Y
    * @param     side     Length of one side
    */
    public Square(int x, int y, int side)
    {
       oneside = side;
       xcoord[0] = x;
       ycoord[0] = y;
       xcoord[1] = x + side;  // upper right
       ycoord[1] = y;
       xcoord[2] = x + side;  // lower right
       ycoord[2] = y + side;
       xcoord[3] = x;
       ycoord[3] = y + side;  // lower left
    }

    /** 
     * Return one of the X coordinates - 0 is upper left 
     * @param  which    0,1, 2, or 3 specifying which vertex we want
     * @return vertex X coordinate, or -1 if argument is wrong
     */
    public int getX(int which)
    {
        int coordVal = -1;
	if ((which >= 0) && (which < 4))
            coordVal = xcoord[which];  
        return coordVal;
    }


    /** 
     * Return one of the Y coordinates
     * @param  which    0,1, 2, or 3 specifying which vertex we want
     * @return vertex Y coordinate, or -1 if argument is wrong
     */
    public int getY(int which)
    {
        int coordVal = -1;
	if ((which >= 0) && (which < 4))
            coordVal = ycoord[which];  
        return coordVal;
    }

    /**
     * Set upper left X. This effectively moves the square to the left or right.
     * The setter re-initializes the other coordinates in the array.
     * @param   X    New upper left X coordinate
     */
    public void setX(int upperLeftX)
    {
       xcoord[0] = upperLeftX;
       xcoord[1] = upperLeftX + oneside;  // upper right
       xcoord[2] = upperLeftX + oneside;  // lower right
       xcoord[3] = upperLeftX;
    }


    /**
     * Set upper left Y. This effectively moves the square up or down.
     * The setter re-initializes the other coordinates in the array.
     * @param   Y    New upper left Y coordinate
     */
    public void setY(int upperLeftY)
    {
       ycoord[0] = upperLeftY;
       ycoord[1] = upperLeftY;   // upper right
       ycoord[2] = upperLeftY + oneside;  // lower right
       ycoord[3] = upperLeftY + oneside;  // lower left
    }

    /**
     * calculate the perimeter of this triangle
     * @return perimeter value
     */
    public double calcPerimeter()
    {
        return (double) oneside * 4;
    }


    /**
     * calculate the area of this triangle
     * @return area value
     */
    public double calcArea()
    {
        return (double) oneside * oneside;
    }

    /**
    * Display a square on the drawing canvas
    * @param  graphics   Graphic2D for drawing
    * @param  bOldColor  If true, draw in same color as previous figure
    */
    public void draw(Graphics2D graphics, boolean bOldColor)
   {
       if (bOldColor)
	   counter--;
       Color drawColor = colors[counter % 5];
       graphics.setPaint(drawColor);
       counter++;
       int x1,y1,x2,y2;
       /* cycle around the outside of the square
	* starting at the upper left. Get the current
	* corner and the next corner, then draw
	* a line between them.
	*/
       for (int i = 0; i < 4; i++)
       {
	   int pt1 = i;
	   int pt2 = ((i+1) % 4);
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
       int ulx = xcoord[0] * 10;
       int uly = ycoord[0] * 10;
       graphics.setColor(Color.BLACK);
       graphics.drawString(new String(" " + counter),(ulx + 10),(uly-10));
   }
   /**
    * Display all squares on the drawing canvas
    * @param  squareSet   arraylist of all squares
    * @param  graphics   Graphic2D for drawing
    * @param  bOldColor  If true, draw in same color as previous figure
    */
   public static void drawAllSquares(ArrayList<Square> squareSet,Graphics2D graphics, boolean bOldColor)
   {
    // looping for draw all square again
    for(Square square: squareSet)
    {
        square.draw(graphics,bOldColor);
    }
   }
}