package strategy.chesspieces.character;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import strategy.chesspieces.character.Knight;
import strategy.chesspieces.weapon.MorningStar;
import strategy.chesspieces.weapon.Sword;
import strategy.chesspieces.weapon.Weapon;

public class TestKnight {
	Knight knight;
	
	@Before
	public void initialize(){
		knight = new Knight(150, new Sword());
	}

	@Test
	public void testQueen() {
		assertNotNull("Should not return null", knight);
	}

	@Test
	public void testGetName() {
		assertEquals("Doesn't match", "Knight", knight.getName());
	}

	@Test
	public void testFight() {
		int initialknighthealth = 500;
		int initialqueenhealth = knight.getHealth();
		Knight k = new Knight(initialknighthealth, new MorningStar());
		//Attack knight.
		knight.fight(k);	
		
		int knighthealth =  initialknighthealth - knight.getWeapon().getDamage();
		assertEquals("Expected knight to take damage from weapon.", knighthealth, k.getHealth());
		
		//Attack self.
		knight.fight(knight);
		assertEquals("Expected queen to take damage from her own weapon.", initialqueenhealth - knight.getWeapon().getDamage(),  knight.getHealth());
		
		knight.takeDamage(Integer.MAX_VALUE);
		knight.fight(k);
		
		//Attack when dead. Expect to fail.
		assertEquals("Expected attack to fail when dead", k.getHealth(), knighthealth );
	}

	@Test
	public void testTakeDamage() {
		int initialhealth = knight.getHealth();
		
		knight.takeDamage(1);
		initialhealth--;
		
		assertEquals("Failed take correct damage.", initialhealth, knight.getHealth());
		
		knight.takeDamage(initialhealth);
		assertFalse("Failed to die.", knight.checkIfAlive());
	}

	@Test
	public void testSetWeapon() {
		Weapon sword = new Sword();
		
		assertNotEquals("Failed to set weapon.", sword.getName(), knight.getWeapon());
		
		knight.setWeapon(sword);
		
		assertEquals("Failed to set weapon.", sword.getName(), knight.getWeapon().getName());
	}

	@Test
	public void testGetHealth() {
		assertEquals("Failed to set weapon.",150, knight.getHealth());
	}

	@Test
	public void testGetWeapon() {
		assertEquals("Default weapon doesn't match.", "Sword", knight.getWeapon().getName());
	}

}
