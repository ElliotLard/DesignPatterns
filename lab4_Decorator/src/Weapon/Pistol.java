package Weapon;

public class Pistol extends GenericWeapon
{
	private static final int BASEDAMAGE=10, RANGE=25, RATEOFFIRE=2, MAXAMMO=10;
	public Pistol()
	{
		super(BASEDAMAGE, RANGE, RATEOFFIRE, MAXAMMO);
	}
	
	public int calculateDamage(int distance)
	{
		int damage;

		if (distance > RANGE)
		{
			damage = 0;
			return damage;
		}
		else
		{
			double tempCalc = (RANGE - distance + 5);
			double tempCalcNext = tempCalc/RANGE;
			damage = (int) (baseDamage * tempCalcNext);
			return damage;
		}
	}
}
