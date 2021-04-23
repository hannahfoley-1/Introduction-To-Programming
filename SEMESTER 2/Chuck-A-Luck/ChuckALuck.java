/* SELF ASSESSMENT 

1. ResolveBet

I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object, and a void return type
[Mark out of 7: 7 ].
Comment: My resolveBet method takes in a string of the bet types and the wallet object as parameters and returns nothing as required

My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet 
[Mark out of 8: 8].
Comment: My function shows the amount in the wallet and asks how much the player would like to bet

My program ensures the bet amount is not greater than the cash in the wallet 
[Mark out of 5: 5 ].
Comment: if user has input an amount greater than what is in the wallet, it outputs that the player only has x amount to play with

My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned
[Mark out of 15: 15 ]..
Comment: Three dice objects are creates and they are rolled using the roll method defined in dice, the result of these three rolls are added

My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet 
[Mark out of 20: 20 ].
Comment: the sum is used to calculate the result of the low, high and field bets, the faces on the dice are used to calculate the result of the triple bet

My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses 
[Mark out of 10: 10 ].
Comment: my program outputs win/lose and the amount of money in the wallet after each bet

2. Main

I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it
[Mark out of 15: 15 ]
Comment: I created a wallet object at the start of the game that used input from the user for the initial amount of money in it

My program loops continuously until the user either enters quit or the cash in the wallet is 0
[Mark out of 5: 5 ]
Comment: if the amount reaches 0, the game finishes. if the person choses to quit by entering 'quit', the game finished

I ask the user to enter any of the four bet types or quit
[Mark out of 5: 5].
Comment: the user can enter these options to play how they choose

My program calls resolveBet for each bet type entered
[Mark out of 5: 5].
Comment: my program calls resolveBet while quit is false 

At the end of the game my program presents a summary message regarding winnings and losses 
[Mark out of 5: 5]
Comment: after ending a summary is presented with how much money was initially in wallet and how much is in wallet at the end of the game

 Total Mark out of 100 (Add all the previous marks):
*/

import java.util.Scanner;
import java.util.Random;

public class ChuckALuck {
	
	public static void main(String[] args) {
		boolean quit = false;               
		double startingAmount = 0;
		
		System.out.print("How much money do you want to play with? ");
		Scanner input = new Scanner (System.in);
		
		if (input.hasNextDouble())
		{
			startingAmount = input.nextDouble();
			if (startingAmount == 0)
			{
				System.out.print("Please input a number greater than 0 ");
				input.next();
				startingAmount = input.nextDouble();
			}
		}
		else 
		{
			System.out.print("Please input a number ");
			input.next();
			startingAmount = input.nextDouble();
		}
		
		Wallet playerWallet = new Wallet();
		//put the money in the wallet
		playerWallet.put(startingAmount);  
	 
		while (!quit) {
			System.out.println("Place your bets! ");
			System.out.print("Enter what bet you want to play. Triple, Field, High or Low. Or enter 'quit' to quit while you're ahead! ");
			String betType = input.next();
			
			if (betType.equalsIgnoreCase("quit"))
			{
				quit = true;
			}
			if (playerWallet.check() == 0)
			{
				// if player has ran out of money, they cannot play 
				System.out.println("You've ran out of money. ");
				quit = true;
			}
			else if ((betType.equalsIgnoreCase("triple") || betType.equalsIgnoreCase("field") || betType.equalsIgnoreCase("high") 
					|| betType.equalsIgnoreCase("low")) && !quit)
			{
				resolveBet(betType, playerWallet);	
			}

		}
		//game over
		System.out.println("You started the game with  €" + startingAmount + " in your wallet.");
		System.out.println("You now have €" + playerWallet.check() + " in your wallet.");

	}
	
	public static void resolveBet (String betType, Wallet playerWallet)
	{
		boolean play = false;
		boolean win = false;
		double betAmount = 0;
		
		while(!play)
		{
			System.out.print("You have  €" + playerWallet.check() + " in your wallet. How much would you like to bet? ");
			Scanner input = new Scanner (System.in);
			if (input.hasNextDouble())
			{
				betAmount = input.nextDouble();
				play = true;
			}
			else //if they didn't put in a number
			{
				System.out.print("Please input a number ");
				input.next();
				betAmount = input.nextDouble();
				play = true;
			}
			if (betAmount <= 0)
			{
				System.out.print("Please input a number greater than 0 ");
				betAmount = input.nextDouble();
				play = true;
			} 
			if (betAmount > playerWallet.check())  //if they bet more than is in their wallet
			{
				System.out.print("You only have €" + playerWallet.check() + " in your wallet to play with. Enter bet amount. ");
				betAmount = input.nextDouble();
				play = true;
			}
		}
		
		//take bets from wallet
		playerWallet.get(betAmount);
		
		Dice die1 = new Dice();
		Dice die2 = new Dice();
		Dice die3 = new Dice();
		int d1 = die1.roll();
		System.out.println("Dice 1: " + die1.toString());
		int d2 = die2.roll();
		System.out.println("Dice 2: " + die2.toString());
		int d3 = die2.roll();
		System.out.println("Dice 3: " + die3.toString());
		int sum = d1 + d2 + d3;
	
		if (betType.equalsIgnoreCase("triple"))
		{
			if (d1 == 1 || d1 == 6 || d2 == 1 || d2 == 6 ||d3 == 1 || d3 == 6 || d1 != d2 || d2 != d3 || d1 != d3)
			{
				win = false;	//bet Amount stays out of wallet
			}
			if (d1 == d2 && d2 == d3) // only win in triple if all three dice show the same number and the number isnt 1 or 6
			{
				win = true;
				playerWallet.put(betAmount);       //getting back what they bet
				playerWallet.put((betAmount*30));  //put in winnings 
			}
		}
		if (betType.equalsIgnoreCase("field"))
		{
			if (sum < 8 || sum > 12)
			{
				win = true;
				playerWallet.put(betAmount*2); //get back what they bet and put in winnings
				
			}
			else
			{
				win = false;
				//bet Amount stays out of wallet
			}
		}
		if (betType.equalsIgnoreCase("high"))
		{
			// if all three are 4, 5 or 6 it's a loss
			if ((d1 == 4 && d2 == 4 && d3 == 4) || (d1 == 5 && 5 == d2 && 5  == d3) || (d1 == 6 && 6 == d2 && 6 == d3))
			{
				win = false;
				//bet Amount stays out of wallet
			}
			if (sum > 10)
			{
				win = true;
				playerWallet.put(betAmount*2); //get back what they bet and put in winnings
			}
			else
			{
				win = false;
				//bet Amount stays out of wallet
			}
		}
		if (betType.equalsIgnoreCase("low"))
		{	
			//lose if all three are 1, 2 or 3
			if ((d1 == 1 && d2 == 1 && d3 == 1) || (d1 == 2 && 2 == d2 && 2 == d3) || (d1 == 3 && 3 == d2 && 3 == d3))
			{
				win = false;
				//bet Amount stays out of wallet
			}

			if (sum < 11)
			{ 
				win = true;
				playerWallet.put(betAmount*2);  //get back what they bet and put in winnings
			}
			else
			{
				win = false;
				//bet Amount stays out of wallet
			}
		}
		
		if (win)
		{
			System.out.println("Congratulations, you have won! ");
			System.out.println("You have €" + playerWallet.check() + " left in your wallet. ");
		}
		else if (!win)
		{
			System.out.println("Sorry, you have lost! ");
			System.out.println("You have €" + playerWallet.check() + " left in your wallet. ");
		}
		
	}

}
