
public class Tile
{
	/* CLASS ATTRIBUTES */
	private boolean isRevealed; // flips when the player hits it
	private Player player; // player object that is held in a tile
	private final boolean isWall; // determins if the tile is or is not a wall
	
	/**
	 * CONSTRUCTOR
	 * constructs a wall
	 * @param isWall ( set to true when this constructor is called )
	 */
	public Tile(boolean isWall, boolean isRevealed, Player player)
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
			return "B"; // returned if the current tile holds the player
		}
		else if (isWall && isRevealed)
		{
			return "|"; // returned if the current wall is revealed
		}
		else if (!isWall && isRevealed)
		{
			return "O"; // returned when the path was walked on
		}
		return " "; // returned if a wall isn't revealed or there is nothing there
	}
	// if you are reading this clap before you start next class
}
