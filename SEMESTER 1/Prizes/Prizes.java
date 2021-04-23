/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful variable names?
       Mark out of 5:   5
       Comment: Yes, I only have a variable called placeNumber which describes the position that the person came in. My string variables describe the prizes
   2. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5:   5
       Comment: Yes, my variables are in lowerCamelCase eg placeNumber
   3. Did I indent the code appropriately?
       Mark out of 5:   5
       Comment: My indentation follows coding standards
   4. Did I implement a switch statement as required?
       Mark out of 10:   10
       Comment: I implemented a switch statement for the prizes part of the program
       Total Mark out of  25 (Add all the previous marks):  
*/


import java.util.Scanner;
public class Prizes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("This program tells competition participants what prize they have won.");
		
		int placeNumber = 0;
		boolean exit = false;
		String prize1 = " + dinner before the show";
		String prize2 = " + drinks during the interval";
		String prize3 = "two theatre tickets";
		Scanner input = new Scanner (System.in);
		
		while (!exit)
		{
			System.out.print("Enter your place number (or type 'exit'): ");
			
			if (input.hasNext("exit"))
			{
				exit = true;
				
			}
			else if (input.hasNextInt())
			{
				placeNumber = input.nextInt();
				
			    if (placeNumber > 10 || placeNumber <= 0)
		    	{
				    System.out.println("Sorry.  You did not win a prize.");
		    	}
		    	else
			    {
			        System.out.print("You came in " + placeNumber);
		        	System.out.print(placeNumber == 1 ? "st" : placeNumber == 2 ? "nd" : placeNumber == 3 ? "rd" : "th" );
		        	System.out.print(" place and hence won ");
			
		     	switch (placeNumber)
		
		     	{
			       case 5:
			       case 4:
			    	System.out.println("a 10 Euro book token.");
			       break; 
			       case 1: 
			    	   System.out.println(prize3 + prize2 + prize1 + ".");
			       break;
			       case 2:
			    	   System.out.println(prize3 + prize2 + ".");
			       break;
			       case 3:
			    	   System.out.println(prize3 + ".");
			       break;
			       default:
				    	System.out.println("a 5 Euro book token.");
				   break;
			    	
			    
		
			     }//switch
			    } //else
			}//else
			   
	
		}//while
		input.close();

	}

}
