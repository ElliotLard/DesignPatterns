//Author: Aaron Gerber

package Weapon;

public class PowerBooster extends Attachment
{
	
	public PowerBooster(GenericWeapon w)
	{
		super(w);
	}

	public int calculateDamage(int distance) 
	{
		//Power booster increases weapon damage based on how much ammo is left
		double dam = (1+((double)base.getAmmo()/(double)base.getMaxAmmo()));
		return (int)(dam*base.calculateDamage(distance));
	}
}
