package environment;

import lifeform.LifeForm;

/**
 * 
 * @author elliotlard
 *
 */
public class Cell
{
	LifeForm areaMan = null;

	/**
	 * returns the LifeForm within the cell
	 * 
	 * @return
	 */
	public LifeForm getLifeForm()
	{
		return areaMan;
	}

	/**
	 * adds the lifeForm to the cell if it is empty and returns true if this is
	 * done succesfully.
	 * 
	 * @param entity
	 * @return
	 */
	public boolean addLifeForm(LifeForm entity)
	{
		if (areaMan == null)
		{
			areaMan = entity;
			return true;
		} else
			return false;
	}

	public void removeLifeForm()
	{
		areaMan = null;
	}
}
