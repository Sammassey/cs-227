package hw4;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;

/**
 * @author
 *Sam Massey
 */
public class JShape extends AbstractShape
{
	/**
	 * Constructs a JShape with the given requirements.
	 * @param givenPosition
	 * The given position of the shape.
	 * @param magic
	 * States whether or not the shape has a magic block.
	 */
	public JShape(Position givenPosition, boolean magic)
	{
		super(givenPosition, 4);
		
		Cell[] temp = new Cell[4];
		
		//Sets the first cell at the new position.
		Position position1 = new Position(givenPosition.row(), givenPosition.col() - 1);
		temp[0] = new Cell(new Block(Color.BLUE, magic), position1);
		
		//Sets the second cell at the new position.
		Position position2 = new Position(givenPosition.row() + 1, givenPosition.col() -1);
		temp[1] = new Cell(new Block(Color.BLUE, false), position2);
		
		//Sets the third cell at the new position.
		Position position3 = new Position(givenPosition.row() + 1, givenPosition.col());
		temp[2] = new Cell(new Block(Color.BLUE, false), position3);
		
		//Sets the fourth cell at the new position.
		Position position4 = new Position(givenPosition.row() +1, givenPosition.col() + 1);
		temp[3] = new Cell(new Block(Color.BLUE, false), position4);
		
		this.setCells(temp);
	}
}
