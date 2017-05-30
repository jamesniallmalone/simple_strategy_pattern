package strategy.chesspieces.character;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import strategy.chesspieces.character.Knight;
import strategy.chesspieces.character.Queen;
import strategy.chesspieces.weapon.MorningStar;
import strategy.chesspieces.weapon.Sword;
import strategy.chesspieces.weapon.Weapon;

public class TestQueen {
	Queen q;
	
	@Before
	public void initialize(){
		q = new Queen();
	}

	@Test
	public void testQueen() {
		assertNotNull("Should not return null", q);
	}

	@Test
	public void testGetName() {
		assertEquals("Doesn't match", "Queen", q.getName());
	}

	@Test
	public void testFight() {
		int initialknighthealth = 500;
		int initialqueenhealth = q.getHealth();
		Knight k = new Knight(initialknighthealth, new MorningStar());
		//Attack knight.
		q.fight(k);	
		
		int knighthealth =  initialknighthealth - q.getWeapon().getDamage();
		assertEquals("Expected knight to take damage from weapon.", knighthealth, k.getHealth());
		
		//Attack self.
		q.fight(q);
		assertEquals("Expected queen to take damage from her own weapon.", initialqueenhealth - q.getWeapon().getDamage(),  q.getHealth());
		
		q.takeDamage(Integer.MAX_VALUE);
		q.fight(k);
		
		//Attack when dead. Expect to fail.
		assertEquals("Expected attack to fail when dead", k.getHealth(), knighthealth );
	}

	@Test
	public void testTakeDamage() {
		int initialhealth = q.getHealth();
		
		q.takeDamage(1);
		initialhealth--;
		
		assertEquals("Failed take correct damage.", initialhealth, q.getHealth());
		
		q.takeDamage(initialhealth);
		assertFalse("Failed to die.", q.checkIfAlive());
	}

	@Test
	public void testSetWeapon() {
		Weapon sword = new Sword();
		
		assertNotEquals("Failed to set weapon.", sword.getName(), q.getWeapon());
		
		q.setWeapon(sword);
		
		assertEquals("Failed to set weapon.", sword.getName(), q.getWeapon().getName());
	}

	@Test
	public void testGetHealth() {
		assertEquals("Failed to set weapon.",200, q.getHealth());
	}

	@Test
	public void testGetWeapon() {
		assertEquals("Default weapon doesn't match.", "MorningStar", q.getWeapon().getName());
	}

}
