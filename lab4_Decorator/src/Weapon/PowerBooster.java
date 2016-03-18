//Author: Aaron Gerber

package Weapon;

public class PowerBooster extends Attachment
{
	
	public PowerBooster(GenericWeapon w)
	{
		super(w);
	}

	public int calculateDamage(int distance) {
		return (int)((1+((double)base.getAmmo()/(double)base.getMaxAmmo())) * base.calculateDamage(distance));
	}
}
