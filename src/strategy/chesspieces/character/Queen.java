package strategy.chesspieces.character;

import strategy.chesspieces.weapon.MorningStar;

public class Queen extends AbstractCharacter {

	public Queen() {
		super(200, new MorningStar());
	}

	@Override
	public String getName() {
		return "Queen";
	}


}
