package lifeform;

import Weapon.GenericWeapon;
import environment.Range;
import gameplay.TimeObserver;

/**
 * 
 * @author elliotlard
 * 
 *         Holds the name and current health of a lifeForm
 */
public abstract class LifeForm implements TimeObserver
{
	String myName;
	int currentLP;
	int maxLP;
	int attackStrength;
	GenericWeapon weapon;

	/**
	 * constructs a LifeForm with a given name and health.
	 * 
	 * @param name
	 * @param points
	 */
	public LifeForm(String name, int points, int ad)
	{
		myName = name;
		maxLP = points;
		currentLP = maxLP;
		attackStrength = ad;
	}

	/**
	 * returns the name of the LifeForm.
	 * 
	 * @return
	 */
	public String getName()
	{
		return myName;
	}

	/**
	 * returns the attackStrength of the LifeForm
	 * 
	 * @return
	 */
	public int getLifePoints()
	{
		return currentLP;
	}
	
	/**
	 * returns the maxlifePoints of the LifeForm
	 * 
	 * @return
	 */
	public int getMaxLifePoints()
	{
		return maxLP;
	}
	
	/**
	 * returns the attackStrength of the LifeForm
	 * 
	 * @return
	 */
	public int getAttackStrength()
	{
		return attackStrength;
	}


	/**
	 * removes "damage" from the current life points.
	 * 
	 * @param damage
	 */
	public void takeHit(int damage)
	{
		currentLP -= damage;
		if (currentLP < 0)
		{
			currentLP = 0;
		}
	}
	
	/**
	 * attacks the lifeForm using attackStrength
	 * 
	 * @param lifeForm to be attacked
	 */
	public void attack(LifeForm victim)
	{
		if(currentLP > 0)
		victim.takeHit(attackStrength);
	}
	public void attack(LifeForm victim, int distance)
	{
		if(currentLP == 0)
			return;
		
		if(!(weapon.equals(null)) && weapon.getAmmo()>0)
		{
			victim.takeHit(weapon.shoot(distance));
		}
		else if(distance <= 5)
			victim.takeHit(attackStrength);
	}
	public void pickup(GenericWeapon gun) {
		if(weapon==null)
			weapon = gun;
	}
	public GenericWeapon getWeapon() {
		return weapon;
	}
	public void dropGun() {
		weapon = null;
	}

}
