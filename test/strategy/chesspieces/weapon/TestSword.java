package strategy.chesspieces.weapon;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSword {
	Weapon w;
	
	@Before
	public void initialize(){
		w = new Sword();
	}

	@Test
	public void testGetName() {
		assertEquals("Doesn't match", "Sword", w.getName());
	}

	@Test
	public void testGetDamage() {
		assertEquals("Doesn't match", 50, w.getDamage());
	}

}
