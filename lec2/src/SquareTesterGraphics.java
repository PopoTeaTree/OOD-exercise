import java.util.*;
import java.awt.*;
/**
 *   Test program to create and display squares.
 *
 *   Created by Sally Goldin, 9 August
 *   Modified to use IOUtils.java - 19 Jan 2020
 *   Modified to use draw and drawAllSquare in square.java
 *   by Thitiporn, Popo, 60070503419 - 26 Jan 2020
 */
public class SquareTesterGraphics
{
   /** Keep hold of the last square we created so we can move
     * it using the mouse.
     */
   protected static Square latestSquare = null;

   /** Keep hold of all square we created
     */
   static ArrayList<Square> squareSet = new ArrayList<Square>();

   /* Main method first creates the viewer. Then it
    * asks for coordinates, creates new triangles, and displays them.
    * Then prints the perimetr and area as well.
    */
   public static void main(String arguments[])
      {
         boolean bContinue = true;
         final FigureViewer viewer = new FigureViewer();
         viewer.pack();
         viewer.setVisible(true);
         while (bContinue)
         {
	         int x,y;    /* coordinathhes of upper left point of square */
            int length; /* length of one side */
            x = IOUtils.getInteger("Enter x for upper left point (negative to draw all squares): ");
            if (x < 0)
            {
               // get graphic from FigureViewer class
               final Graphics2D graphics = (Graphics2D) viewer.getterGraphics();
               // squareAll.drawAllSquares(graphics,false);
               Square.drawAllSquares(squareSet,graphics,false);
            }
            else
            {
               y = IOUtils.getInteger("Enter y for upper left point: ");
               length = IOUtils.getInteger("Length of each side of square: ");
               latestSquare = new Square(x,y,length);
               // add new square to square array list
               squareSet.add(latestSquare);
               // get graphic from FigureViewer class
               final Graphics2D graphics = (Graphics2D) viewer.getterGraphics();
               viewer.drawSquare(latestSquare,false);
               latestSquare.draw(graphics,false);
               final double perim = latestSquare.calcPerimeter();
               System.out.println("Perimeter is " + perim);
               final double area = latestSquare.calcArea();
               System.out.println("Area is " + area + "\n\n");
            }
	      }
      System.exit(0);
      }

}