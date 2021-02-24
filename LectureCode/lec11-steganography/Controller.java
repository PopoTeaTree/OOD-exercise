import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.imageio.ImageIO;
import javax.swing.*;



/**
 *
 * This class is the mediator between steganography and view and when which one have some changes, controller
 * will reacts to the other one by execute or update that make view and steganography connect together all the time.
 * When user click encode or decode button in the view, controller are going to bring method in the steganography to use
 * and show the result message or hidden text in the view
 *
 * Created by Kullapat Siribodhi 58070503404
 *            Thanadol Nimitchuchai 58070503442, 20 Nov 2017
 *
 * Edited by Thitiporn Sukpartcharoen 60070503419, 1 May 2020
 *
 * **/
public class Controller
{
	private JButton encodeButton;
	private JButton decodeButton;
	private View view;
	private Steganography model;
	private Controller controller;
	private JPanel encodePanel;
	private JPanel decodePanel;
	private JLabel imageInput;
	private JTabbedPane tabPanel;
	private boolean encoded = false;
	private String inputText;
	private String ext;
	private String fileName;
	private String filePath;
	private JTextArea output;
	private JTextArea input;
	private String outputFileName;
	private JLabel imageOutput;

	/* Arraylist of JCheckBox */
	private ArrayList<JCheckBox> arrayJCheckBox = new ArrayList<JCheckBox>();

	/* constructor of controller */
	public Controller(View v, Steganography m)
	{
		view = v;
		model = m;

		encodePanel = view.getEncodePanel();
		decodePanel = view.getDecodePanel();
		imageInput = view.getImageInput();
		imageOutput = view.getImageOutput();

		encodeButton = view.getEncodeButton();
		decodeButton = view.getDecodeButton();

		output = view.getOutputText();
		input = view.getInputText();

		tabPanel = view.getTabPanel();

		arrayJCheckBox.add(view.getMD5());
		arrayJCheckBox.add(view.getSHA256());
		arrayJCheckBox.add(view.getSHA1());
		arrayJCheckBox.add(view.getNTEXT());

		/* use ActionListener for encode and decode button for clicking */
		encodeButton.addActionListener(new EncodeButton());
		decodeButton.addActionListener(new DecodeButton());
	}

	/**
	 * This class use after the encode button has clicked with ActionListener
	 * User need to select the image from your device for encode by JFileChooser and input
	 * the name of file that will be your output file
	 * There are 4 types of text that you need to choose : normal,md5,sha1 and sha56
	 * The encode method is the main method in this class
	 * We will get the image that already has hidden the text like the result
	 * **/
	private class EncodeButton implements ActionListener
	{
		/**
		 * Fundamental method manage file action
		 * @param  e   action event
		 *
		 */
		public void actionPerformed(ActionEvent e)
		{
			JFileChooser chooser = new JFileChooser("./");
			chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			chooser.setFileFilter(new Image_Filter());
			int returnVal = chooser.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION)
			{
				/* Selected file from interface */
				File fileSelected = chooser.getSelectedFile();
					try
					{
						saveText(chooser);
						modelCheck();
					}
					catch(Exception except) {
						JOptionPane.showMessageDialog(view, "File cannot open");
					}
			}
		}

		/**
		 * Fundamental method manage Text file
		 * @param  chooser    chooser file
		 *
		 */
		public void saveText(JFileChooser chooser)
		{
			File fileSelected = chooser.getSelectedFile();
			inputText = input.getText();
			ext = Image_Filter.getExtension(fileSelected);
			fileName = fileSelected.getName();
			filePath = fileSelected.getPath();
			System.out.println("Before " + "InputText: " + inputText + " ext: " + ext + " fileName: " + fileName + " filePath: " + filePath);
			filePath = filePath.substring(0,filePath.length()-fileName.length()-1);
			fileName = fileName.substring(0, fileName.length()-4);
			System.out.println("InputText: " + inputText + " ext: " + ext + " fileName: " + fileName + " filePath: " + filePath);
			outputFileName = JOptionPane.showInputDialog("Please assign an output file name: ");
		}

		/**
		 * Fundamental method manage check box to encode to the file
		 *
		 */
		public void modelCheck() throws Exception
		{
			int i = 0;
			while(i<arrayJCheckBox.size())
			{
				/* file name */
				String objectName = arrayJCheckBox.get(i).getName();
				if(i==arrayJCheckBox.size()-1)
				{
					objectName = null;
				}

				if(arrayJCheckBox.get(i).isSelected() || i==arrayJCheckBox.size()-1)
				{
					if(model.encode(filePath, fileName, ext, outputFileName, inputText,objectName))
					{
						JOptionPane.showMessageDialog(view, "successfully encoded an image");
						successEncoded(filePath, fileName, ext, outputFileName);
					}
					else
					JOptionPane.showMessageDialog(view, "Cannot encode files");
					break;
				}
				i++;
			}
		}
	}

	/**
	 *
	 * This class use after decode button has clicked with ActionListener
	 * We can separate in to 2 cases that we can encode :
	 * First case, we use the current image that we encoded
	 * Second case, we choose the image from the device by JFileChooser
	 * we will get the string that hided in the image like the result
	 *
	 * **/
	private class DecodeButton implements ActionListener
	{

		/**
		 * Fundamental method manage Text file
		 * @param  chooser    chooser file
		 *
		 */
		public void saveText(File fileSelected)
		{
			ext = Image_Filter.getExtension(fileSelected);
			outputFileName = fileSelected.getName();
			filePath = fileSelected.getPath();
			filePath = filePath.substring(0,filePath.length()-outputFileName.length()-1);
			outputFileName = outputFileName.substring(0, outputFileName.length()-4);
			System.out.println("outputname:"+ outputFileName);
			System.out.println("Length outputFile Byte:" + new File(filePath + "/" + outputFileName + ".png").length() + "byte");
		}

		/**
		 * Fundamental method manage message to set the image path
		 * @param  massage		read meassage
		 */
		public void messageSet(String message)
		{
			if(message != "")
			{
				try
				{
					imageInput.setIcon(new ImageIcon(ImageIO.read(new File(filePath + "/" + outputFileName + ".png"))));
				}
				catch(Exception except)
				{
					JOptionPane.showMessageDialog(view, "Cannot show result");
				}

				System.out.println("message: " + message);
				output.setText(message);
			}
			else
				JOptionPane.showMessageDialog(view, "No encoded Text");
		}

		/**
		 * Fundamental method decode action event
		 * @param  e 	action event
		 */
		public void actionPerformed(ActionEvent e)
		{
			if(!encoded)
			{
				JFileChooser chooser = new JFileChooser("./");
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				chooser.setFileFilter(new Image_Filter());
				int returnVal = chooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION)
				{
					File fileSelected = chooser.getSelectedFile();
						try
						{
							saveText(fileSelected);
							String message = model.decode(filePath, outputFileName);
						}
						catch(Exception except){
							JOptionPane.showMessageDialog(view, except);
							System.out.println("outputname:"+ outputFileName);
						}
				}
			}
			else
			{
				String message = model.decode(filePath, outputFileName);
				messageSet(message);
			}
		}
	}

	/**
	 *
	 * This class use to show the size of input file and output file that already has hidden the text and the length
	 * of text that we type in the terminal after encode method succeed its process
	 *
	 * @param filePath : The folder or address of the file
	 * @param fileName : The name of the file
	 * @param ext : The extension of the file
	 * @param outputFileName : The name of output file
	 *
	 * **/
	public void successEncoded(String filePath, String fileName, String ext, String outputFileName) throws Exception
	{
		tabPanel.setSelectedIndex(2);
		imageInput.setIcon(new ImageIcon(ImageIO.read(new File(filePath + "/" + fileName + "." + ext))));
		imageOutput.setIcon(new ImageIcon(ImageIO.read(new File(filePath + "/" + outputFileName + ".png"))));
		encoded = true;
		JOptionPane.showMessageDialog(view, "Input file size: " + new File(filePath + "/" + fileName + "." + ext).length() + " byte" + "\n"
		+ "Output file size: " + new File(filePath + "/" + outputFileName + ".png").length() + " byte");
		System.out.println("Length of input file: " + new File(filePath + "/" + fileName + ".png").length() + " byte");
		System.out.println("Length of output file: " + new File(filePath + "/" + outputFileName + ".png").length() + " byte");
	}

	public static void main(String args[])
	{
		new Controller(new View("Steganography"), new Steganography());
	}
}