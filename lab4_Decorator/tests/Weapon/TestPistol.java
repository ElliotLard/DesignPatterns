package Weapon;

import static org.junit.Assert.*;
import Weapon.GenericWeapon;
import Weapon.Pistol;

import org.junit.Test;

public class TestPistol {
	
	/**
	 * Lab 4 tests for Pistol
	 * @author Christopher Wilson
	 */

	
	/**
	 * Tests the creation and border cases of Pistol
	 */
	@Test
	public void testInit()
	{
		
		GenericWeapon pistol = new Pistol();
		
		assertEquals(12, pistol.calculateDamage(0)); // Tests at point blank
		assertEquals(0, pistol.calculateDamage(40)); // Tests at too far
		assertEquals(6, pistol.calculateDamage(13)); // Tests at mid range
	}
	
	/**
	 * Test using Scope and Power Booster with a pistol
	 */
	@Test
	public void testPistolScopeAndPowerBooster()
	{
		GenericWeapon p = new Pistol(); // Create Pistol
		Attachment s = new Scope(p); // Create Scope
		Attachment pb = new PowerBooster(s); // Create Power Booster
		
		
		assertEquals(18, pb.calculateDamage(13));
	}
}

