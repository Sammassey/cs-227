package hw4;

import api.Cell;
import api.Position;

import java.awt.Color;

import api.Block;
/**
 * @author 
 * Sam Massey
 */
public class TShape extends AbstractShape
{
	/**
	 * constructs a TShape with the given requirements.
	 * @param givenPosition
	 * the given position of the shape.
	 * @param magic
	 * States whether or not the shape has a magic block.
	 */
	public TShape(Position givenPosition, boolean magic)
	{
		super(givenPosition, 4);
		
		Cell[] temp = new Cell[4];
		
		//Sets the first cell to the new position.
		Position position1 = new Position(givenPosition.row() - 1, givenPosition.col());
		temp[0] = new Cell(new Block(Color.MAGENTA, magic), position1);
		
		//Sets the second cell to the new position.
		Position position2 = new Position(givenPosition.row(), givenPosition.col() - 1);
		temp[1] = new Cell(new Block(Color.MAGENTA, false), position2);
		
		//Sets the third cell to the originally given position.
		temp[2] = new Cell(new Block(Color.MAGENTA, false), givenPosition);
		
		//Sets the fourth cell to the new position.
		Position position3 = new Position(givenPosition.row(), givenPosition.col() + 1);
		temp[3] = new Cell(new Block(Color.MAGENTA, false), position3);
		
		this.setCells(temp);
	}
}
