package hw4;

import api.Cell;
import api.Position;

import java.awt.Color;

import api.Block;
/**
 * @author
 *Sam Massey
 */
public class SZShape extends AbstractShape
{
	/**
	 * constructs a SZShape with the given requirements. 
	 * @param givenPosition
	 * The given position of the shape.
	 * @param magic
	 * States whether or not the shape has a magic block.
	 */
	public SZShape(Position givenPosition, boolean magic)
	{
		super(givenPosition, 4);
		
		Cell[] temp = new Cell[4];
		
		//Sets the first cell to the originally given position.
		temp[0] = new Cell(new Block(Color.GREEN, magic), givenPosition);
		
		//Sets the second cell to the next position.
		Position position1 = new Position(givenPosition.row() + 1, givenPosition.col());
		temp[1] = new Cell(new Block(Color.GREEN, false), position1);
		
		//Sets the third cell to the next position.
		Position position2 = new Position(givenPosition.row() + 1, givenPosition.col() + 1);
		temp[2] = new Cell(new Block(Color.GREEN, false), position2);
		
		//Sets the fourth cell to the next position.
		Position position3 = new Position(givenPosition.row() + 2, givenPosition.col() + 1);
		temp[3] = new Cell(new Block(Color.GREEN, false), position3);
		
		this.setCells(temp);
	}
}
