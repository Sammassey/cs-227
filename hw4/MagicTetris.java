
package hw4;

import java.util.List;
import api.AbstractGame;
import api.Position;
import java.util.ArrayList;

/**
 * MagicTetris implementation.
 * 
 * @author
 * Sam Massey
 */
public class MagicTetris extends AbstractGame
{
	/**
	 * Holds the given width of the game.
	 */
	private int givenWidth;
	
	/**
	 * Holds the given height of the game.
	 */
	private int givenHeight;
	
	/**
	 * States if the game is in gravity mode. 
	 */
	private boolean gravity;
	
	/**
	 * Holds the current score for the current game.
	 */
	private int score;
	
  /**
   * Constructs a game with the given width (columns) and height (rows).
   * This game will use a new instance of BasicGenerator to 
   * generate new shapes.
   * @param width
   *   width of the game grid (number of columns)
   * @param height
   *   height of the game grid (number of rows)
   */
  public MagicTetris(int width, int height)
  {
    super(width, height, new BasicGenerator());
    givenWidth = width;
    givenHeight = height;
    gravity = false;
  }

  /**
   * Returns a list of positions that will collapse.
   */
  @Override
  public List<Position> determinePositionsToCollapse()
  {
    ArrayList<Position> positionList = new ArrayList<Position>();
    ArrayList<Position> temp = new ArrayList<Position>();
    int magic = 0;
    
    //if gravity mode is turned off.
    if(!gravity)
    {
    	magic = 0;
    	//Iterates through each row
    	for(int i = 0; i < givenHeight; i++)
    	{
    		//Iterates through each column in each row
    		for(int j = 0; j < givenWidth; j++)
    		{
    			if(getBlock(i, j) != null)
    			{
    				temp.add(new Position(i, j));
    			}
    		}
    		//If a row is full, add it to the positions list to be returned.
    		if(temp.size() == givenWidth)
    		{
    			for(int k = 0; k < temp.size(); k++)
    			{
    				positionList.add(temp.get(k));
    				if(getBlock(temp.get(k).row(),temp.get(k).col()).isMagic())
    				{
    					magic++;
    				}
    			}
    			score += Math.pow(2, magic);
    		}
    		temp = new ArrayList<Position>();
    	}
    }
    //If gravity mode is on go here.
    else
    {
    	for(int i = 0; i < givenWidth; i++)
    	{
    		for(int j = 0; j < givenHeight; j++)
    		{
    			if(getBlock(j, i) != null)
    			{
    				int k = j;
    				while(k < givenHeight)
    				{
    					//Adds all the blocks under the original block so it will fall.
    					if(getBlock(k, i) == null)
    					{
    						temp.add(new Position(k, i));
    					}
    					k++;
    				}
    				j = k;
    			}
    		}
    	}
    	//converts the temp list to the list of positions.
    	for(int s = 0; s < temp.size(); s++)
		{
			positionList.add(temp.get(s));
		}
    	//Turns gravity mode off.
    	gravity = false;
    }
    //If there were 3 or more magic blocks and a row to be deleted, turn gravity mode on.
	if(magic >= 3 && positionList.size() >= 4)
	{
		gravity = true;
	}
	//returns the list of positions.
    return positionList;
  }

  /**
   * returns the score of the game.
   */
  @Override
  public int determineScore()
  {
    return score;
  }

}
