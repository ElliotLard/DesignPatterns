package environment;

import lifeform.MockLifeForm;
/**
 * Tests for the Environment class.
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class TestEnvironment
{
	/**
	 * LAB1 TESTS
	 */

	/**
	 * tests the Environment constructor
	 */
	@Test
	public void testConstruction()
	{
		Environment smallWorld = new Environment(1, 1);
		assertTrue(smallWorld.getLifeForm(0, 0) == null);
	}

	@Test
	public void testHoldsLife()
	{
		Environment smallWorld = new Environment(3, 2);
		MockLifeForm bob = new MockLifeForm("Bob", 10);
		smallWorld.addLifeForm(1, 0, bob);
		assertTrue(smallWorld.getLifeForm(1, 0) == (bob));
	}

	@Test
	public void testRemoveLife()
	{
		Environment smallWorld = new Environment(3, 2);
		MockLifeForm bob = new MockLifeForm("Bob", 10);
		smallWorld.addLifeForm(1, 0, bob);
		assertTrue(smallWorld.getLifeForm(1, 0) == (bob));
		smallWorld.removeLifeForm(1, 0);
		assertTrue(smallWorld.getLifeForm(1, 0) == null);

	}

}
