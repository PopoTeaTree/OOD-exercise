/**
 *  Player.java
 *
 *  A player class is managing game which can init player,
 *  select tile, get name, get score, update score, show title
 *  and has the main function to ask a game to user
 *
 *  Created by Thitiporn Sukpartcharoen, 11 March 2020
 *
 */
import java.util.Scanner;

public class Player
{
    /**
     * player name
     */
    private String name;

    /**
     * amount of score
     */
    private int score = 0;

    /**
     * selecting tile record of player
     */
    private TileCollection playerTiles = new TileCollection(0,7);

    /**
     * Construct class of player
     * @param  Name   player name
     */
    public Player(String Name)
    {
        name = Name;
    }

    /**
     * Random title function following enter number from user
     * @param  howmany interger of amount of random number
     * @return  boolean of randoming status
     */
    public boolean selectTiles(int howMany)
    {
        boolean check = true;   // init status tile
        int i = 0;              // counter
        Tile tile = null;       // init randoming tile
        /* loop of random title */
        for (i = 0; (i < howMany) && check; i++)
        {
            tile = TileManager.selectRandomTile();  // random title
            /* Uncomplete random */
            if (tile == null)
                check = false;
            /* Add random to player record and check is it complete */
            else if( playerTiles.addTile(tile) )
            {
                check = true;
                /* update score */
                score = score + tile.getValue();
            }
            else
                check = false;
        }
        return check;
    }

    /**
     * Get player name
     * @return  string of player name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Get amount score
     * @return  integer of sum of tile value
     */
    public int getScore()
    {
        return score;
    }

    /**
     * Update tile score
     * @param  point interger of adding number
     */
    public void updateScore(int point)
    {
        score = score + point;
    }

    /**
     * Show all selecting tiles
     */
    public void printTiles()
    {
        playerTiles.printTiles();
    }

    /**
     * main function to play game 
     */
    static public void main(String args[])
    {
        TileManager.initTiles();                    // init tile pool
        Scanner inputmsg = new Scanner(System.in);  // input massage buffer
        System.out.print("Enter player name: ");    
        String inputName = inputmsg.next();         // get player name
        Player player = new Player(inputName);      // init player

        int counter = 0;                            // init loop counter
        /* loop for ask to play game */
        while(counter<7)
        {
            int maxCount = 7 - counter;             // init the maximun input number tile
            int minCount = 1;                       // init the minimum input number tile
            System.out.print("How many selecting titles from "+ minCount + " to " + maxCount + ": ");
            int selectingNo = inputmsg.nextInt();   // get random number tile
            /* check is random number in the range */
            if( selectingNo < 1)
                System.out.print("ERROR SELECT NUMBER MORE THAN 0 \n");
            else if(selectingNo > maxCount)
                System.out.print("ERROR SELECT NUMBER LESS THAN "+ maxCount + "\n");
            else
                {
                    /* call random title and check is it collect title */
                    if(player.selectTiles(selectingNo))
                    {
                        player.printTiles();
                        counter = counter + selectingNo;
                    }
                    else
                        System.out.print("ERROR SELECT NUMBER\n");
                }
                System.out.print("\n");
        }
        /* show the result */
        System.out.print("\n");
        System.out.print("All selecting titles: ");
        player.printTiles();
        System.out.print("\n");
        System.out.print("Your score: " + player.getScore());
    }
}