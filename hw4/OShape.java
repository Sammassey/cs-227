package hw4;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;
/**
 * @author
 * Sam Massey
 */
public class OShape extends AbstractShape
{
	/**
	 * constructs a OShape with the given requirements.
	 * @param givenPosition
	 * the given position of the shape.
	 * @param magic
	 * States whether or not the shape has a magic block.
	 */
	public OShape(Position givenPosition, boolean magic)
	{
		super(givenPosition,4);
		
		Cell[] temp = new Cell[4];
		
		//Sets the first cell to the originally given position.
		temp[0] = new Cell(new Block(Color.YELLOW, magic), givenPosition);
		
		//Sets the sdecond cell to the new position.
		Position position1 = new Position(givenPosition.row(), givenPosition.col() + 1);
		temp[1] = new Cell(new Block(Color.YELLOW, false), position1);
		
		//Sets the third cell to the new position.
		Position position2 = new Position(givenPosition.row() + 1, givenPosition.col());
		temp[2] = new Cell(new Block(Color.YELLOW, false), position2);
		
		//Sets the fourth cell to the new position.
		Position position3 = new Position(givenPosition.row() + 1, givenPosition.col() + 1);
		temp[3] = new Cell(new Block(Color.YELLOW, false), position3);
		
		this.setCells(temp);
	}
}
