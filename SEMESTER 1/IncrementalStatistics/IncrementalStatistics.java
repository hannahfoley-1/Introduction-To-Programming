/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful variable names?
       Mark out of 5:   5
       Comment: My variable names describe the values in the variables and would be easily understood by someone else reading the code
   2. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5:   5
       Comment: All my variables are in lowerCamelCase eg AverageOld
   3. Did I indent the code appropriately?
       Mark out of 5:   5
       Comment: My code follows coding standard indentation. I fixed this after losing marks over this last week.
   4. Did I implement a while loop or do-while loop as required?
       Mark out of 10:   10
       Comment: I used a do while loop as I wanted the 'enter number' line to be printed at least once and for an unknown amount of times
      Total Mark out of  25 (Add all the previous marks):  
*/

import java.util.Scanner;
public class IncrementalStatistics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("This program computes the average and variance of all numbers entered.");
		
		//initialise variables and booleans
		double averageOld = 0;
		double varianceOld = 0; 
		double averageNew = 0;
		double varianceNew = 0;
		int numberOfNumbersEntered = 1;
		double number = 0;
		boolean exit = false;
		Scanner input = new Scanner (System.in);
		
		do // continuation condition will be (!exit)
		{
			System.out.print("\nEnter " + ((numberOfNumbersEntered>1) ? "another " : "a ") + "number (or type 'exit'): " );
			
			if (input.hasNextDouble()) //if a number was entered
			{
				number = input.nextDouble();
				averageOld = averageNew; 
				averageNew = averageOld + ((number - averageOld)/numberOfNumbersEntered);
				varianceOld = varianceNew;
				varianceNew = (((numberOfNumbersEntered - 1) * varianceOld) + ((number - averageOld) * (number - averageNew)))/numberOfNumbersEntered;
				System.out.printf("So far the average is %.1f and the variance is %.1f ", averageNew, varianceNew);
				numberOfNumbersEntered += 1;
			}
			else 
			{
				if (input.hasNext("exit")) //if 'exit' was entered
				{
					exit = true;
					System.out.print("Goodbye.");
				}
				else //if user input isn't a number or 'exit'
				{
					System.out.print("Error:  You must enter a real number (e.g. 12.5)");
					input.next(); 
				}
			}
		} while (!exit);
			input.close();
		
	}

}
