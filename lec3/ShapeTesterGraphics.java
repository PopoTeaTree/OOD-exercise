import java.io.*;
import java.util.*;
import java.awt.*;
/**
 *   Test program to create and display shapes.
 *
 *   Created by Thitiporn Sukpartcharoen, 3 January
 *   Created for Exercise 3.
 */
public class ShapeTesterGraphics
{
    /* Keep hold of the last dimond we created */
    protected static Diamond latestDiamond = null;
    /* Keep hold of the last square we created */
    protected static Square latestSquare = null;
    /* Keep hold of the last triangle we created */
    protected static Triangle latestTriangle = null;

    /* Main method first ask to Create and draw triangle, square and diamond.
    * The second feature is to draw all the shape and the last is the
    * choice to exit this program.
    * The Create and draw asks for coordinates, creates new shape, and displays them.
    * Then prints the perimetr and area as well. Then it will ask for move the shape.
    */
    public static void main(final String arguments[])
    {
        boolean bContinue = true;
		final FigureViewer viewer = new FigureViewer();
		viewer.pack();
        viewer.setVisible(true);
        while(bContinue)
        {
            System.out.println("1 – Create and draw triangle" + "\n");
            System.out.println("2 – Create and draw square" + "\n");
            System.out.println("3 – Create and draw diamond" + "\n");
            System.out.println("4 – Draw all shapes" + "\n");
            System.out.println("5 – Exit" + "\n");
            int anwser = IOUtils.getInteger(" Enter your choice: ");
            switch (anwser)
            {
                case 1 :
                    int xTriangle,yTriangle;    /* coordinates of topper point of triangle */
                    int xLeft,yLeft;            /* coordinates of left point of triangle */
                    int xRight,yRight;          /* coordinates of right point of triangle */
                    xTriangle = IOUtils.getInteger("Enter x for topper point: ");
                    yTriangle = IOUtils.getInteger("Enter y for topper point: ");
                    xLeft = IOUtils.getInteger("Enter x for left point: ");
                    yLeft = IOUtils.getInteger("Enter y for left point: ");
                    xRight = IOUtils.getInteger("Enter x for right point: ");
                    yRight = IOUtils.getInteger("Enter y for right point: ");
                    Point setPointTriangle = new Point ( xTriangle, yTriangle ); /* Setting point */
                    latestTriangle = new Triangle(setPointTriangle,xLeft,yLeft,xRight,yRight);
                    latestTriangle.draw(viewer.getViewerGraphics());
                    double perimTriangle = latestTriangle.calcPerimeter();
                    System.out.println("Perimeter is " + perimTriangle);
                    double areaTriangle = latestTriangle.calcArea();
                    System.out.println("Area is " + areaTriangle + "\n\n");
                    System.out.println("-----------------------------");
                    String moveTriangle = IOUtils.getString("Want to move the triangle (Y/N)?");
                    if ((moveTriangle.startsWith("Y")) || (moveTriangle.startsWith("y")))
                        {
                            int xMTriangle = IOUtils.getInteger("New topper X: ");           /* new coordinates of topper point of triangle */
                            int yMTriangle = IOUtils.getInteger("New topper Y: ");           /* new coordinates of topper point of triangle */
                            Point moveAnchorTriangle = new Point ( xMTriangle, yMTriangle ); /* Moving point */
                            latestTriangle.move(moveAnchorTriangle);
                            viewer.clear();
                            try
                                {
                                    Thread.sleep(1000); // Wait for clear to complete
                                }
                            catch (final InterruptedException ie)
                                {
                                }
                            latestTriangle.draw(viewer.getViewerGraphics());
                        }
                    break;
                case 2 :
                    int xSquare,ySquare;    /* coordinates of upper left point of square */
                    int lengthSquare;       /* length of one side */
                    xSquare = IOUtils.getInteger("Enter x for upper left point: ");
                    ySquare = IOUtils.getInteger("Enter y for upper left point: ");
                    lengthSquare = IOUtils.getInteger("Length of each side of square: ");
                    Point setPointSquare = new Point ( xSquare, ySquare ); /* Setting point */
                    latestSquare = new Square(setPointSquare,lengthSquare);
                    latestSquare.draw(viewer.getViewerGraphics());
                    double perimSquare = latestSquare.calcPerimeter();
                    System.out.println("Perimeter is " + perimSquare);
                    double areaSquare = latestSquare.calcArea();
                    System.out.println("Area is " + areaSquare + "\n\n");
                    System.out.println("-----------------------------");
                    String moveSquare = IOUtils.getString("Want to move the square (Y/N)?");
                    if ((moveSquare.startsWith("Y")) || (moveSquare.startsWith("y")))
                        {
                            int xMSquare = IOUtils.getInteger("New X: ");
                            int yMSquare = IOUtils.getInteger("New Y: ");
                            Point moveAnchorSquare = new Point ( xMSquare, yMSquare ); /* Moving point */
                            latestSquare.move(moveAnchorSquare);
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
                    break;
                case 3 :
                    int xDiamond,yDiamond;    /* coordinates of topper point of diamond */
                    int lengthDiamond;       /* length of one side */
                    xDiamond = IOUtils.getInteger("Enter x for topper point: ");
                    yDiamond = IOUtils.getInteger("Enter y for topper left point: ");
                    lengthDiamond = IOUtils.getInteger("Inner Length of size of diamond: ");
                    Point setPointDiamond = new Point ( xDiamond, yDiamond ); /* Setting point */
                    latestDiamond = new Diamond(setPointDiamond,lengthDiamond);
                    latestDiamond.draw(viewer.getViewerGraphics());
                    double perimDiamond = latestDiamond.calcPerimeter();
                    System.out.println("Perimeter is " + perimDiamond);
                    double areaDiamond = latestDiamond.calcArea();
                    System.out.println("Area is " + areaDiamond + "\n\n");
                    System.out.println("-----------------------------");
                    String moveDiamond = IOUtils.getString("Want to move the diamond (Y/N)?");
                    if ((moveDiamond.startsWith("Y")) || (moveDiamond.startsWith("y")))
                        {
                            int xMDiamond = IOUtils.getInteger("New X: ");
                            int yMDiamond = IOUtils.getInteger("New Y: ");
                            Point moveAnchorDiamond = new Point ( xMDiamond, yMDiamond ); /* Moving point */
                            latestDiamond.move(moveAnchorDiamond);
                            viewer.clear();
                            try
                                {
                                    Thread.sleep(2000); // Wait for clear to complete
                                }
                            catch (final InterruptedException ie)
                                {
                                }
                            latestDiamond.draw(viewer.getViewerGraphics());
                        }
                    break;
                case 4 :
                    AbstractShape.drawAll(viewer.getViewerGraphics());
                    break;
                case 5 :
                    bContinue = false;
                    System.exit(0);
            }
        }
    }
}