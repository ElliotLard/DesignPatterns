package Weapon;

import gameplay.TimeObserver;

public abstract class GenericWeapon implements TimeObserver {
	int baseDamage, range, rateOfFire, ammo, maxAmmo, shotsRemaining;

	public GenericWeapon(int d, int r, int rof, int a) {
		baseDamage = d;
		range = r;
		rateOfFire = rof;
		ammo = a;
		maxAmmo = a;
	}

	public int calculateDamage(int d) {
		return baseDamage;
	}

	public int shoot(int d) {
		if(ammo > 0)
		{
			ammo--;
			shotsRemaining--;
			if(range >= d)
			{
				return calculateDamage(d);
			}
		}
		return 0;
	}

	public void reload() {
		ammo = maxAmmo;
	}

	public void updateTime(int time) {
		shotsRemaining = rateOfFire;
	}

	public int getBaseDamage() {
		return baseDamage;
	}

	public int getRange() {
		return range;
	}

	public int getRateOfFire() {
		return rateOfFire;
	}

	public int getAmmo() {
		return ammo;
	}

	public int getMaxAmmo() {
		return maxAmmo;
	}

}
