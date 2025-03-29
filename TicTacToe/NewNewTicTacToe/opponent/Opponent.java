package opponent;
import player.Player;

/**
 * OPPONENT CLASS
 * robot opponent
 * 
 * <p> Might make a new opponent super class with these methods and
 * let the player choose the difficulty of the bot <p>
 * @author Keola Teson :)
 */
public abstract class Opponent
{
	//Player (to access player methods and board duhhhhhhhh)
	protected Player player;
	
	/**
	 * CONSTRUCTOR
	 * @param player
	 */
	public Opponent(Player player)
	{
		this.player = player;
	}
	
	/**
	 * chooses the position of the O based on stuff
	 */
	public abstract void chooseBox();
	
	/**
	 * CHECK ONE
	 * checks the row to see if the player is close to winning
	 * @return true if the an O was placed
	 */
	protected abstract boolean checkRows();
	
	/**
	 * CHECK TWO
	 * checks the columns to see if the player is close to winning
	 * @param posY
	 * @param posX
	 * @return true if an O was placed
	 */
	protected abstract boolean checkColumns();
	
	/**
	 * CHECK THREE
	 * checks diagonals for if the player is close to winning
	 * @param posY
	 * @param posX
	 * @return true if an O was placed
	 */
	protected abstract boolean checkDiagonals();
	//poopoopeepeepapa
}
