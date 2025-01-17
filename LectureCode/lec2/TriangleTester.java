/**
 * Simple class to exercise our Triangle class.
 *
 *   Created by Sally Goldin, 9 December 2011
 *   Modified to use IOUtils.java 19 January 2020
 *
 */

import java.io.*;

public class TriangleTester
{

    /**
     * Asks for one of the coordinates, and returns it
     * as the function value.
     * @param   prompt    String to print, telling which coordinate
     * @return  the coordinate. Exits with error if user types in
     *          something that can't be read as an integer 
     */
    protected static int getOneCoordinate(String prompt)
       {
       int value = 0;	   
       String inputString;
       int readBytes = 0;
       byte buffer[] = new byte[200]; 
       value = IOUtils.getInteger(prompt);
       return value;
       }

   /* Main method asks for coordinates and then
    * creates new triangles. Then it calls the 
    * perimeter and area methods for the newly created
    * triangle.
    */
   public static void main(String arguments[])
      {
      boolean bContinue = true;
      while (bContinue)
         {
	 int x1, x2, x3;
	 int y1, y2, y3;
	 x1 = getOneCoordinate("Enter x for point 1 (negative to exit): ");
	 if (x1 < 0)
            {
	    bContinue = false;
	    }
	 else
            {
	    y1 = getOneCoordinate("Enter y for point 1: ");
	    x2 = getOneCoordinate("Enter x for point 2: ");
	    y2 = getOneCoordinate("Enter y for point 2: ");
	    x3 = getOneCoordinate("Enter x for point 3: ");
	    y3 = getOneCoordinate("Enter y for point 3: ");
	    Triangle triangle = new Triangle(x1,y1,x2,y2,x3,y3);
	    /* If you uncomment this, the program will not compile because the data are private */
	    //for (int i = 0; i < 3; i++)
	    //	System.out.println("X=" + triangle.xcoord[i] + "  y=" + triangle.ycoord[i]);
	    double perim = triangle.calcPerimeter();
	    System.out.println("Perimeter is " + perim);
	    /* If you uncomment this, the program will not compile because the method is private */
	    //double length = triangle.calcLength(1);
	    //System.out.println("Length of side 1 is " + length);
	    double area = triangle.calcArea();
	    System.out.println("Area is " + area + "\n\n");
	    }
	 }   
      }

}
