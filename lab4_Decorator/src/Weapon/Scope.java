package Weapon;

public class Scope extends Attachment {

	public Scope(GenericWeapon w) {
		super(w);
	}

	public int calculateDamage(int distance) {
		return base.calculateDamage(distance) * (1 + ((10 + base.getRange()) - distance) / (10 + base.getRange()));
	}
}
