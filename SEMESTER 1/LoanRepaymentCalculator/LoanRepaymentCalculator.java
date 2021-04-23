/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 5: 5
       Comment: Yes, I used the constant of MONTHS_IN_A_YEAR rather than the number 12 as the months in a year never changes
   2. Did I use easy-to-understand, meaningful CONSTANT names?
       Mark out of 5: 5
       Comment: I named it MONTHS_IN_A_YEAR which is easy to understand for anyone reading the code
        3. Did I format the CONSTANT names properly (in UPPERCASE)?
       Mark out of 5: 5  
       Comment: Yes, I used all caps and underscores
   4. Did I use easy-to-understand meaningful variable names?
       Mark out of 10:  10 
       Comment: I gave names which could be easily understood by someone else reading the code
   5. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5: 5
       Comment: I used lowerCamelCase for all variables
   6. Did I indent the code appropriately?
       Mark out of 10: 10  
       Comment: The code is indented as in line with the coding standards
     Total Mark out of  40 (Add all the previous marks):  40
*/

import java.util.Scanner;

public class LoanRepaymentCalculator {
	final static int MONTHS_IN_A_YEAR = 12;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("Enter loan amount? ");
		Scanner input = new Scanner(System.in);
		double loanAmount = input.nextDouble();
		System.out.print("Enter annual interest rate (eg. 0.04)? ");
		double annualInterest = input.nextDouble();
		System.out.print("Enter the term of the loan in years? ");
		int loanTermYear = input.nextInt();
		input.close();

		double monthlyInterest = annualInterest / MONTHS_IN_A_YEAR;
		double loanTermMonth = loanTermYear * MONTHS_IN_A_YEAR;

		double monthlyRepayment = ((loanAmount * monthlyInterest) * (Math.pow((1 + monthlyInterest), loanTermMonth))
				/ ((Math.pow((1 + monthlyInterest), loanTermMonth)) - 1));

		System.out.printf("The monthly repayment for a %d year loan of %.2f at an annual interest rate of %.2f would"
				+ " be %.2f ", loanTermYear, loanAmount, annualInterest, monthlyRepayment);

	}

}
