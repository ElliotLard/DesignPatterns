package Weapon;

public class PlasmaCannon extends GenericWeapon
{
	public PlasmaCannon(int d, int r, int rof, int a)
	{
		super(50, 20, 1, 4);
	}

	public int calculateDamage(int d)
	{
		return baseDamage * ((ammo + 1) / maxAmmo);
	}
}
