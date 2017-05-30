package strategy.chesspieces.character;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import strategy.chesspieces.character.King;
import strategy.chesspieces.character.Knight;
import strategy.chesspieces.weapon.MorningStar;
import strategy.chesspieces.weapon.Sword;
import strategy.chesspieces.weapon.Weapon;

public class TestKing {
	King k;
	
	@Before
	public void initialize(){
		k = new King();
	}

	@Test
	public void testQueen() {
		assertNotNull("Should not return null", k);
	}

	@Test
	public void testGetName() {
		assertEquals("Doesn't match", "King", k.getName());
	}

	@Test
	public void testFight() {
		int initialknighthealth = 500;
		int initialkinghealth = k.getHealth();
		Knight knight = new Knight(initialknighthealth, new MorningStar());
		//Attack knight.
		k.fight(knight);	
		
		int knighthealth =  initialknighthealth - k.getWeapon().getDamage();
		assertEquals("Expected knight to take damage from weapon.", knighthealth, knight.getHealth());
		
		//Attack self.
		k.fight(k);
		assertEquals("Expected king to fail to take damage from own weapon.", 
				initialkinghealth,  k.getHealth());
		
		k.takeDamage(Integer.MAX_VALUE);
		k.fight(knight);
		
		//Attack when dead. Expect to fail.
		assertEquals("Expected attack to fail when dead", knight.getHealth(), knighthealth );
	}

	@Test
	public void testTakeDamage() {
		int initialhealth = k.getHealth();
		
		k.takeDamage(1);
		initialhealth--;
		
		assertEquals("Failed take correct damage.", initialhealth, k.getHealth());
		
		k.takeDamage(initialhealth);
		assertFalse("Failed to die.", k.checkIfAlive());
	}

	@Test
	public void testSetWeapon() {
		Weapon morningstar = new MorningStar(), sword = new Sword();
		
		assertNotEquals("Failed to have default weapon.", sword.getName(), k.getWeapon());
		
		k.setWeapon(morningstar);
		
		assertEquals("King was capable of switching weapons.", sword.getName(), k.getWeapon().getName());
	}

	@Test
	public void testGetHealth() {
		assertEquals("Failed to set default health.",500, k.getHealth());
	}

	@Test
	public void testGetWeapon() {
		assertEquals("Default weapon doesn't match.", "Sword", k.getWeapon().getName());
	}

}
