import java.io.*;
import java.util.*;
import java.awt.*;
/**
 *   Test program to create and display squares.
 *
 *   Created by Sally Goldin, 9 August
 *   Modified for Exercise 2. Now each figure can draw itself. 19 Aug 2017
 */
public class SquareTesterGraphics
{
    /** Keep hold of the last square we created
     */
	protected static Diamond latestSquare = null;

   /* Main method first creates the viewer. Then it
    * asks for coordinates, creates new triangles, and displays them.
    * Then prints the perimetr and area as well.
    */
   public static void main(final String arguments[])
    {
		boolean bContinue = true;
		final FigureViewer viewer = new FigureViewer();
		viewer.pack();
		viewer.setVisible(true);

		while (bContinue)
		{
			int x,y;    /* coordinates of upper left point of square */
			int length; /* length of one side */
			x = IOUtils.getInteger("Enter x for upper left point (negative to exit): ");
			if (x < 0)
				{
					bContinue = false;
				}
			else
				{
					y = IOUtils.getInteger("Enter y for upper left point: ");
					length = IOUtils.getInteger("Length of each side of square: ");
					Point setPoint = new Point ( x, y ); /* Setting point */
					System.out.println("----" + x + y + "\n");
					System.out.println("-" +  setPoint + "\n");
					latestSquare = new Diamond(setPoint,length);
					latestSquare.draw(viewer.getViewerGraphics());
					final double perim = latestSquare.calcPerimeter();
					System.out.println("Perimeter is " + perim);
					final double area = latestSquare.calcArea();
					System.out.println("Area is " + area + "\n\n");
					System.out.println("====== Try to print " + latestSquare + "\n\n");
					System.out.println("-----------------------------");
					final String move = IOUtils.getString("Want to move the square (Y/N)?");
					if ((move.startsWith("Y")) || (move.startsWith("y")))
						{
							int xM = IOUtils.getInteger("New X: ");
							int yM = IOUtils.getInteger("New Y: ");
							Point moveAnchor = new Point ( xM, yM ); /* Moving point */
							System.out.println("----" + xM + yM + "\n");
							System.out.println("-" +  moveAnchor + "\n");
							latestSquare.move(moveAnchor);
							viewer.clear();
							try
								{
									Thread.sleep(1000); // Wait for clear to complete
								}
							catch (final InterruptedException ie)
								{
								}
							latestSquare.draw(viewer.getViewerGraphics());
						}
					System.out.println("-----------------------------\n");
				}
		}
		System.out.println("About to draw all square");
		Diamond.drawAll(viewer.getViewerGraphics());
		final String dummy = IOUtils.getString("Press return to exit.");
		System.exit(0);
    }

}
