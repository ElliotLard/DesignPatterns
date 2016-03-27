// Author: Aaron Gerber

package Weapon;

public class PlasmaCannon extends GenericWeapon
{
	public PlasmaCannon()
	{
		//Inputs the base values of a plasma cannon
		super(50, 20, 1, 4);
	}

	public int calculateDamage(int d)
	{
		//Plasma cannon is more powerful the more ammo it has left
		return baseDamage * ((ammo + 1) / maxAmmo);
	}
}
