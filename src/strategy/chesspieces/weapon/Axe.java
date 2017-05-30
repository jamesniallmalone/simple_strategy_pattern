package strategy.chesspieces.weapon;

public class Axe implements Weapon {

	@Override
	public int getDamage() {
		return 80;
	}

	@Override
	public String getName() {
		return "Axe";
	}

}
