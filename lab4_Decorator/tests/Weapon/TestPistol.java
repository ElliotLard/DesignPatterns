package Weapon;

import static org.junit.Assert.*;
import Weapon.GenericWeapon;
import Weapon.Pistol;

import org.junit.Test;

public class TestPistol {

	@Test
	public void testInit()
	{
		
		GenericWeapon pistol = new Pistol();
		
		assertEquals(12, pistol.calculateDamage(0)); // Tests at point blank
		assertEquals(0, pistol.calculateDamage(40)); // Tests at too far
		assertEquals(6, pistol.calculateDamage(13)); // Tests at mid range
	}
}

