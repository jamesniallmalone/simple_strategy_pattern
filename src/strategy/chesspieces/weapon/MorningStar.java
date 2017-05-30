package strategy.chesspieces.weapon;

public class MorningStar implements Weapon {

	@Override
	public int getDamage() {
		return 100;
	}

	@Override
	public String getName() {
		return "MorningStar";
	}

}
