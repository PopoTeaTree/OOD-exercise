import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.*;

public class LayoutConstraints extends JPanel
{
    private GridBagConstraints layoutConstraints;

    public LayoutConstraints()
    {
        layoutConstraints = new GridBagConstraints();
    }

    public void setGridWY(int Gridx,int Gridy)
    {
        layoutConstraints.gridx = Gridx;
        layoutConstraints.gridy = Gridy;
    }

    public void setGridHW(int GridHeight,int GridWidth)
    {
        layoutConstraints.gridheight = GridHeight;
        layoutConstraints.gridwidth = GridWidth;
    }

    public void setPosition(String Fill,Insets insets, String achor)
    {
        switch(Fill)
        {
            case "BOTH":
                layoutConstraints.fill = GridBagConstraints.BOTH;
                break;
            case "HORIZONTAL":
                layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
                break;
        }
        layoutConstraints.insets 	= insets;
        switch(achor)
        {
            case "CENTER":
                layoutConstraints.anchor 	= GridBagConstraints.CENTER;
                break;
            case "SOUTH":
                layoutConstraints.anchor 	= GridBagConstraints.SOUTH;
                break;
            case "NORTH":
                layoutConstraints.anchor 	= GridBagConstraints.NORTH;
                break;
            case "EAST":
                layoutConstraints.anchor 	= GridBagConstraints.EAST;
                break;
        }
    }

    public void setWeightXY(int weightX, int weighY)
    {
        layoutConstraints.weightx = weightX;
        layoutConstraints.weighty = weighY;
    }
}