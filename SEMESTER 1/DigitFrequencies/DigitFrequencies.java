import java.util.Scanner;
public class DigitFrequencies {

	public static void main(String[] args) {
	
		boolean quit = false;
		Scanner input =  new Scanner (System.in);
		int [] numbers = null;
		int [] frequencies = new int [10]; 
		
		while (!quit)
		{
		System.out.print("Enter a number or enter 'quit' : ");
		
		if (input.hasNextInt())
		{
			int [] newNumberArray = new int [(numbers == null? 1 : numbers.length+1)];
			if (numbers != null)
			{
				System.arraycopy(numbers, 0, newNumberArray, 0, numbers.length);
			}
			newNumberArray [newNumberArray.length-1] = input.nextInt();
			numbers = newNumberArray;
			
			countDigitFrequencies(numbers[numbers.length-1], frequencies);
			printDigitFrequencies(frequencies);
		}
		else
		{
			if (input.hasNext("quit"))
			{
				quit = true;
			}
			else
			{
				input.next();
			}
		}
		}

	}
	
	public static void printDigitFrequencies (int[] frequencies) {
		System.out.print("Digit frequencies: ");
	    for (int count=0; count<= 9; count++)
	    {	    	
			if (frequencies[count] > 0)
			{
				System.out.print(count + "(" + frequencies[count] + ")" + " ");
			}
		}
	    System.out.println("");
	}
	
	public static void countDigitFrequencies (int number, int [] frequencies) {
		int currentNumber = number;
		int copyOfNumber = number;
		int numberOfDigits = 0;
		
		while (copyOfNumber > 0)
		{
			copyOfNumber =  copyOfNumber/10;
			numberOfDigits = numberOfDigits + 1;
		}
		for (int count = 0; count < numberOfDigits; count++)
		{
			int lsd = currentNumber%10;
			frequencies[lsd] = frequencies[lsd] + 1;
			currentNumber = currentNumber/10;
		}
			
	}
	

}
