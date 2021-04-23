/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful and properly formatted variable names?
       Mark out of 5:   5
       Comment: Yes my variables explain the values they contain and are in lowerCamelCase
    2. Did I indent the code appropriately?
       Mark out of 5:   5
       Comment: My code follows indentation rules of the coding standard
   3. Did I make use of the functions appropriately within main and the other functions?
       Mark out of 10:  10 
       Comment: Each function was called and used between the main and other functions
       Total Mark out of  20 (Add all the previous marks):  20
*/

import java.util.Scanner;
public class ThreeNumbers {

	public static void main(String[] args) {
		
		boolean quit = false;
		Scanner input = new Scanner (System.in);
		
		do //continuation condition will be !quit
		{
			System.out.print("Please enter your three integers separated by spaces (or enter 'quit'): ");
			input.useDelimiter("(\\p{javaWhitespace})+");
			
			if (input.hasNext("quit"))
			{
				quit = true;      
		    }
			else if (input.hasNextInt())
			{
				int integer1 = input.nextInt();
				int integer2 = input.nextInt();
				int integer3 = input.nextInt();
				double finalAverage = averageOf(integer1, integer2, integer3);
				int finalMedian = medianOf (integer1, integer2, integer3);
			    int finalCountGreaterThanAverage = countOfNumbersGreaterThanTheAverage (integer1, integer2, integer3);
				System.out.println(getFormattedOutputString (finalMedian, finalCountGreaterThanAverage));
			}
		
		} while (!quit);
		input.close();
	
	}	
		
		
    //medianOf function which takes three integers and returns the median of the three numbers
	public static int medianOf(int integer1, int integer2, int integer3)
	{
		int smallestNumber = 0;
		int biggestNumber = 0;
		int median = 0;
		
		if (integer1 == integer2 && integer2 == integer3 && integer3 == integer1)
		{
			median = integer1;
		}
		else if ((integer1 == integer2) || (integer1 == integer3) || (integer2 == integer3))
		{
			if ((integer1 == integer2) || (integer1 == integer3))
			{
				median = integer1;
			}
			else 
			{
				median = integer3;
			}
		}
		else if (integer1 > integer2)
		{
			biggestNumber = integer1;
			smallestNumber = integer2;
			if (integer3 > integer1)
			{
				biggestNumber = integer3;
				median = integer1;
			}
			else if (integer2 > integer3)
			{
				smallestNumber = integer3;
				median = integer2;
			}
			else
			{
				median = integer3;
			}
		}
		else if (integer2 > integer1)
		{
			biggestNumber = integer2;
			smallestNumber = integer1;
			if (integer3 > integer2)
			{
				biggestNumber = integer3;
				median = integer2;
			}
			else if (integer1 > integer3)
			{
				smallestNumber = integer3;
				median = integer1;
			}
			else
			{
				median = integer3;
			}
		}
		return median;
	}
		
	//averageOf function which takes three integers and returns the average of the three numbers as a double 
	public static double averageOf(double integer1, double integer2, double integer3)
	{
		return (integer1 + integer2 + integer3)/(3);
	}
	    
	//countOfNumbersGreaterThanTheAverage function which takes three integers and returns how many of the three numbers are greater than the average (of the three numbers).
	public static int countOfNumbersGreaterThanTheAverage (int integer1, int integer2, int integer3)
	{
		double averageForCounting = averageOf(integer1, integer2, integer3);
		int countOfNumbersGreaterThanTheAverage = 0; 
		if(countOfNumbersGreaterThanTheAverage == 0)
		{
			if (integer1 > averageForCounting)
			{
			countOfNumbersGreaterThanTheAverage += 1;
			}
		    if (integer2 > averageForCounting)
		    {
			    countOfNumbersGreaterThanTheAverage += 1;
		    }
		    if (integer3 > averageForCounting)
		    {
			    countOfNumbersGreaterThanTheAverage += 1;
		    }
		}    
		return countOfNumbersGreaterThanTheAverage;
		
	}
	
	//getFormattedOutputString function which takes the median and how many of the numbers are greater than the average and returns a String
	public static String getFormattedOutputString(int finalMedian, int finalCountGreaterThanAverage)
	{
		return String.format("The median of your numbers is " + finalMedian + ", and " + finalCountGreaterThanAverage +
				" of them " + (finalCountGreaterThanAverage >1 ? "are" : "is") + " greater than their average.");
	}
}
