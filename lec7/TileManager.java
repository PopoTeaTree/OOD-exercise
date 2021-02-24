/**
 *  TileManager.java
 *
 *  A TileManager is a pool of tiles which can initial title and
 *  randoming tile for game
 *
 *  Created by Thitiporn Sukpartcharoen, 11 March 2020
 *
 */
public class TileManager
{
    /**
     * tile pool limiting boundary between 0 to 100
     */
    private static TileCollection tiles = new TileCollection(0,100);

    /**
     * Initialize tile pool
     */
    public static void initTiles()
    {
        tiles.addTile(new Tile("A", 9));
        tiles.addTile(new Tile("B", 2));
        tiles.addTile(new Tile("C", 2));
        tiles.addTile(new Tile("D", 4));
        tiles.addTile(new Tile("E", 12));
        tiles.addTile(new Tile("F", 2));
        tiles.addTile(new Tile("G", 3));
        tiles.addTile(new Tile("H", 2));
        tiles.addTile(new Tile("I", 9));
        tiles.addTile(new Tile("J", 1));
        tiles.addTile(new Tile("K", 1));
        tiles.addTile(new Tile("L", 4));
        tiles.addTile(new Tile("M", 2));
        tiles.addTile(new Tile("N", 6));
        tiles.addTile(new Tile("O", 8));
        tiles.addTile(new Tile("P", 2));
        tiles.addTile(new Tile("Q", 1));
        tiles.addTile(new Tile("R", 6));
        tiles.addTile(new Tile("S", 4));
        tiles.addTile(new Tile("V", 2));
        tiles.addTile(new Tile("W", 2));
        tiles.addTile(new Tile("X", 1));
        tiles.addTile(new Tile("Y", 2));
        tiles.addTile(new Tile("Z", 1));

        tiles.addTile(new Tile("A", 1));
        tiles.addTile(new Tile("B", 3));
        tiles.addTile(new Tile("C", 3));
        tiles.addTile(new Tile("D", 2));
        tiles.addTile(new Tile("E", 1));
        tiles.addTile(new Tile("F", 4));
        tiles.addTile(new Tile("G", 2));
        tiles.addTile(new Tile("H", 4));
        tiles.addTile(new Tile("I", 1));
        tiles.addTile(new Tile("J", 8));
        tiles.addTile(new Tile("K", 5));
        tiles.addTile(new Tile("L", 1));
        tiles.addTile(new Tile("M", 3));
        tiles.addTile(new Tile("N", 2));
        tiles.addTile(new Tile("O", 1));
        tiles.addTile(new Tile("P", 3));
        tiles.addTile(new Tile("Q", 10));
        tiles.addTile(new Tile("R", 1));
        tiles.addTile(new Tile("S", 1));
        tiles.addTile(new Tile("V", 4));
        tiles.addTile(new Tile("W", 4));
        tiles.addTile(new Tile("X", 8));
        tiles.addTile(new Tile("Y", 4));
        tiles.addTile(new Tile("Z", 10));
    }

    /**
     * Random title and remove selected tile from title pool
     * @return  randamed title
     */
    public static Tile selectRandomTile()
    {
        Tile tileRandom = tiles.getRandom();    //get randaom tile
        /* Check is it already random */
        if(tileRandom != null)
        {
            /* remove title from title pool */
            tiles.removeTile(tileRandom);
        }
        return tileRandom;
    }
}