import java.util.TreeSet;
import java.util.*;
/**
 *  TileCollection.java
 *
 *  A TileCollection is a record of tiles which can show all tiles,
 *  get the size of record, add tile to record, remove title from record,
 *  get the hightest and lowest score, random title from record.
 *
 *    Created by Thitiporn Sukpartcharoen, 11 March 2020
 *
 */
public class TileCollection
{
    /**
     * Record of tiles sorted by score
     */
    private TreeSet<Tile> tiles = new TreeSet<Tile>(new tileMaxCompare());

    /**
     * maximun record boudary
     */
    private int maxTiles = 100;

    /**
     * minimum record boudary
     */
    private int minTiles = 0;

    /**
     * Constructor class including the min and max
     * @param  MinTiles     minimum number of record
     * @param  MaxTitles    maximum number of record
     */
    public TileCollection(int MinTiles,int MaxTitles)
    {
        minTiles = MinTiles;
        maxTiles = MaxTitles;
    }

    /**
     * Show all the tite of record
     */
    public void printTiles()
    {
        System.out.print("Tiles: \n");
        Iterator<Tile> iteratorTitles = tiles.iterator(); // set iterator titles
        int count = 0;
        /* loop to show title */
        while (iteratorTitles.hasNext())
        {
            Tile thisTile = iteratorTitles.next();
            System.out.print(thisTile + "  ");
            count++; // increase counter
        }
    }

    /**
     * Return the size number of tiles
     * @return  size number of tiles
     */
    public int getTileCount()
    {
        return tiles.size();
    }

    /**
     * Return status of adding
     * @param  tile     new tile
     * @return  boolean of adding status 
     */
    public boolean addTile(Tile tile)
    {
        return tiles.add(tile);
    }

    /**
     * Return status of removing
     * @param  tile     removing tile
     * @return  boolean of removing status 
     */
    public boolean removeTile(Tile tile)
    {
        if (tiles.contains(tile))
        {
            /* check is empty */
            if ((tiles.size() - 1) >=  minTiles)
            {
                tiles.remove(tile);
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * Return tile which has the highest value
     * @return  tile which has the highest value
     */
    public Tile getHighest()
    {
        /* check is the record empty */
        if (tiles.isEmpty())
            return null;
        else
            return tiles.last();
    }

    /**
     * Return tile which has the lowestest value
     * @return  tile which has the lowest value
     */
    public Tile getLowest()
    {
        /* check is the record empty */
        if (tiles.isEmpty())
            return null;
        else
            return tiles.first();
    }

    /**
     * Random function
     * @return  tile which is randomed
     */
    public Tile getRandom()
    {
        if (tiles.isEmpty())
            return null;
        else
        {
            Object tilesList[] = tiles.toArray();                           //Change tile object to arraylist
            int randomIndex = (int) (Math.random() * 10000) % tiles.size(); // random index number
            return (Tile) tilesList[randomIndex];
        }
    }
}