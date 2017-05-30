package strategy.chesspieces.character;

import strategy.chesspieces.weapon.Weapon;

public interface Character {
	
	public void fight(Character ch);
	
	public void setWeapon(Weapon w);

	public String getName();

	public void takeDamage(int i);
	
	public int getHealth();
	
	public Weapon getWeapon();
}
