package tile;

import player.Player;

/**
 * TILE
 * controls tile attributes like isRevealed, isWall, and if it holds the player
 */
public class GameTile
{
	/* CLASS ATTRIBUTES */
	private boolean isRevealed; // flips when the player hits it
	private Player player; // player object that is held in a tile
	private final boolean isWall; // determins if the tile is or is not a wall
	
	/**
	 * CONSTRUCTOR
	 * constructs a wall
	 * @param isWall ( set to true when this constructor is called)
	 */
	public GameTile(boolean isWall, boolean isRevealed, Player player)
	{
		this.isWall = isWall;
		this.isRevealed = isRevealed;
		this.player = player;
	}
	
	/**
	 * GETTER
	 * @return isRevealed
	 */
	public boolean isRevealed()
	{
		return isRevealed;
	}
	/**
	 * SETTER
	 * @param isRevealed
	 */
	public void setRevealed(boolean isRevealed)
	{
		this.isRevealed = isRevealed;
	}
	
	/**
	 * GETTER
	 * @return isWall
	 */
	public boolean isWall()
	{
		return isWall;
	}
	
	/**
	 * GETTER
	 * @return
	 */
	public Player getPlayer()
	{
		return player;
	}
	/**
	 * SETTER
	 * @param player
	 */
	public void setPlayer(Player player)
	{
		this.player = player;
	}
	
	/**
	 * TOSTRING
	 * returns a wall, player, or nothing based on attributes
	 */
	@Override
	public String toString()
	{
		if (player != null)
		{
			return "8"; // returned if the current tile holds the player
		}
		else if (isRevealed)
		{
			if (isWall)
			{
				return "|"; // returned if a wall is revealed
			}
			else
			{
				//return "O"; // returned if a path is revealed
			}
		}
		return " "; // returned if a wall isn't revealed or there is nothing there
	}
	// if you are reading this clap before you start next class
}
