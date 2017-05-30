package strategy.chesspieces.weapon;

public class Sword implements Weapon {

	@Override
	public int getDamage() {
		return 50;
	}

	@Override
	public String getName() {
		return "Sword";
	}

}
