
package hw4;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;
import api.Shape;

/**
 * Abstract superclass for implementations of the Shape interface.
 */
public abstract class AbstractShape implements Shape
{ 
	/**
	 * holds a new cell with the given length.
	 */
	private Cell[] cells;
	
	/**
	 * A variable to hold the position of the shape.
	 */
	private Position position;
	
	
	/**
	 * Constructs a shape with a given position and length.
	 * @param givenPosition
	 * given position for a shape.
	 * @param length
	 * given length of the shape.
	 */
	protected AbstractShape(Position givenPosition, int length)
	{
		position = givenPosition;
		cells = new Cell[length];
	}
	
	/**
	 * sets the position variable to a new position.
	 * @param newPosition
	 * the new position to be set.
	 */
	protected void setPosition(Position newPosition)
	{
		position = newPosition;
	}
	
	/**
	 * returns the position of the current shape.
	 * @return
	 * the current position.
	 */
	protected Position getPosition()
	{
		return position;
	}
	
	/**
	 * Returns a new array of Cell objects representing the blocks in this shape along  with their absolute positions.
	 * (Note that modifications to the array or Cell objects returned by this method should NOT affect this shape.)
	 */
	public Cell[] getCells()
	{
		int cellLength = cells.length;
		Cell[] copy = new Cell[cellLength];
		for(int i = 0; i < cellLength; i++)
		{
			copy[i] = new Cell(cells[i]);
		}
		return copy;
	}
	
	/**
	 * sets a new cell to be the cell variable.
	 * @param newCells
	 * the new cell to be set.
	 */
	protected void setCells(Cell[] newCells)
	{
		cells = newCells;
	}
	
	/**
	 * Shifts the position of this shape down (increasing the row) by one. No bounds checking is done.
	 */
	public void shiftDown()
	{
		position.setRow(position.row() + 1);
		int cellLength = cells.length;
		for(int i = 0; i < cellLength; i++)
		{
			cells[i].setRow(cells[i].getRow() + 1);
		}
	}
	
	/**
	 * Shifts the position of this shape left (decreasing the column) by one. No bounds checking is done.
	 */
	public void shiftLeft()
	{
		position.setRow(position.col() - 1);
		int cellLength = cells.length;
		for(int i = 0; i < cellLength; i++)
		{
			cells[i].setCol(cells[i].getCol() - 1);
		}
	}
	
	/**
	 * Shifts the position of this shape right (increasing the column) by one. No bounds checking is done.
	 */
	public void shiftRight()
	{
		position.setRow(position.col() + 1);
		int cellLength = cells.length;
		for(int i = 0; i < cellLength; i++)
		{
			cells[i].setCol(cells[i].getCol() + 1);
		}
	}
	
	public void transform()
	{
		//checks if the block is a SZShape
		if(cells[0].getBlock().getColorHint() == Color.RED || cells[0].getBlock().getColorHint() == Color.GREEN)
		{
			//If the block is an SZShape and is green run this.
			if(cells[0].getBlock().getColorHint() == Color.GREEN)
			{
				cells[0] = new Cell(new Block(Color.RED, cells[0].getBlock().isMagic()), new Position(cells[0].getRow(), cells[0].getCol() + 1));
				cells[1] = new Cell(new Block(Color.RED, cells[1].getBlock().isMagic()), new Position(cells[1].getRow(), cells[0].getCol()));
				cells[2] = new Cell(new Block(Color.RED, cells[2].getBlock().isMagic()), new Position(cells[2].getRow(), cells[0].getCol() - 1));
				cells[3] = new Cell(new Block(Color.RED, cells[3].getBlock().isMagic()), new Position(cells[3].getRow(), cells[0].getCol() - 1));
			}
			//Else if the block is red run this.
			else
			{
				cells[0] = new Cell(new Block(Color.GREEN, cells[0].getBlock().isMagic()), new Position(cells[0].getRow(), cells[0].getCol() - 1));
				cells[1] = new Cell(new Block(Color.GREEN, cells[1].getBlock().isMagic()), new Position(cells[1].getRow(), cells[1].getCol() - 1));
				cells[2] = new Cell(new Block(Color.GREEN, cells[2].getBlock().isMagic()), new Position(cells[2].getRow(), cells[2].getCol() + 1));
				cells[3] = new Cell(new Block(Color.GREEN, cells[3].getBlock().isMagic()), new Position(cells[3].getRow(), cells[3].getCol() + 1));
			}
		}
		//If the block is an OShape no transformation is needed.
		else if(cells[0].getBlock().getColorHint() == Color.YELLOW) {}
		//If it is any other shape use the special rule to turn it ccw.
		else
		{
			for(int i = 0; i < cells.length; i++)
			{
				int currentRow = cells[i].getRow() - position.row();
				int currentCol = cells[i].getCol() - position.col();
				cells[i].setRow(-currentCol + position.row());
				cells[i].setCol(currentRow + position.col()); 
			}
		}
	}
	
	/**
	 * Cycles the blocks within the cells of this shape. Each block is shifted forward to the next cell (in the original ordering of the cells). The last block wraps around to the first cell.
	 */
	public void cycle()
	{
		Block nonMagicBlock = new Block(cells[0].getBlock().getColorHint(), false);
		for(int i = 0; i < cells.length; i++)
		{
			if(i == cells.length - 1)
			{
				if(cells[i].getBlock().isMagic())
				{
					cells[0].setBlock(cells[i].getBlock());
					cells[i].setBlock(nonMagicBlock);
				}
			}
			if(cells[i].getBlock().isMagic())
			{
				cells[i + 1].setBlock(cells[i].getBlock());
				cells[i].setBlock(nonMagicBlock);
				break;
			}
		}
	}

	/**
	 * Returns a deep copy of this object having the correct runtime type.
	 */
	@Override
	public Shape clone()
	{
		try
		{
			AbstractShape s = (AbstractShape) super.clone();

			s.position = new Position(this.getPosition());
			s.cells = new Cell[cells.length];
			for(int i = 0; i < this.getCells().length; i++)
			{
				s.cells[i] = new Cell(cells[i]);
			}

			return s;
		}
		catch (CloneNotSupportedException e)
		{
			// can't happen
			return null;
		}
	}
}
