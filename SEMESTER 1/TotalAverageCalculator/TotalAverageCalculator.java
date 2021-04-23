/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful variable and constant names?
       Mark out of 10: 10
       Comment: My variable names describe exactly what the value of the variable is eg average
   2. Did I format the variable and constant names properly (in lowerCamelCase and UPPERCASE)?
       Mark out of 5: 5
       Comment: I used upperCamelCase for all variable names eg. howManyIntegers. There are no constants
   3. Did I indent the code appropriately?
       Mark out of 10:  10 
       Comment: My code indentation follows the coding standard
   4. Did I implement a for loop to read the input as required?
       Mark out of 10: 10
       Comment: I used a loop as required rather than getting each input separately
      Total Mark out of  35 (Add all the previous marks):  
*/

import java.util.Scanner;

public class TotalAverageCalculator {

	public static void main(String[] args) {
		System.out.print("How many integers do you want to enter? ");
		Scanner input = new Scanner(System.in);
		int howManyIntegers = input.nextInt();

		if (howManyIntegers > 10 || howManyIntegers < 2) {
			System.out.print("Error:  This program is constrained to only compute the total & average of between "
					+ "2 & 10 integers. ");
		} 
		else
		 {
            int sum = 0;
			for (int count = 1; count < (howManyIntegers + 1); count++)
			 {
				System.out.print("Enter integer " + count + " ");
				int value = input.nextInt();
				sum += value;
             }
			double average = (double) sum / (double) howManyIntegers;
			System.out.printf("The sum of your integers is %d and the average is %.2f ", sum, average);
		}

	}

}
