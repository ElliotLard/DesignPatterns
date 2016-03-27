package Weapon;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStabilizer
{

	/**
	 * LAB4 TESTS author Elliot Lard
	 */
	
	//tests the stabilizer + chaingun does proper damage
	@Test
	public void testStabilizerWithChaingun()
	{
		GenericWeapon c = new ChainGun();
		Attachment s = new Stabilizer(c);

		assertEquals(18, s.calculateDamage(30));
	}

	//tests the stabilizer + stabilizer + chaingun does proper damage
	@Test
	public void testStabilizerWithStabilizerWithChaingun()
	{
		GenericWeapon c = new ChainGun();
		Attachment s1 = new Stabilizer(c);
		Attachment s2 = new Stabilizer(s1);

		assertEquals(22, s2.calculateDamage(30));
	}
	//tests the reload functionality of the stabilizer
	@Test
	public void testReload()
	{
		GenericWeapon c = new ChainGun();
		Attachment s1 = new Stabilizer(c);

		s1.shoot(10);

		assertEquals(s1.getMaxAmmo() - 1, s1.getAmmo());
		for (int x = 0; x < 39; x++)
		{
			s1.shoot(10);
		}
		assertEquals(s1.getMaxAmmo(), s1.getAmmo());

	}
	
	/**
	 * Another damage test using Scope and Stabilizer
	 * @author Christopher Wilson
	 */
	@Test
	public void testPistolScopeAndStabalizer()
	{
		GenericWeapon p = new Pistol(); // Create pistol
		Attachment s = new Scope(p); // Create Scope
		Attachment st = new Stabilizer(s); // Create Stabilizer
		
	
		assertEquals(11, st.calculateDamage(13));
	}

}
