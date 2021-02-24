import java.awt.*;
import java.util.* ;
/**
 *  Game.java
 *
 *  A player class is a class which manage a new scable game.
 *  It can support 2-4 players for playing game that create
 *  player, random an tile and show the scable board.
 *
 *  Created by Thitiporn Sukpartcharoen, 11 March 2020
 *
 */
public class Game
{

    /**
     * Player list
     */
    private Player players[] = new Player[4];

    /**
     * Amount of player
     */
    private int playerNo = 0;

    /**
     * A new initial game to start scabble game
     * @return Starting player
     */
    public Player newGame()
    {
        Tile highTile = null;   // the highest value of tile
        Tile tile = null;       // a tile
        int i = 0;              // looping counter
        int startPlayer = 0;    // starting player
        /* Initial game manager */
        TileManager.initialize();
        /* Looping for playing game and random a tile to find the first player */
        for(i=0;i<4;i++)
        {
            Scanner inputmsg = new Scanner(System.in);          // initial input massage command
            int index = i+1;                                    // order of players
            System.out.print(index +". Enter player name: ");
            String name = inputmsg.nextLine();
            /* Check is user already input data */
            if(name.length()!=0)
            {
                players[i] = new Player(name);      //add new player
                playerNo++;

                /* Random tiles */
                if(!players[i].selectTiles(1))
                {
                    System.out.println("ERROR - SELECTED TILE");
		            System.exit(0);
                }
                else
                {
                    tile = players[i].getHighest();
                    System.out.println("Player " + (i+1) + ": " + tile);
                    /* Check the hightest value of tiles */
                    if  ((highTile == null) || (tile.getTileValue() > highTile.getTileValue()))
                    {
                        highTile = tile;
                        startPlayer = i;
                    }
                }
            }
            else
            {
                /* Check is player is it enough */
                if(playerNo==1)
                    {
                        System.out.print("ERROR- ADD MORE PLAYERS \n");
                        i = i-1;
                    }
                else
                    break;
            }
        }
        System.out.print("======================== \n");
        return players[startPlayer];
    }

    /**
     * Main function to show who is the starting player
     */
    public static void main(String[] args)
    {
        Player startPlayer;
        Game game = new Game();
        startPlayer = game.newGame();
        System.out.println("The first player is " + startPlayer.getName());
    }
}