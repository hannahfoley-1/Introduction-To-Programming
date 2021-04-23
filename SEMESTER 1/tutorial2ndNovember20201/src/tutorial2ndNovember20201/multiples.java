package tutorial2ndNovember20201;

import java.util.Scanner;

public class multiples {

	public static void main(String[] args) {
		System.out.print("Enter the first number (which you want to find the multiples of) ");
		Scanner input = new Scanner(System.in);
		int multiple = input.nextInt();
		System.out.print("Enter the limit number ");
		int limit = input.nextInt();
		input.close();

		if (multiple < 0 || limit < 0) {
			System.out.print("Number(s) not in the right range");
		}

		else
		{
			System.out.print("The multiples of " + multiple + " (up to " + limit + ") are ");
			for (int total = 0 ; (total < limit) ; total += multiple)
			{
				System.out.print(((total>0)?", " :"") + total);
			}
		}

	}

}
