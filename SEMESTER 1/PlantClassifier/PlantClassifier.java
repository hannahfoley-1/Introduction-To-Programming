/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful variable names?
       Mark out of 10:   10
       Comment: I used variable names which included the main features the question was asking eg. "cellsAndTissue" 
   2. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5:  5 
       Comment: All my variable names are in lowerCamelCase
   3. Did I indent the code appropriately?
       Mark out of 15:   15
       Comment: My code follows the indenting guidelines of the coding standard and I pressed CTRL+SHIFT+F
       to make sure it was formatted properly as well.
      Total Mark out of  30 (Add all the previous marks):  30
*/

import java.util.Scanner;

public class PlantClassifier

{

	public static void main(String[] args) {

		System.out.print(
				"Does the plant have cells and tissues which are organised into functional" + " structures (Yes/No)? ");
		Scanner input = new Scanner(System.in);
		String cellsAndTissues = input.next();

		boolean cellsAndTissuesAnswer = cellsAndTissues.equalsIgnoreCase("Yes");

		if (cellsAndTissuesAnswer) {
			System.out.print("Does the plant have vascular tissues (Yes/No)? ");
			String vascularTissues = input.next();

			boolean vascularTissuesAnswer = vascularTissues.equalsIgnoreCase("Yes");

			if (vascularTissuesAnswer) {
				System.out.print("Is the plant dispersed by seeds (Yes/No)? ");
				String dispersedBySeeds = input.next();

				boolean dispersedBySeedsAnswer = dispersedBySeeds.equalsIgnoreCase("Yes");

				if (dispersedBySeedsAnswer) {
					System.out.print("Are the seeds enclosed (Yes/No)? ");
					String enclosed = input.next();

					boolean enclosedAnswer = enclosed.equalsIgnoreCase("Yes");

					if (enclosedAnswer) {
						System.out.print("The plant is an ANGIOSPERM.");
					} else {
						System.out.print("The plant is a GYMNOSPERM.");
					}
				} else {
					System.out.print("The plant is a PTERIDOPHYTE.");
				}
			} else {
				System.out.print("The plant is a BRYOPHYTE");
			}

		}

		else {
			System.out.print("The plant is an ALGAE.");
		}

	}

}
