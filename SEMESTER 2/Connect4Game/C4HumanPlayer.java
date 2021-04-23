import java.util.Scanner;

public class C4HumanPlayer extends ConnectPlayer {

	@Override
	public void makeMove(Connect4Grid grid, ConnectPlayer player) {
		boolean done = false;
		while(!done)
		{
			Scanner scanner = new Scanner(System.in);
			System.out.print("What column do you want to drop into? : ");
			if(scanner.hasNextInt())
			{
				int column = scanner.nextInt();
				
				//make sure it's a valid column 
				if(grid.isValidColumn(column)) 
				{
					//make sure this column isnt full
					if (!grid.isColumnFull(column))
					{
						grid.dropPiece(player, column); 
						done = true;
					}
				}
				else 
				{
					System.out.println("ERROR: Please enter a column between 0 and 6 ");
				}
			}
			else
			{
				System.out.println("ERROR: Please enter a number ");
			}
		}
		
	}
	
	

}
