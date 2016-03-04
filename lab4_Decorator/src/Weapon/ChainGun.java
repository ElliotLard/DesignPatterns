package Weapon;

public class ChainGun extends GenericWeapon
{
	private static final int BASEDAMAGE=15, RANGE=30, RATEOFFIRE=4, MAXAMMO=40;
	public ChainGun()
	{
		super(BASEDAMAGE, RANGE, RATEOFFIRE, MAXAMMO);
	}
	
	public int calculateDamage(int distance)
	{
		int damage;
		if(distance > this.getRange())
			return 0;
		damage =  (int)((double)super.calculateDamage(distance)*((double)distance/(double)this.getRange()));
		return damage;
	}
}
