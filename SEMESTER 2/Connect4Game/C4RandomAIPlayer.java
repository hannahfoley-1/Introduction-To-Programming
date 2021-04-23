import java.util.concurrent.ThreadLocalRandom;

public class C4RandomAIPlayer extends ConnectPlayer {
	
	@Override
	public void makeMove(Connect4Grid grid, ConnectPlayer player) {
		boolean done = false;
		while(!done)
		{
			//get random column number from library
			int column = ThreadLocalRandom.current().nextInt(0, 6 + 1);
			if(grid.isValidColumn(column)) 
			{
				if (!grid.isColumnFull(column))
				{
					grid.dropPiece(player, column); 
					done = true;
				}
			}
		}
	}

}
