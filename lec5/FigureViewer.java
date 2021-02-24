import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *  FigureViewer
 *
 *  Simple graphical application to display simple geometric figures
 *
 *  Created by Sally Goldin, 23 April 2013 for CPE 113
 *  Augmented for CPE372, 13 August 2017
 *  Modified for Exercise 2, CPE372 19 August 2017
 *     Removed the drawing completely, added function to return graphics
 * 
 *  Modified 17/02/2020 by Thitiporn Sukpartcharoen Popo 60070503419
 * 
 */
public class FigureViewer extends JFrame
                                     implements ActionListener, MouseListener
{
   /* UI objects */
   private DrawingCanvas drawCanvas = null;
   private JButton clearButton = null;
   private JButton exitButton = null;
   private JButton redrawButton = null;

   /** used to cycle through fill colors */
   protected static Color colors[] = {Color.RED, Color.GREEN, Color.BLUE,
    Color.MAGENTA, Color.ORANGE};

    /** collection of all clicked shapes */
    protected ArrayList<AbstractShape> shapeIns = new ArrayList<AbstractShape>();

   /**
    * Constructor creates the User Interface.
    */
   public FigureViewer()
   {
      super("Figure Viewer");
      buildUI();
   }

   /**
    * Create the visible part of the user interface.
    */
   private void buildUI()
   {
      JPanel mainPanel = new JPanel(new BorderLayout());
      mainPanel.setBorder(new EmptyBorder(10,10,10,10));
      JPanel controlPanel = new JPanel(new FlowLayout());
      controlPanel.setBorder(new EtchedBorder());


      clearButton = new JButton("Clear");
      clearButton.addActionListener(this);
      controlPanel.add(clearButton);

      exitButton = new JButton("Exit");
      exitButton.addActionListener(this);
      controlPanel.add(exitButton);
      mainPanel.add(controlPanel, BorderLayout.NORTH);

      redrawButton = new JButton("REDRAW");
      redrawButton.addActionListener(this);
      controlPanel.add(redrawButton);

      drawCanvas = new DrawingCanvas(400,400);
      drawCanvas.setBorder(new EtchedBorder());
      drawCanvas.setBackground(Color.white);
      mainPanel.add(drawCanvas, BorderLayout.CENTER);
      getContentPane().add(mainPanel, BorderLayout.CENTER);
      drawCanvas.addMouseListener(this);
   }

   /**
    * This is the method required for the ActionListener
    * interface. It handles the necessary actions when
    * buttons are pressed.
    */
   public void actionPerformed(ActionEvent e)
   {
       Object source = e.getSource();
       if (source == exitButton)
       {
	        System.exit(0);
       }
       else if (source == clearButton)
       {
	        drawCanvas.clear();
       }
       else if (source == redrawButton)
       {
            // loop for fill the shape again
            for(int i=0;i<shapeIns.size();i++)
            {
                AbstractShape shape = shapeIns.get(i);
                shape.draw(this.getViewerGraphics(),colors[i]);
            }
       }
   }

   /** Clear the drawing panel.
    */
   public void clear()
   {
       drawCanvas.clear();
   }

   /**
    * Return the graphics context associated with
    * the panel used for drawing.
    @return  Graphics context
    */
   public Graphics2D getViewerGraphics()
   {
       return (Graphics2D) drawCanvas.getGraphics();
   }

   /**
    * Return the graphics context associated with
    * the panel used for drawing.
    @return  Graphics context
    */
    public void mouseClicked(MouseEvent e)
    {
        int x=e.getX(); //get x coordinate of the clicking
        int y=e.getY(); //get y coordinate of the clicking
        System.out.println(x+","+y);
        //call function for getting arraylist of clicked shape
        shapeIns = AbstractShape.checkInShape(x,y);
        System.out.println(shapeIns);
        // loop for fill all the clicked shape
        for(int i=0;i<shapeIns.size();i++)
        {
            AbstractShape shape = shapeIns.get(i);
            shape.draw(this.getViewerGraphics(),colors[i]);
        }
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}