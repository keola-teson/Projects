
public class Opponent
{
	private Player player;
	
	public Opponent(Player player)
	{
		this.player = player;
	}
	
	public void chooseBox()
	{
		int posY = 0;
		int posX = 0;
		
		int amountX = 0;
		int amountO = 0;
		
		
		
		player.getBoard().changeBoardValue(posY, posX, 'O');
	}
}
