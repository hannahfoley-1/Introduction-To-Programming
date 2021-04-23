import java.util.Scanner;
import java.lang.Math;
public class GradeComputation {
	
	public static final String[] MODULE_CODES = { "CSU11001", "CSU11010", "CSU11013", "CSU11021", "CSU11022", "CSU11026", "CSU11031", "CSU11081", "CSU12002", "STU11002" };
	public static final int[]    MODULE_CREDITS = { 5, 10, 5, 5, 5, 10, 5, 5, 5, 5 };


	public static void main(String[] args) {
		System.out.println("Welcome to the first year grade assessor.");
		double [] marks = new double [10];
		boolean quit = false;
		Scanner input = new Scanner (System.in);
		
		while (!quit)
		{
		     for (int forCount = 0; forCount <= marks.length-1 && !quit; forCount++)
		     {
			    	System.out.print("Enter the student mark for " + MODULE_CODES[forCount] + " (or enter quit): ");
				
			    	if (input.hasNextDouble())
			    	{
					    marks[forCount] = input.nextDouble();
			     	}
			    	else 
				    {
				    	if (input.hasNext("quit"))
				        {
					    	quit = true; 
					    }
					    else 
					    {
						    System.out.println("Error - Enter a number between 0.0 and 100.0 or quit.");
						    forCount = forCount - 1;
						    input.next();
				     	}
			    	}
			}
		    if (!quit)
		    {
		       String result = determineOverallGrade(marks);
		       int averageMark = (int)Math.round(weightedAverageMark(marks));
		       System.out.println("Result = " + result + " with an overall mark of " + averageMark + "%.");
		       int creditsFailed = creditsBelowSpecifiedMark(marks, 40);
		       if (result.equalsIgnoreCase("fail")) //(creditsFailed != 0)
		       {
                  System.out.println("   " + creditsFailed + " credits were failed.");
		       }
		       System.out.println("");
		    }
		}
	}
	
	public static int creditsBelowSpecifiedMark( double[] marks, int specifiedMinimumMark ) { //takes an array of student marks and returns the total number of credits are associated any (rounded) marks which are below the specified minimum mark.
        int creditsFailed = 0;   
        if (marks == null)
        {
        	return creditsFailed;
        }
		for (int count = 0; count <= marks.length-1; count ++)
		{
			int roundedMark = (int)Math.round(marks[count]);
			if (roundedMark < specifiedMinimumMark)
			{
				creditsFailed = creditsFailed + MODULE_CREDITS[count];
			}
		}
		return creditsFailed;
	}
	
	public static double weightedAverageMark( double[] marks ) { //which takes an array of student marks and returns the weighted average mark (where the weight for each mark is determined by the credits associated with it).
         double sumOfWeightedMarks = 0;
         double subjectWeight = 0;
         int creditCount = 0;
         if (marks == null)
         {
        	 return sumOfWeightedMarks; 
         }
         
         for (int count=0; count <= marks.length-1; count ++)
         {
        	 subjectWeight = marks[count]*MODULE_CREDITS[count];
        	 sumOfWeightedMarks = sumOfWeightedMarks + subjectWeight;
        	 creditCount = creditCount + MODULE_CREDITS[count];
        	 
         }
         return sumOfWeightedMarks/creditCount;	
	}
	
	public static String determineOverallGrade( double[] marks ) { //which takes an array of student marks and returns the overall grade as String (One of "FAIL", "III", "II.2", "II.1", "I").
	     if (marks == null)
	     {
	    	return ""; 
	     }
		 String overallGrade = "";
	     int averageMark = (int)Math.round(weightedAverageMark(marks));
	     int creditsFailed = creditsBelowSpecifiedMark(marks, 40);
	     if (creditsFailed > 10)
	     {
	    	 return "FAIL";
	     }
	     for (int count = 0; count <= marks.length-1; count ++)
	     {
	    	 int indvMark =  (int)Math.round(marks[count]);
	    	 if (indvMark < 35)
	    	 {
	    		 return "FAIL";
	    	 }
	     }
	     if (averageMark < 40)
	     {
	    	 return "FAIL";
	     }
	     if (averageMark >= 40 && averageMark < 50)
	     {
	    	 return "III";
	     }
	     if (averageMark >= 50 && averageMark < 60)
	     {
	    	 return "II.2";
	     }
	     if (averageMark >= 60 && averageMark < 70)
	     {
	    	 return "II.1";
	     }
	     if (averageMark >=70 && averageMark <= 100)
	     {
	    	 return "I";
	     }
	     return overallGrade;
	}
}
	
