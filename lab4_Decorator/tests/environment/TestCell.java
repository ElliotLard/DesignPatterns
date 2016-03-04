package environment;

import lifeform.MockLifeForm;
/**
 * tests the Cell Class
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class TestCell
{
	/**
	 * LAB1 TESTS
	 */
	@Test
	public void testInitialization()
	{
		Cell cell = new Cell();
		assertNull(cell.getLifeForm());
	}

	@Test
	public void testSetLifeForm()
	{
		MockLifeForm bob = new MockLifeForm("Bob", 40);
		MockLifeForm fred = new MockLifeForm("Fred", 4);
		Cell cell = new Cell();
		boolean success = cell.addLifeForm(bob);
		assertTrue(success);
		assertEquals(bob, cell.getLifeForm());
		success = cell.addLifeForm(fred);
		assertFalse(success);
		assertEquals(bob, cell.getLifeForm());
	}

	@Test
	public void testRemoveLifeForm()
	{
		MockLifeForm bob = new MockLifeForm("Bob", 40);
		MockLifeForm fred = new MockLifeForm("Fred", 4);
		Cell cell = new Cell();
		cell.addLifeForm(bob);
		cell.removeLifeForm();
		cell.addLifeForm(fred);
		assertEquals(fred, cell.getLifeForm());
	}
}
