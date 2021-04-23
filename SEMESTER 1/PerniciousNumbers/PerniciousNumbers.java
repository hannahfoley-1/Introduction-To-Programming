/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful and properly formatted variable names?
       Mark out of 5:   5
       Comment: Yes, my variable names explain in words what they represent and are in lowerCamelCase
    2. Is my code easy to follow/understand?
       Mark out of 5:   5
       Comment: I hope so, my functions have comments which describe the parameters and what they do to assist this
   3. Did I use the functions as required?
       Mark out of 10: 10  
       Comment: I used all the functions required and named them as required
       Total Mark out of  20 (Add all the previous marks):  20
*/
import java.util.Scanner;
import java.lang.Math;
public class PerniciousNumbers {

	public static void main(String[] args) {
		
		
		System.out.print("Enter the maximum number you want to consider: ");
		Scanner input = new Scanner (System.in);
		
		if (input.hasNextInt())
		{
			int maxNumberEntered = Math.abs(input.nextInt());
			
		    for (int count = 1; count <= maxNumberEntered; count=count + 1)
			{
				if (isPernicious(count)) 
				{
					int binaryOneCount = countBinaryOnes(count);
					String binaryString = getBinaryString(count);
					System.out.println(count + " is a pernicious number as it contains " + binaryOneCount + " ones in it's binary representation "
							+ "(" + binaryString + ")" );
				}
	        }
		}input.close();
	}
	
	public static String getBinaryString (int number) //takes a single integer number and returns a String containing a binary representation of the number
	{
		String binaryStringBackToFront = "";
		String correctBinaryString ="";
	    if (number < 0)
		{
             correctBinaryString += "-"
		}
		int numberEntered = Math.abs(number); 
		if (numberEntered == 0)
		{
			correctBinaryString += "0";
		}
		else
		{
		while (numberEntered!=0)
		{
		    binaryStringBackToFront = binaryStringBackToFront + (numberEntered%2);
		    numberEntered = numberEntered/2;
		}
		int binaryStringLength = binaryStringBackToFront.length();
		for (int i = binaryStringLength-1; i >= 0; i--)
		{
		    char currentNumber = binaryStringBackToFront.charAt(i);
		    correctBinaryString = correctBinaryString + currentNumber;
		}
		}
		return correctBinaryString;
	}
	
	public static boolean isPernicious (int number) // takes a single integer number and returns whether the number is pernicious or not 
	{
		int numberEntered = Math.abs(number);
		int howManyBinaryOnes = countBinaryOnes(numberEntered);
		boolean isPernicious = isPrime(howManyBinaryOnes);
		return isPernicious;
	}
	
	public static int countBinaryOnes (int number) //takes a single integer number and returns the number of ones in a binary representation of the number.
	{
		int numberEntered = Math.abs(number); 
		int binaryOneCount = 0;
		int numberEntered1 = number;
		while (numberEntered > 0)
		{
			numberEntered1 = numberEntered%2;
			if (numberEntered%2 == 1)
			{
				binaryOneCount ++;
			}
			numberEntered /= 2;
		}
		return binaryOneCount;
	}
	
	public static boolean isPrime (int number) //takes a single integer number and returns whether it is a prime number or not.
	{
		int numberEntered = Math.abs(number);
		if (numberEntered == 0 || numberEntered == 1)
		{
			return false;
		}
	    for (int i=2; i<numberEntered; i = i+1)
		{
			if (numberEntered%i == 0)
			{
				return false;
			}
		}
		return true;
	}
   
}
