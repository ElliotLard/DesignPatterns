package Weapon;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestScope
{
	@Test
	public void testScopeWithPistol()
	{
		GenericWeapon p = new Pistol();
		Attachment s = new Scope(p);
		
		assertEquals(3, s.calculateDamage(13));
	}
}
