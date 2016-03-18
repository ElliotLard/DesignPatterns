package Weapon;

public class Scope extends Attachment{

	public Scope(GenericWeapon w) {
		super(w);
	}
	
	public int calculateDamage(int distance)
	{
		return (int) ((double)base.calculateDamage(distance) * ((1 + (base.range + 10) - distance)/(base.range + 10)));
	}

}
