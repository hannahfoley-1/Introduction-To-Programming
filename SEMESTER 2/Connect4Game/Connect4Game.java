/* SELF ASSESSMENT

Connect4Game class (35 marks)
My class creates references to the Connect 4 Grid and two Connect 4 Players.
It asks the user whether he/she would like to play/quit inside a loop. 
If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface, 
2. the two players are initialised - must specify the type to be ConnectPlayer, and
3. the game starts. In the game, I ask the user where he/she would like to drop the piece. 
I perform checks by calling methods in the Connect4Grid interface. 
Finally a check is performed to determine a win. 
Comment: My class begins by creating references to objects
It asks the user to start the game or quit the game.
Once the user has decided to play against another human or the computer, the grid is created using the connect4Grid interface
and the players are initialised
The makeMove methods in the player class ask the user where they would like to drop their pieces and it tests if the move is allowed
by using the methods in the connect4GRid interface
Checks are made to determine if a player has won.
This repeats until the board is full or a player has won

Connect4Grid interface (10 marks)
I define all 7 methods within this interface.
Comment:
Yes, in this method i just declared all the abstract methods without writing their functionality

Connect4Grid2DArray class (25 marks) 
My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check 
whether the column to drop the piece is valid.
It provides as implementation of the method to check whether the column to drop the piece is full.
It provides as implementation of the method to drop the piece. 
It provides as implementation of the method to check whether there is a win.
Comment:
My class implements the Connect4Grid interface and builds on it
It uses the grid 2d array to check if the column is a valid column ie if it exists.
If the column exists, it checks if this column is full already by checking the contents of the first row of the grid array.
if its full, it asks the user to entere another column
It has a method which drops a piece into a passed column, and places it in the next available row in that column
The last method checks if the player has won the game by comparing pieces in the array horixontally, vertically and diagonally

ConnectPlayer abstract class (10 marks)
My class provides at lest one non-abstract method and at least one abstract method. 
Comment:
The setter and getter in this class are the non-abstract methods as they are implemented in the class itself
The makeMove method is an abstract method as it changes for human and AI players. This method cannot be implemented within the 
connectPlayer class itself

C4HumanPlayer class (10 marks)
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides the Human player functionality.
Comment:
Yes my class extends connectPLayer, overriding the make move method.
It allows humans to play by choosing their own column to drop into and checking if it can be done before dropping it in

C4RandomAIPlayer class (10 marks)
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides AI player functionality. 
Comment:
Yes my class extends connectPLayer, overriding the make move method.
It allows humans to play agaisnt computers as the compueter picks a random column to drop into and 
checking if it can be done before dropping it in

Total Marks out of 100:
100
*/

import java.util.Scanner;

public class Connect4Game {
	//objects needed to play connect 4
	static public ConnectPlayer player1;
	static public ConnectPlayer player2;
	static public Connect4Grid2DArray grid;

	public static void main(String[] args) {
		boolean quit = false;
		boolean readyToPlay = false;  //ready to play when the two player object have been initialised
		
		while(!quit) {
			System.out.print("Type 'start' to start game or 'quit' to quit the game ");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.next();
			
			if (input.equalsIgnoreCase("start")){
				
				while(!readyToPlay) {
				System.out.print("Do you want to play with another human player or against the computer? (enter "
						+ "human/computer) ");
				input = scanner.next();
				
				//if input is human, then two versions of the human player object should be made
				if (input.equalsIgnoreCase("human")){
					player1 = new C4HumanPlayer();
					player1.setPlayerPiece(Connect4Grid.PLAYER1);
					player2 = new C4HumanPlayer();
					player2.setPlayerPiece(Connect4Grid.PLAYER2);
					System.out.println("Player 1 is " + Connect4Grid.PLAYER1);
					System.out.print("Player 2 is " + Connect4Grid.PLAYER2);
					readyToPlay = true;
				}
				
				//if input is computer then one version of the computer player object is made and one
				//version of the human player object 
				else if (input.equalsIgnoreCase("computer")) {
					player1 = new C4HumanPlayer();
					player1.setPlayerPiece(Connect4Grid.PLAYER1);
					player2 = new C4RandomAIPlayer();
					player2.setPlayerPiece(Connect4Grid.PLAYER2);
					System.out.println("Your piece is " + Connect4Grid.PLAYER1);
					System.out.println("Computer player is " + Connect4Grid.PLAYER2);
					readyToPlay = true;
				}
				
				else {
					System.out.println("Input error.");
				}
				}//while ready to play
			    
			  
				//once ready to play
				System.out.println("Game is starting");
				
				//draw empty grid
				grid = new Connect4Grid2DArray();
				grid.emptyGrid();
				boolean gameOver = false;
				System.out.print(grid.toString());
				
				while (!gameOver) {
				//ask where they want to drop, check it and drop it
				System.out.println("Player 1's turn");
     			player1.makeMove(grid, player1);
				System.out.print(grid.toString());
				
				//check board to see if a win has been made
				boolean win1 = grid.didLastPieceConnect4(player1.playerPiece);
				if (win1) {
					System.out.println("Player 1 wins!!!");
					gameOver = true;
				}
				else {
					//check to see if board is full 
					boolean full = grid.isGridFull();
					if (full) {
					System.out.print("Game Over! Full Grid");
					gameOver = true;
				    }
				}
				
				//if the game hasn't ended, continue onto player 2's turn
				if (!gameOver) {
				System.out.println("Player 2's turn");
				player2.makeMove(grid, player2);
				System.out.print(grid.toString());
				
				//check board to see if a win has been made
				boolean win2 = grid.didLastPieceConnect4(player2.playerPiece);
				if (win2) {
					System.out.println("Player 2 wins!!!");
					gameOver = true;
				}
				else {
					//check to see if board is full 
					boolean full = grid.isGridFull();
					if (full) {
					System.out.println("Game Over! Full Grid");
					gameOver = true;
					}
				}
				
				} //repeat the turns unless the game is over
				
			}//end of if 'start'
			
		    if (input.equalsIgnoreCase("quit")) {
				quit = true;
			}
			else if (!gameOver){
				System.out.println("Input error");
			}
			}//while the game is not over	
		}//while !quit
	}

}
