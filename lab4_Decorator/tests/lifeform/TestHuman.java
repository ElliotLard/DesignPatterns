package lifeform;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestHuman
{
	/**
	 * LAB2 TESTS
	 */
	@Test
	public void testConstruction()// constructs with name, hp, and armor
	{
		Human bob = new Human("Bob", 40, 5);
		assertEquals(bob.getName(), "Bob");
		assertEquals(bob.getLifePoints(), 40);
		assertEquals(bob.getArmor(), 5);
		Human fred = new Human("Fred", 40, -5);
		assertEquals(fred.getArmor(), 0);
	}

	@Test
	public void testArmor()// tests set and get armor
	{
		Human bob = new Human("Bob", 40, 5);
		assertEquals(bob.getArmor(), 5);
		bob.setArmor(10);
		assertEquals(bob.getArmor(), 10);
		bob.setArmor(-5);
		assertEquals(bob.getArmor(), 0);// armor cannot be < 0
	}

	/**
	 * LAB3 TESTS
	 */
	@Test
	public void testHumanAttacks()// humans with no armor take attack and take
									// damage
	{
		Human bob = new Human("Bob", 40);
		Human fred = new Human("Fred", 40);
		assertEquals(bob.getAttackStrength(), 5);
		bob.attack(fred);
		assertEquals(fred.getLifePoints(), 35);
	}

	@Test
	public void testArmorAbsorbs()// humans with armor take reduced damage
	{
		Human bob = new Human("Bob", 40, 3);
		Human fred = new Human("Fred", 40, 10);
		Human george = new Human("George", 40, 10, 10);
		fred.attack(bob);
		assertEquals(bob.getLifePoints(), 38); // damage is reduced by 3 from
												// armor
		bob.attack(fred);
		assertEquals(fred.getLifePoints(), 40); // takes no damage because the
												// armor is greater than the
												// attack
		george.attack(fred);
		assertEquals(fred.getLifePoints(), 40); // fred takes no damage because
												// george's attack damage and
												// fred's armor are equal

	}

}
