package strategy.chesspieces.weapon;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMorningStar {
	Weapon w;
	
	@Before
	public void initialize(){
		w = new MorningStar();
	}

	@Test
	public void testGetName() {
		assertEquals("Doesn't match", "MorningStar", w.getName());
	}

	@Test
	public void testGetDamage() {
		assertEquals("Doesn't match", 100, w.getDamage());
	}

}
