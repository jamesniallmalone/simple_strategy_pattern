package strategy.chesspieces.character;

import strategy.chesspieces.weapon.Weapon;

public abstract class AbstractCharacter implements Character {
	
	private int health;
	private Weapon weapon;
	
	public AbstractCharacter(int h, Weapon dw)
	{
		health = h;
		weapon = dw;
	}

	@Override
	public void fight(Character ch) {
		if(!checkIfAlive()) {
			System.out.println(getName() + " is dead. Cannot attack " + ch.getName());
			return;
		}
		
		System.out.println("Attacking " + ch.getName() + " with " + weapon.getName());
		
		ch.takeDamage(weapon.getDamage());
		
	}
	
	@Override
	public void takeDamage(int damage) {
		health -= damage;			
	}
	
	public boolean checkIfAlive() {
		return (health > 0);
	}

	@Override
	public void setWeapon(Weapon w) {
		System.out.println(getName() + ". Replacing " + weapon.getName() + " with " + w.getName());
		this.weapon = w;
	}
	
	@Override
	public int getHealth() {
		return health;
	}
	
	@Override
	public Weapon getWeapon() {
		return this.weapon;
	}

}
