
import java.util.Scanner;
public class MinimumAndMaximumTutorial9thNov2020 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//using a while loop or do while loop
		
		System.out.print("Enter your list of numbers separated by spaces:");
		Scanner input = new Scanner( System.in );
		Scanner inputLine = new Scanner( input.nextLine() );
		if (inputLine.hasNextDouble()) //if the input is a number
		{
			double minimumNumber = inputLine.nextDouble(); //setting both minimum number and maximum number to be the first number entered 
			double maximumNumber = minimumNumber;
			while (inputLine.hasNextDouble()) //while there are still inputs eg like Ben said
			{
				double currentNumber = inputLine.nextDouble();
				if (currentNumber < minimumNumber)
				{
					minimumNumber = currentNumber;
				}
				if (currentNumber > maximumNumber)
				{
					maximumNumber = currentNumber;
				}
			}
			System.out.println("The numbers you entered are between " +
				             	minimumNumber + " and " + maximumNumber );
		}
		else
		{
			System.err.println("Error: No numbers provided."); //if there were not numbers in the string provided
		}
	}

}
