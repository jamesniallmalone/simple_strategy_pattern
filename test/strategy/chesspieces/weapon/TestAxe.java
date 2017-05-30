package strategy.chesspieces.weapon;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestAxe {
	Weapon w;
	
	@Before
	public void initialize(){
		w = new Axe();
	}

	@Test
	public void testGetName() {
		assertEquals("Doesn't match", "Axe", w.getName());
	}

	@Test
	public void testGetDamage() {
		assertEquals("Doesn't match", 80, w.getDamage());
	}

}
