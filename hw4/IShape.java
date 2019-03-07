package hw4;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;
/**
 * @author 
 *Sam Massey
 */
public class IShape extends AbstractShape
{
	/**
	 * constructs a IShape with the given requirements.
	 * @param givenPosition
	 * the given position of the shape.
	 * @param magic
	 * States whether or not the shape has a magic block.
	 */
	public IShape(Position givenPosition, boolean magic)
	{
		super(givenPosition, 3);
		
		Cell[] temp = new Cell[3];
		
		//Sets the first block to the originally given position.
		temp[0] = new Cell(new Block(Color.CYAN, magic), givenPosition);
		
		//Sets the second block to the new position.
		Position position1 = new Position(givenPosition.row() + 1, givenPosition.col());
		temp[1] = new  Cell(new Block(Color.CYAN, false), position1);
		
		//Sets the third block to the new position.
		Position position2 = new Position(givenPosition.row() + 2, givenPosition.col());
		temp[2] = new Cell(new Block(Color.CYAN, false), position2);
		
		this.setCells(temp);
	}
}
