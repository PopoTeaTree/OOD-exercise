import java.util.*;
import java.awt.*;
import java.time.chrono.ThaiBuddhistChronology;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.event.EventListenerList;
import java.util.EventListener;

import javax.swing.*;
/**
 * Class to test reading of shape command files and displaying of information
 * about instances of AbstractShape that are created.
 *
 *   Created by Sally Goldin, 2 September 2017, for Exercise 4 CPE372
 * 	 Modified 17/02/2020 by Thitiporn Sukpartcharoen Popo 60070503419
 * 
 */
public class ShapeFileTester
{
    /**
     * instance of reader that knows how to parse the files
     */
	private static ShapeReader reader;

	/**
    * FigureViewer instance for drawing shapes.
    */
	private static FigureViewer viewer;

    /**
     * main method which controls the reading and displays the results
     */
    static public void main(String args[])
    {
		viewer = new FigureViewer();
		viewer.pack();
		viewer.setVisible(true);
		Graphics2D graphics = viewer.getViewerGraphics();
		if (args.length != 1)
		{
			System.out.println("Usage:   java ShapeFileTester [filetoread]\n");
			System.exit(0);
		}
		reader = new ShapeReader();
		System.out.print("Trying to open'" + args[0] + "' ... ");
		if (!reader.open(args[0]))
		{
			System.out.println("FAILED!\n\n");
			System.exit(1);
		}
		System.out.println("Success!\n");
		AbstractShape nextShape = reader.readShape();
		while (nextShape != null)
		{
			System.out.println("  readShape returned an object: " + nextShape.getClass().toString());
			System.out.println("      toString: " + nextShape.toString());
			System.out.println("      perimeter: " + nextShape.calcPerimeter());
			nextShape.draw(graphics);
			nextShape = reader.readShape();
		}
		reader.close();
		System.out.println("\nClosing file\n\n");

		// viewer.getContentPane().addMouseListener(new clickListener());
		// viewer.addMouseListener(new ActionListener() {
        //     @Override
        //     public void mouseClicked(MouseEvent e)
		// 	{
		// 		 int x=e.getX();
		// 		 int y=e.getY();
		// 		 System.out.println(x+","+y);//these co-ords are relative to the component
		// 		 //System.out.println("Innnn"+ reShape.toString());
		// 		 // clear();
		// 			}
		// });
	}
}