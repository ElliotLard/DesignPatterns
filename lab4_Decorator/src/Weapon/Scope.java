package Weapon;

public class Scope extends Attachment{

	public Scope(GenericWeapon w) {
		super(w);
	}
	
	public int calculateDamage(int distance)
	{
		return (int) ((double)base.calculateDamage(distance) * ((double)(1 + (double)(base.range + 10) - distance)/(double)(base.range + 10)));
	}

}
