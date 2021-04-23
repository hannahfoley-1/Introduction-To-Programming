import java.util.Scanner;
public class Median {

	public static void main(String[] args) {
		
		
		System.out.println("Welcome to the median & rolling average system. ");
		Scanner input = new Scanner (System.in);
		double [] numberArray = null; 
		boolean quit = false; 
		
		while (!quit)
		{
			System.out.print("Enter a number (or enter quit): ");
			
			if (input.hasNext("quit"))
	        {
				quit = true;
			}
			else if (input.hasNextDouble())
			{
				double [] newNumberArray = new double [(numberArray == null) ? 1 : numberArray.length + 1];
				if (numberArray != null)
				{
				System.arraycopy(numberArray, 0, newNumberArray, 0, numberArray.length);
				}
				newNumberArray [newNumberArray.length-1] = input.nextDouble();
				numberArray = newNumberArray;
				
				String formattedArray = convertToString(newNumberArray);
				double median = computeMedian(newNumberArray);
				String medianTo1dp = String.format("%.1f", median);
				int arrayLength = newNumberArray.length;
				double rollingAverage = 0;
				String rollingAverageTo1dp = "";
				if (arrayLength < 3)
				{
					rollingAverage = computeRollingAverage(newNumberArray, 3);
				    rollingAverageTo1dp = String.format("%.1f", rollingAverage);
				}
				else 
				{
					rollingAverage = computeRollingAverage(newNumberArray, 3);
					rollingAverageTo1dp = String.format("%.1f", rollingAverage);
				}
				System.out.printf("The median of " + formattedArray + " is " + medianTo1dp + " and the rolling average of the last 3 values is "
						+ rollingAverageTo1dp + ". %n");	
			}
			else 
			{
				System.out.println("Error - Enter any real number or quit. ");
				input.next();
			}
		}
		input.close();	
}
	
	// takes an array of doubles and returns the median value
	public static double computeMedian (double[] array) {
		double median = 0; 
		if (array == null)
		{
			return median;
		}
		double [] tempArray = createSortedArray(array);
		int middle = tempArray.length/2; 
	    if (tempArray.length%2 == 1)
		{
			median = tempArray[middle];
		}
		else
		{
			median = ((tempArray[middle-1]+ tempArray[middle])/2);
		}
		return median; 
	}
	
	//takes an array of doubles and returns a new sorted version of the array
	public static double [] createSortedArray (double [] array) {
		if (array == null)
		{
			return array; 
		}
		double tempArray [] = new double [array.length];
		System.arraycopy(array, 0, tempArray, 0, array.length);
		double holderVariable = 0;   
        for (int index1 = 0; index1<tempArray.length; index1++)
        {     
          for (int index2 = index1+1; index2<tempArray.length; index2++) 
          {     
              if(tempArray[index1] > tempArray[index2]) 
              {      
                 holderVariable = tempArray[index1];    
                 tempArray[index1] = tempArray[index2];    														
                 tempArray[index2] = holderVariable;
              }
          }
        }
        return tempArray;
    }
	
	//takes an array of doubles (first parameter) and the number of values (at the end of the array) to consider when computing the average
	public static double computeRollingAverage (double [] array, int numberOfValues ) {
		double rollingAverage = 0;
		double runningTotal = 0 ;
		int arrayLength = array.length;
		if (array == null || numberOfValues == 0)
		{
			return rollingAverage; 
		}
		if (numberOfValues == 1)
		{
			rollingAverage = array[0];
		}
		if (numberOfValues > arrayLength)
		{
			for (int index = 1; index <= array.length; index++)
            {
                runningTotal = runningTotal + array[array.length - index];
            }
            return runningTotal/arrayLength; 
		}
		else 
		{
		for (int index = 1; index <= numberOfValues; index++)
		{
			runningTotal = runningTotal + array[arrayLength-index];
		}
		rollingAverage = runningTotal/numberOfValues;
		}
		return rollingAverage;
	}
	
	//takes an array of doubles and returns a formatted String containing the array
	public static String convertToString (double [] array) {
		if (array == null)
		{
			return "{ }";
		}
		int arrayLength = array.length;
		String arrayString = "{"; 
		for (int index =0; index < array.length; index++)
		{
            String to1dp = String.format("%.1f", array[index]);
			arrayString = arrayString + " " + to1dp + (index<(arrayLength-1) ? "," : "");
	    }
		arrayString = arrayString + " }"; 
		return arrayString;
	}

	
	
	
	

}
