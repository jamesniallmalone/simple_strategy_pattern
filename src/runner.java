import strategy.chesspieces.character.King;
import strategy.chesspieces.character.Knight;
import strategy.chesspieces.character.Queen;
import strategy.chesspieces.weapon.Axe;
import strategy.chesspieces.weapon.MorningStar;
import strategy.chesspieces.weapon.Sword;

public class runner {

	public static void main(String[] args){
		// set up the board.
		King king_a = new King(), king_b= new King();
		Queen queen_a = new Queen(), queen_b= new Queen();
		Knight knight_a1 = new Knight(100,  new Axe()),
				knight_a2 = new Knight(100,  new Sword()),
				knight_a3 = new Knight(100,  new MorningStar()),
				knight_b1 = new Knight(200,  new MorningStar()),
				knight_b2 = new Knight(200,  new Axe()),
				knight_b3 = new Knight(200,  new Sword());
		
		
		//Start the brawl.
		knight_a1.fight(knight_b3);
		
		queen_b.fight(king_a);
		king_a.fight(queen_b);
		
		knight_a1.fight(knight_b3);
		
		queen_a.fight(queen_a);
		
		//someone betrays the king.
		knight_b2.fight(king_b);
		king_a.fight(king_b);
		
		knight_a2.setWeapon(new MorningStar());
		knight_a2.fight(knight_b1);
		
		//knight a3 kills himself.
		knight_a3.fight(knight_a3);
		
		
		
		
	}
}
