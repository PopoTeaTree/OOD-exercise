import java.awt.*;
import java.util.ArrayList;

/**
 * Simple class representing a square figure. Designed 
 * to show the idea of visibility, methods, class data, etc.
 *
 *   Created by Sally Goldin, 9 August 2017
 *   Modified 19 August 2017 to improve cohesion, reduce coupling
 *   by removing any need for any other class to see the data.
 *   Modified 29 Jan 2020 to use allFigures.size() to control loop.
 *   Does not matter now, but using counter would break the program
 *   if we allowed squares to be deleted.
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
    
    /** figure number for a particular square */
    private int figureNumber = -1; 
    
    /** color to use for drawing a particular square */
    private Color drawColor = null;
    
    /* static data */
    /** so we can count and label figures */ 
    private static int counter = 0;
    
    /** collection of all squares */
    private static ArrayList<Square> allFigures = new ArrayList<Square>();

    /** used to cycle through display colors */    
    private static Color colors[] = {Color.RED, Color.GREEN, Color.BLUE,
			      Color.MAGENTA, Color.ORANGE};
    
    /**
     * Constructor creates a new Square by setting the
     * values of the sets of vertex coordinates.
     * Also increments the counter and sets the figureNumber. 
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
       counter++;
       figureNumber = counter;
       allFigures.add(this);
       drawColor = colors[counter % 5]; // set so will always be same color
    }

    /**
     * Move the square somewhere else, determined by new
     * upper left x and y. 
     * The function re-initializes the other coordinates in the array
     * to keep the figure square.
     * @param   upperLeftX    New upper left X coordinate
     * @param   upperLeftY    New upper left Y coordinate
     */
    public void move(int upperLeftX, int upperLeftY)
    {
	xcoord[0] = upperLeftX;
	xcoord[1] = upperLeftX + oneside;  // upper right
	xcoord[2] = upperLeftX + oneside;  // lower right
	xcoord[3] = upperLeftX;
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
     * Draw the square. The passed graphics2D contains
     * the information necessary for this.
     * @param graphics Class with info to do the drawing
     */
    public void draw(Graphics2D graphics)
    {
	graphics.setPaint(drawColor);
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
	graphics.drawString(new String(" " + figureNumber),(ulx + 10),(uly-10)); 
    }

    /** static method to draw all the squares that have been
     * created so far.
     * @param  graphics   Graphics context for drawing.
     */
    public static void drawAll(Graphics2D graphics)
    {
	for (int i=0; i < allFigures.size(); i++)
	{
	    Square square = allFigures.get(i);
	    square.draw(graphics);
	}
    }
	
}
