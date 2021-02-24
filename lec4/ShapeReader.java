import javax.swing.*;
import java.awt.*;
import java.io.*;
/**
 * Class extends TextFileReader to return Abstract shape instead of
 * AbstractShape.
 *
 * Created by 09 February 2020 by Thitiporn Sukpartcharoen
 * (Popo) 60070503419
 *
 */
public class ShapeReader extends TextFileReader
{

/**
* Read the next line and parse it to get data for shapes
* @return  AbstractShape object or null if an error occurred including
*          a line that doesn't match the expected format
*/
    public AbstractShape readShape()
    {
        AbstractShape shape = null;         /* abstract shape for build a shape */
        String lineRead = getNextLine();    /* initial the first line from shape file */
        if (lineRead != null)
        {
            String arrayLine[] = lineRead.split(" ");   /* remove spacebar and keep data shape to array */
            String whichShape = null;                   /* shape buffer */
            /* shape of each shape data */
            whichShape = arrayLine[0];
            /* match shape */
            switch(whichShape)
            {
                case "TRIANGLE":
                    shape = processTriangle(arrayLine);
                    break;
                case "CIRCLE":
                    shape = processCircle(arrayLine);
                    break;
                case "SQUARE":
                    shape = processSquare(arrayLine);
                    break;
                case "DIAMOND":
                    shape = processDiamond(arrayLine);
                    break;
            }
        }
        return shape;
    }

    /**
     * Create a triangle.
     * @param arrayLine[] triangle data
     * @return triangle object
     */
    private static Triangle processTriangle(String arrayLine[])
    {
        int x1, x2, x3; /* x coordinate of a triangle */
        int y1, y2, y3; /* y coordinate of a triangle */
        /* change string to integer variable */
        x1 = Integer.parseInt(arrayLine[1]);
        y1 = Integer.parseInt(arrayLine[2]);
        x2 = Integer.parseInt(arrayLine[3]);
        y2 = Integer.parseInt(arrayLine[4]);
        x3 = Integer.parseInt(arrayLine[5]);
        y3 = Integer.parseInt(arrayLine[6]);
        /* create a traingle */
        Triangle triangle = new Triangle(x1,y1,x2,y2,x3,y3);
        return triangle;
    }

    /**
     * Create a circle.
     * @param arrayLine[] circle data
     * @return circle object
     */
    private static Circle processCircle(String arrayLine[])
    {
        int xC;     /* x coordinate of a circle */
        int yC;     /* y coordinate of a circle */
        int radius; /* radius of a circle */
        /* change string to integer variable */
        xC =  Integer.parseInt(arrayLine[1]);
        yC = Integer.parseInt(arrayLine[2]);
        radius = Integer.parseInt(arrayLine[3]);
        /* create a circle */
        Circle circle = new Circle(xC,yC,radius);
        return circle;
    }

    /**
     * Create a square.
     * @param arrayLine[] square data
     * @return square object
     */
    private static Square processSquare(String arrayLine[])
    {
        int xS;     /* x coordinate of a square */
        int yS;     /* y coordinate of a square */
        int side;   /* length of square sides */
        /* change string to integer variable */
        xS = Integer.parseInt(arrayLine[1]);
        yS = Integer.parseInt(arrayLine[2]);
        side = Integer.parseInt(arrayLine[3]);
        /* create a square */
        Square square = new Square(xS,yS,side);
        return square;
    }

    /**
     * Create a diamond.
     * @param arrayLine[] diamond data
     * @return diamond object
     */
    private static Diamond processDiamond(String arrayLine[])
    {
        int xD;     /* x coordinate of a diamond */
        int yD;     /* y coordinate of a diamond */
        int vAxis;  /* horizontal axis for perimeter calculations */
        int hAxis;  /* vertical axis for perimeter calculations */
        /* change string to integer variable */
        xD = Integer.parseInt(arrayLine[1]);
        yD = Integer.parseInt(arrayLine[2]);
        vAxis = Integer.parseInt(arrayLine[3]);
        hAxis = Integer.parseInt(arrayLine[4]);
        /* create a diamond */
        Diamond diamond = new Diamond(xD,yD,vAxis,hAxis);
        return diamond;
    }
}