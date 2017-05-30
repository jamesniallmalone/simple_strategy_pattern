package strategy.chesspieces.character;

import strategy.chesspieces.weapon.Weapon;

public class Knight extends AbstractCharacter{


	public Knight(int h, Weapon dw) {
		super(h, dw);
	}

	@Override
	public String getName() {
		return "Knight";
	}

}
