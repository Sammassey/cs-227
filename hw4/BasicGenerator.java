
package hw4;

import api.Generator;
import api.Position;
import api.Shape;
import java.util.Random;

/**
 * Generator for Shape objects in MagicTetris.  All six shapes
 * are equally likely, and the generated shape is magic with
 * 20% probability.
 * 
 * @author
 * Sam Massey
 */
public class BasicGenerator implements Generator
{
	/**
	 * A random instanced used for the type of shape.
	 */
	private Random firstRand = new Random();
	
	/**
	 * A random instance used for to decide if a block will be magic or not.
	 */
	private Random secondRand = new Random();
	
	/**
	   * Returns a new Shape instance according to this generator's 
	   * strategy.
	   * @param width
	   *   the width the game grid
	   * @return 
	   *   a new Shape 
	   */
	@Override
	public Shape getNext(int width)
	{
		//Generate a number 0-5
		int shape = firstRand.nextInt(6);
		
		//Generate a number 0-4
		int magic = secondRand.nextInt(5);
		boolean isMagic = false;
		
		//If magic is 1(Which is a 20% chance of happening), set the isMagic variable to be true.
		if(magic == 1)
		{
			isMagic = true;
		}
		
		//Used to place the block
		int mid = width / 2;
		
		//If the first randomly generated number was 0, create a LShape block.
		if(shape == 0)
		{
			return new LShape(new Position(-1, mid + 1), isMagic);
		}
		
		//If the first randomly generated number was a 1, create a JShape block.
		if(shape == 1)
		{
			return new JShape(new Position(-1, mid), isMagic);
		}
		
		//If the first randomly generated number was a 2, create a IShape block.
		if(shape == 2)
		{
			return new IShape(new Position(-2, mid), isMagic);
		}
		
		//If the first randomly generated number was a 3, create a OShape block.
		if(shape == 3)
		{
			return new OShape(new Position(-1, mid), isMagic);
		}
		
		//If the first randomly generated number was a 4, create a SZShape.
		if(shape == 4)
		{
			return new SZShape(new Position(-1, mid), isMagic);
		}
		
		//If the first randomly generated number was a 5, create a TShape.
		else
		{
			return new TShape(new Position(0, mid), isMagic);
		}
	}
}
