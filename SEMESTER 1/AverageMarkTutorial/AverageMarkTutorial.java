import java.util.Scanner;
public class AverageMarkTutorial {

	public static void main(String[] args) {
		System.out.print("Enter 5 percentages obtained (separted by spaces): ");
		Scanner input = new Scanner (System.in);
		input.useDelimiter("(\\p{javaWhitespace}|\\/)+");
		double [] marksArray = new double [5];
		for (int counter = 0; counter < 5; counter ++)
		{
			
			marksArray[counter]=input.nextDouble();
			
		}
		input.close();
		System.out.print("The average of the class is " + determineAverageMark(marksArray) + " and " 
		+ countAboveAverageStudents(marksArray) + " got above the average.");

	}
	public static double determineAverageMark (double [] marksArray) {
		double total = 0; 
		for (int index = 0; index < marksArray.length; index ++)
		{
			total += marksArray[index];
		}
		double average = total/marksArray.length;
		return average; 	
	}
	
	public static int countAboveAverageStudents (double [] marksArray) {
		int countAboveAverage = 0; 
		double average = determineAverageMark(marksArray);
		for (int index = 0; index < marksArray.length; index ++)
		{
			if (marksArray[index]>average)
			{
				countAboveAverage += 1;
			}
		}
		return countAboveAverage;
		
	}

}
