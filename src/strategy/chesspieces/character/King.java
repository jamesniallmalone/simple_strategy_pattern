package strategy.chesspieces.character;

import strategy.chesspieces.weapon.Sword;
import strategy.chesspieces.weapon.Weapon;

public class King extends AbstractCharacter
{

	public King() {
		super(500, new Sword());
	}

	@Override
	public String getName() {
		return "King";
	}
	
	@Override
	public void setWeapon(Weapon w){
		System.out.println("Cannot change king weapon.");
	}
	
	@Override
	public void fight(Character ch) {
		if(ch.getName() == getName()){
			System.out.println("King cannot attack king.");
			return;
		}
		
		super.fight(ch);
	}
	
}
