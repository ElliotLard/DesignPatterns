package lifeform;

/**
 * tests the LifeForm class
 */
import static org.junit.Assert.*;

import org.junit.Test;

import Weapon.ChainGun;
import Weapon.GenericWeapon;
import environment.Range;

public class TestLifeForm {
	
	/**
	 * LAB4 TESTS
	 * author Elliot Lard
	 */
	@Test
	public void testWeaponHandling() {
		MockLifeForm entity;
		entity = new MockLifeForm("Bob", 40);
		GenericWeapon gun = new ChainGun();
		GenericWeapon gun2 = new ChainGun();

		entity.pickup(gun);
		assertEquals(gun, entity.getWeapon()); // successfully picked up the gun
		entity.pickup(gun2);
		assertEquals(gun, entity.getWeapon()); // can't pickup another gun
		
		entity.attack(new MockLifeForm("Fred", 40), 10);
		assertEquals(gun.getMaxAmmo()-1, gun.getAmmo()); // one fewer ammo
		entity.reload();
		assertEquals(gun.getMaxAmmo(), gun.getAmmo()); // now has full ammo after reloading
		entity.dropGun();
		assertEquals(null, entity.getWeapon()); // dropped gun
	}

	@Test
	public void testAttackHandling() {

		MockLifeForm entity;
		entity = new MockLifeForm("Bob", 40);
		MockLifeForm victim = new MockLifeForm("Fred", 40);
		GenericWeapon gun = new ChainGun();
		int range1Damage = gun.calculateDamage(Range.distance1);
		entity.pickup(gun);

		entity.attack(victim, Range.distance1);

		// correctly took damage from the gun.
		assertEquals(victim.getMaxLifePoints() - range1Damage, victim.getLifePoints());
		for (int x = 0; x < 39; x++) {
			entity.attack(victim, Range.distance2);
		}

		// has same amount of health as before because victim was out of range
		// ammo should now be at 0
		assertEquals(victim.getMaxLifePoints() - range1Damage, victim.getLifePoints());

		entity.attack(victim, Range.distance3);
		
		// same life as before because ammo is empty and range is too far for a
		// basic attack
		assertEquals(victim.getMaxLifePoints() - range1Damage, victim.getLifePoints());
		entity.attack(victim, Range.distance1);
		
		// health is now reduced by the attackStrength of entity because ammo
		// was out of ammo but was within basic attack range
		assertEquals(victim.getMaxLifePoints() - (range1Damage + entity.getAttackStrength()), victim.getLifePoints());
	}

	/**
	 * LAB1 TESTS
	 * 
	 */

	/**
	 * When a LifeForm is created, it should know its name and how many life
	 * points it has.
	 */
	@Test
	public void testInitialization()// constructor works properly
	{
		MockLifeForm entity;
		entity = new MockLifeForm("Bob", 40);
		assertEquals("Bob", entity.getName());
		assertEquals(40, entity.getLifePoints());
	}

	@Test
	public void testTakeHit()// takes damage properly
	{
		MockLifeForm entity;
		entity = new MockLifeForm("Bob", 40);
		entity.takeHit(20);
		assertEquals(20, entity.getLifePoints());
	}

	/**
	 * LAB3 TESTS
	 */

	@Test
	public void testSetAndGetAttackStrength() {
		MockLifeForm entity;
		entity = new MockLifeForm("Bob", 40, 20);
		assertEquals(20, entity.getAttackStrength()); // getAttackStrength works
		entity.setAttackStrength(10);
		assertEquals(10, entity.getAttackStrength()); // setAttackStrength works
														// properly
	}

	@Test
	public void testAttack() // tests the attack method
	{
		MockLifeForm bob, fred;
		bob = new MockLifeForm("Bob", 40, 20);
		fred = new MockLifeForm("Fred", 40, 20);
		bob.attack(fred);
		bob.attack(fred);
		assertEquals(0, fred.getLifePoints());// fred was attacked twice for 20
												// each
		fred.attack(bob);
		assertEquals(40, bob.getLifePoints());// fred should deal no damage
												// because his health is at 0
	}
}
