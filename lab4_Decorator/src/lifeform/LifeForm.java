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
public abstract class LifeForm implements TimeObserver {
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
	public LifeForm(String name, int points, int ad) {
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
	public String getName() {
		return myName;
	}

	/**
	 * returns the attackStrength of the LifeForm
	 * 
	 * @return
	 */
	public int getLifePoints() {
		return currentLP;
	}

	/**
	 * returns the maxlifePoints of the LifeForm
	 * 
	 * @return
	 */
	public int getMaxLifePoints() {
		return maxLP;
	}

	/**
	 * returns the attackStrength of the LifeForm
	 * 
	 * @return
	 */
	public int getAttackStrength() {
		return attackStrength;
	}

	/**
	 * removes "damage" from the current life points.
	 * 
	 * @param damage
	 */
	public void takeHit(int damage) {
		currentLP -= damage;
		if (currentLP < 0) {
			currentLP = 0;
		}
	}

	/**
	 * attacks the lifeForm using attackStrength
	 * 
	 * @param lifeForm
	 *            to be attacked
	 */
	public void attack(LifeForm victim) {
		if (currentLP > 0)
			victim.takeHit(attackStrength);
	}

	/**
	 * Attempts to attack another LifeForm, first by using the equipped weapon
	 * which expends ammo, or by using it's basic attack if out of ammo and in
	 * range.
	 * 
	 * @param victim
	 *            the LifeForm to be attacked
	 * @param distance
	 *            the distance to be passed into calculate distance
	 */
	public void attack(LifeForm victim, int distance) {
		if (currentLP == 0)
			return;

		if (!(weapon.equals(null)) && weapon.getAmmo() > 0) {
			victim.takeHit(weapon.shoot(distance));
		} else if (distance <= 5)
			victim.takeHit(attackStrength);
	}

	/**
	 * makes gun the equipped weapon if none is equipped
	 * 
	 * @param gun
	 * 		weapon to be equipped
	 */
	public void pickup(GenericWeapon gun) {
		if (weapon == null)
			weapon = gun;
	}
	
	/**
	 * returns the current weapon equipped;
	 * 
	 * @return weapon
	 */
	public GenericWeapon getWeapon() {
		return weapon;
	}

	/**
	 * drops the current weapon, making the value null;
	 */
	public void dropGun() {
		weapon = null;
	}

	/**
	 * calls the weapons reload() method.
	 */
	public void reload() {
		weapon.reload();
	}

}
