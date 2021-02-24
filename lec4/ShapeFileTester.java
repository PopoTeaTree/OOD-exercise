/**
 *   This class to test your shape reading and creation,
 *   And to explore overriding and polymorphism
 *
 *   Created by Thitiporn Sukpartcharoen(Popo) 60070503419,
 *   09 February 2020 for Exercise 4.
 */
public class ShapeFileTester
{
    static public void main(String args[])
    {
        /* check is there already have shape file */
        if (args.length < 1)
        {
            System.out.println("You must specify a shape data file as a command line argument");
            System.exit(0);
        }
        ShapeReader pReader = new ShapeReader();    /* shape text reader */
        boolean bOk = pReader.open(args[0]);        /* open shape file */
        /* check is it already open shape file */
        if (bOk)
        {
            System.out.format("Trying to open file \' %s \'.... success!",args[0]);
            AbstractShape shape = null;     /* abstract shape for build a shape */
            /* looping until not find any line */
            while ((shape = pReader.readShape()) != null)
            {
                System.out.println(" readShape returned an object: "+ shape.getClass() + "\n");
                System.out.println("   toString: "+ shape.toString() + "\n");
                System.out.println("   perimeter: "+ (int) shape.calcPerimeter() + "\n");
            }
            /* close the shape file */
            pReader.close();
            System.out.println("\n");
            System.out.println("Closing file and exiting");
        }
        else
        {
            System.out.println("Error opening file \"" + args[0] + "\"");
        }
        /* exit program */
        System.exit(1);
    }
}