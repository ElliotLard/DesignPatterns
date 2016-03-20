package Weapon;

public class Scope extends Attachment{

	public Scope(GenericWeapon w) {
		super(w);
	}
	
	/**
	 * Calculates the damage done only by the scope and returns as an int.
	 * All values typecast to double so no accidental rounding occurs.
	 * Final result is then typecast as an int.
	 */
	public int calculateDamage(int distance)
	{
		return (int) ((double)(base.calculateDamage(distance) * ((double)(1 +(base.range + 10) - distance)/(base.range + 10))));
	}

}
