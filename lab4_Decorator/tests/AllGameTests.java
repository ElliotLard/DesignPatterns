
/**
 * Test suite for all of the game tests
 */
import org.junit.runner.RunWith;

import org.junit.runners.Suite;

import Weapon.TestChainGun;
import Weapon.TestStabilizer;
import Weapon.TestWeapon;
import environment.TestCell;
import environment.TestEnvironment;
import gameplay.TestSimpleTimer;
import lifeform.TestLifeForm;
import lifeform.TestAlien;
import lifeform.TestHuman;
import recovery.TestRecoveryLinear;
import recovery.TestRecoveryNone;

/**
 * 
 * Runs all of the tests in the project.
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
{ TestLifeForm.class, TestCell.class, TestEnvironment.class, TestHuman.class, TestRecoveryNone.class,
		TestRecoveryLinear.class, TestAlien.class, TestSimpleTimer.class, TestChainGun.class, TestStabilizer.class, TestWeapon.class})

public class AllGameTests
{

}
