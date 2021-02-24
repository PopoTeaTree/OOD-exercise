/**
 *  Tile.java
 *
 *  A Tile is title format which init title,
 *  get score letter and get the tile letter.
 *
 *  Created by Thitiporn Sukpartcharoen, 11 March 2020
 *
 */
public class Tile implements Comparable<Tile>
{
    /**
     * tile letter
     */
    private String tileString;

    /**
     * tile score
     */
    private int tileValue;

    /**
     * Return score of title
     * @param  t    tile
     * @return  score of each tile
     */
    public int compareTo(Tile t)
    {
        return this.tileValue - t.tileValue;
    }

    /**
     * Construct class of title
     * @param  letter   tile
     * @param  vlaue    score
     */
    public Tile(String letter, int value)
    {
        tileString = letter;
        tileValue = value;
    }

    /**
     * Get letter
     * @return  letter of tile
     */
    public String getletter()
    {
        return tileString;
    }

    /**
     * Get score
     * @return  score of value
     */
    public int getValue()
    {
        return tileValue;
    }

    /**
     * Convert object tile to string
     * @return  string title data
     */
    public String toString()
    {
	    return new String(tileString + "-" + tileValue );
    }
}