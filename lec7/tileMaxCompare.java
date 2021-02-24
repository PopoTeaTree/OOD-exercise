/**
 *  titleMaxCompare.java
 *
 *  A titleMaxCompare class is a class to sort the tile tree set that implenter 
 *  comparator tile
 *
 *  Created by Thitiporn Sukpartcharoen, 11 March 2020
 *
 */
import java.util.*; 

public class tileMaxCompare implements Comparator<Tile>
{
    /**
     * Return status of adding
     * @param  e1     first tile to compare
     * @param  e2     second tile to compare
     * @return  integer which is a status of comparing
     */
    @Override
    public int compare(Tile e1, Tile e2) {
        /* Check is the first title more than the second one */
        if(e1.getValue() > e2.getValue()){
            return 1;
        } else {
            return -1;
        }
    }
}