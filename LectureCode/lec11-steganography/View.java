import java.awt.Checkbox;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.*;

/**
 *
 * This class is our program user interface which need to show to user for process every method
 * We separate into 3 parts encode panel, decode panel and image panel
 * - Encode panel need to receive text by type some strings in the panel, import image from device
 * by press encode button and give the name to the output file that will appear in your device
 * - Decode panel need to receive the image file that user want to decode for extract hidden message from the image
 * - Image panel use for show original picture and the picture that already encode text into the image
 *
 * Created by Kullapat Siribodhi 58070503404
 *            Thanadol Nimitchuchai 58070503442, 20 Nov 2017
 *
 * Edited by Thitiporn Sukpartcharoen 60070503419, 5 May 2020
 *
 * **/
public class View extends JFrame
{
	JFrame f = new JFrame();
	private static int WIDTH = 600;
	private static int HEIGHT = 500;

	private JTextArea input;
	private JTextArea output;
	private JPanel encode_panel;
	private JPanel decode_panel;
	private JPanel image_panel;
	private JButton encodeButton;
	private JButton decodeButton;
	private JTabbedPane tp;
	private JLabel image_input;
	private JLabel image_output;
	private JCheckBox md5; /* type of hash function */
	private JCheckBox sha1; /* type of hash function */
	private JCheckBox sha256; /* type of hash function */
	private JCheckBox nText; /* type of hash function */

	public View(String name)
	{
		super(name);

	    encode_panel = new JPanel();
	    decode_panel = new JPanel();
	    image_panel = new JPanel();
		tp = new JTabbedPane();

	    tp.add("encode", new Encode_Panel());
	    tp.add("decode", new Decode_Panel());
	    tp.add("result", new Image_Panel());
	    f.add(tp);  

	    f.setResizable(true);
	    f.setSize(WIDTH,HEIGHT);
	    f.setVisible(true); 
	}

	public JCheckBox getMD5(){
		return md5;
	}
	
	public JCheckBox getSHA1(){
		return sha1;
	}
	
	public JCheckBox getSHA256(){
		return sha256;
	}
	
	public JCheckBox getNTEXT(){
		return nText;
	}
	
	public JTextArea getInputText() {
		return input;
	}
	
	public JTextArea getOutputText(){
		return output;
	}
	
	public JPanel getEncodePanel() {
		return encode_panel;
	}
	
	public JPanel getDecodePanel() {
		return decode_panel;
	}
	
	public JLabel getImageInput(){
		return image_input;
	}
	
	public JLabel getImageOutput(){
		return image_output;
	}
	
	public JButton getEncodeButton() {
		return encodeButton;
	}

	public JButton getDecodeButton() {
		return decodeButton;
	}

	public JTabbedPane getTabPanel(){
		return tp;
	}

	/** 
	 * This class is the panel of the encode method which need to input the text for
	 * hide in the image like secret message. There are 4 types of hash function types which have different algorithms and different
	 * result. The encode button is the main button that start the process and we need to define output
	 * filename which will appear in your device after encode processing succeed.
	 * 
	 * **/
	private class  Encode_Panel extends JPanel
	{
		/**
		 * Fundamental method encode panel to mange the JPanel box
		 */
		public Encode_Panel()
		{
			GridBagLayout layout = new GridBagLayout();
			GridBagConstraints layoutConstraints = new GridBagConstraints();
			setLayout(layout);

			JTextAreaLayout(layoutConstraints, layout);
			encodeButtonLayout(layoutConstraints,layout);
			JCheckBox nText = nTextLayout(layoutConstraints,layout);
			JCheckBox md5 = md5Layout(layoutConstraints,layout);
			JCheckBox sha256 = sha256Layout(layoutConstraints, layout);
			JCheckBox sha1 = sha1Layout(layoutConstraints,layout);

			ArrayList<JCheckBox> goupJCheck = new ArrayList<>();
			goupJCheck.add(nText);
			goupJCheck.add(md5);
			goupJCheck.add(sha256);
			goupJCheck.add(sha1);
			buttonGroup(goupJCheck);
		}

		/**
		 * Fundamental method button group to get the check box and add to group
		 * @param  goupJCheck    Arraylist of JCheckBox
		 *
		 */
		public void buttonGroup(ArrayList<JCheckBox> goupJCheck)
		{
			/* Button group of JCheckBox */
			ButtonGroup group = new ButtonGroup();
			for(int i=0;i<goupJCheck.size();i++)
			{
				group.add(goupJCheck.get(i));
				add(goupJCheck.get(i));
			}
		}

		/**
		 * Fundamental method to set JTextArea layout and position
		 * @param  layoutConstraints    Grid Bag Constraints layout
		 * @param  layout    			Second tile
		 *
		 */
		public void JTextAreaLayout(GridBagConstraints layoutConstraints, GridBagLayout layout)
		{
			input = new JTextArea();
			layoutConstraints.gridx 	= 0; layoutConstraints.gridy = 0;
			layoutConstraints.gridwidth = 20; layoutConstraints.gridheight = 1;
			layoutConstraints.fill 		= GridBagConstraints.BOTH;
			layoutConstraints.insets 	= new Insets(0,0,0,0);
			layoutConstraints.anchor 	= GridBagConstraints.CENTER;
			layoutConstraints.weightx 	= 1.0; layoutConstraints.weighty = 50.0;
			JScrollPane scroll = new JScrollPane(input,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			layout.setConstraints(scroll,layoutConstraints);
	    	add(scroll);

	    	// Line wrap inside JTextArea
	    	input.setLineWrap(true);
	    	input.setWrapStyleWord(true);
		}

		/**
		 * Fundamental method to set encode Button layout and position
		 * @param  layoutConstraints    Grid Bag Constraints layout
		 * @param  layout    			Second tile
		 *
		 */
		public void encodeButtonLayout(GridBagConstraints layoutConstraints, GridBagLayout layout)
		{
			encodeButton = new JButton("Encode");
	    	layoutConstraints.gridx 	= 0; layoutConstraints.gridy = 1;
			layoutConstraints.gridwidth = 1; layoutConstraints.gridheight = 1;
			layoutConstraints.fill 		= GridBagConstraints.BOTH;
			layoutConstraints.insets 	= new Insets(0,-5,-5,-5);
			layoutConstraints.anchor 	= GridBagConstraints.CENTER;
			layoutConstraints.weightx 	= 1.0; layoutConstraints.weighty = 1.0;
			layout.setConstraints(encodeButton,layoutConstraints);
	    	add(encodeButton);
		}

		/**
		 * Fundamental method to set nText layout and position
		 * @param  layoutConstraints    Grid Bag Constraints layout
		 * @param  layout    			Second tile
		 * @return nText 				CheckBox
		 *
		 */
		public JCheckBox nTextLayout(GridBagConstraints layoutConstraints, GridBagLayout layout)
		{
	    	nText = new JCheckBox("NORMAL TEXT");
	    	layoutConstraints.gridx = 0;
	    	layoutConstraints.gridy = 2;
	    	layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
			layoutConstraints.anchor 	= GridBagConstraints.SOUTH;
			layout.setConstraints(nText ,layoutConstraints);
			return nText;
		}

		/**
		 * Fundamental method to set md5 layout and position
		 * @param  layoutConstraints    Grid Bag Constraints layout
		 * @param  layout    			Second tile
		 * @return md5	 				CheckBox
		 *
		 */
		public JCheckBox md5Layout(GridBagConstraints layoutConstraints, GridBagLayout layout)
		{
			md5 = new JCheckBox("MD5");
	    	layoutConstraints.gridx = 1;
	    	layoutConstraints.gridy = 2;
	    	layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
			layoutConstraints.anchor 	= GridBagConstraints.SOUTH;
			layout.setConstraints(md5 ,layoutConstraints);
			return md5;
		}

		/**
		 * Fundamental method to set sha1 layout and position
		 * @param  layoutConstraints    Grid Bag Constraints layout
		 * @param  layout    			Second tile
		 * @return sha1 				CheckBox
		 *
		 */
		public JCheckBox sha1Layout(GridBagConstraints layoutConstraints, GridBagLayout layout)
		{
			sha1 = new JCheckBox("SHA-1");
	    	layoutConstraints.gridx = 2;
	    	layoutConstraints.gridy = 2;
	    	layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
			layoutConstraints.anchor 	= GridBagConstraints.SOUTH;
			layout.setConstraints(sha1 ,layoutConstraints);
			return sha1;
		}

		/**
		 * Fundamental method to set sha256 layout and position
		 * @param  layoutConstraints    Grid Bag Constraints layout
		 * @param  layout    			Second tile
		 * @return sha256 				CheckBox
		 *
		 */
		public JCheckBox sha256Layout(GridBagConstraints layoutConstraints, GridBagLayout layout)
		{
			sha256 = new JCheckBox("SHA-256");
	    	layoutConstraints.gridx = 3;
	    	layoutConstraints.gridy = 2;
	    	layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
			layoutConstraints.anchor 	= GridBagConstraints.SOUTH;
			layout.setConstraints(sha256 ,layoutConstraints);
			return sha256;
		}

	}

	/**
	 *  This class is the panel of decode method which will show the string after we extract the hidden text
	 * from the image. The decode button is the main button that start the process and we need to input the image file
	 * for start decode processing.
	 *
	 * **/
	private class Decode_Panel extends JPanel
	{
		/**
		 * Fundamental method encode panel to mange the JPanel box
		 */
		public Decode_Panel()
		{
			GridBagLayout layout = new GridBagLayout(); 
			GridBagConstraints layoutConstraints = new GridBagConstraints(); 
			setLayout(layout);
			encodeButtonLayout(layoutConstraints,layout);
			JTextArea output = JTextAreaLayout(layoutConstraints,layout);
	    	// Line Wrap inside JTextArea
	    	output.setLineWrap(true);
	    	output.setWrapStyleWord(true);
		}

		/**
		 * Fundamental method to set encode Button layout and position
		 * @param  layoutConstraints    Grid Bag Constraints layout
		 * @param  layout    			Second tile
		 *
		 */
		public void encodeButtonLayout(GridBagConstraints layoutConstraints, GridBagLayout layout)
		{
			decodeButton = new JButton("Decode");
	    	layoutConstraints.gridx 	= 0; layoutConstraints.gridy = 1; 
			layoutConstraints.gridwidth = 1; layoutConstraints.gridheight = 1; 
			layoutConstraints.fill 		= GridBagConstraints.BOTH; 
			layoutConstraints.insets 	= new Insets(0,-5,-5,-5); 
			layoutConstraints.anchor 	= GridBagConstraints.CENTER; 
			layoutConstraints.weightx 	= 1.0; layoutConstraints.weighty = 1.0;
			layout.setConstraints(decodeButton,layoutConstraints);
	    	add(decodeButton);
		}

		/**
		 * Fundamental method to set JTextArea layout and position
		 * @param  layoutConstraints    Grid Bag Constraints layout
		 * @param  layout    			Second tile
		 *
		 */
		public JTextArea JTextAreaLayout(GridBagConstraints layoutConstraints, GridBagLayout layout)
		{
			output = new JTextArea();
			layoutConstraints.gridx 	= 0; layoutConstraints.gridy = 0; 
			layoutConstraints.gridwidth = 20; layoutConstraints.gridheight = 1; 
			layoutConstraints.fill 		= GridBagConstraints.BOTH; 
			layoutConstraints.insets 	= new Insets(0,0,0,0); 
			layoutConstraints.anchor 	= GridBagConstraints.CENTER;
			layoutConstraints.weightx 	= 1.0; layoutConstraints.weighty = 50.0;
			JScrollPane scroll = new JScrollPane(output,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
			layout.setConstraints(scroll,layoutConstraints);
			add(scroll);
			return output;
		}
	}

	/**
	 * This class is the panel that use for show original image and the image which already encode by add text
	 * into image by byte array replacement. Two pictures will be very similarly.
	 *
	 * **/
	private class Image_Panel extends JPanel
	{
		/**
		 * Fundamental method image panel to mange the JLabel of image
		 */
		public Image_Panel()
		{
			GridLayout layout = new GridLayout(0, 2);
			setLayout(layout);
			image_input = new JLabel("Input", SwingConstants.CENTER);
			image_output = new JLabel("Output", SwingConstants.CENTER);
			imageLayout(image_input);
			imageLayout(image_output);
		}

		/**
		 * Fundamental method to set image layout and position
		 * @param  image    JLabel image
		 *
		 */
		public void imageLayout(JLabel image)
		{
			image.setVerticalAlignment(SwingConstants.TOP);
			JScrollPane scroll = new JScrollPane(image,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			image.setHorizontalAlignment(JLabel.CENTER);
	    	add(scroll);
		}
	}
}