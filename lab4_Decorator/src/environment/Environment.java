package environment;

import lifeform.LifeForm;

/**
 * 
 * @author elliotlard
 *
 *         A class for managing the gamespace
 */
public class Environment
{
	Cell[][] tileMap;

	/**
	 * Constructs the environment class creating the tileMap 2d array and
	 * filling it with empty cells.
	 * 
	 * @param height
	 * @param width
	 */
	public Environment(int height, int width)
	{
		tileMap = new Cell[height][width];
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				tileMap[y][x] = new Cell();
			}
		}
	}

	/**
	 * returns the lifeForm at the specified location.
	 * 
	 * @param y
	 * @param x
	 * @return
	 */
	public LifeForm getLifeForm(int y, int x)
	{
		return tileMap[y][x].getLifeForm();
	}

	/**
	 * Fills the specified cell with the given LifeForm
	 * 
	 * @param y
	 * @param x
	 * @param l
	 */
	public void addLifeForm(int y, int x, LifeForm l)
	{
		tileMap[y][x].addLifeForm(l);
	}

	/**
	 * returns the given cell to it's default state.
	 * 
	 * @param y
	 * @param x
	 */
	public void removeLifeForm(int y, int x)
	{
		tileMap[y][x].removeLifeForm();
	}

}
