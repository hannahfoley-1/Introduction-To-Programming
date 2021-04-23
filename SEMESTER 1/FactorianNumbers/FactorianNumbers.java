import java.util.Scanner;
public class FactorianNumbers {

	public static int ZERO_FACTORIAL = 1; 
	public static void main(String[] args) {
		
		boolean quit = false;
		Scanner input = new Scanner (System.in);
		
		while (!quit)
			{
			  System.out.print("Enter your number or enter 'quit': " );

			  
			  if (input.hasNextInt())
			  {    
			     int number = input.nextInt();
			     System.out.println("The number " + number + " is " + (isFactorian(number)? "" : "not ") + "a factorian." );
			  }
			  else if (input.hasNext("quit"))
			  {
				  quit = true;
			  }
			} input.close();
	}
	
	public static int computeFactorian(int number) //takes a single integer and returns the fatorial
	{
		int factorial = 1;
		
		for (int i = 2; i <= number ; i++)
		{
		  
			factorial = number*i;
		  
		}
		
		return factorial;
	}
	
	public static boolean isFactorian(int number) //takes a single integer and returns whether or not is it a factorian number
	{
		boolean isFactorian = false;
		int currentNumber = number;
		int sumOfFactorials = 0;
		
		do
		{
			sumOfFactorials += computeFactorian((currentNumber % 10));
			currentNumber /= 10;
		} while (currentNumber != 0);
		
		if (sumOfFactorials == computeFactorian(number))
		{
			isFactorian = true;
		}
		
		return isFactorian;
	}

}
