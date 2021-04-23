import java.util.Scanner;
public class ValidDate {
	
	public static final int DAYS_IN_APRIL_JUNE_SEPT_NOV = 30;
	public static final int DAYS_IN_FEBRUARY_NORMALLY = 28;
	public static final int DAYS_IN_FEBRUARY_IN_LEAP_YEAR = 29;
	public static final int DAYS_IN_MOST_MONTHS = 31;
	public static final int NUMBER_OF_MONTHS = 12;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ask for date
		System.out.print("Enter date (day/month/year): ");
		Scanner input = new Scanner( System.in );
		input.useDelimiter("(\\p{javaWhitespace}|\\/)+");
		int day = input.nextInt();
		int month = input.nextInt();
		int year = input.nextInt();
		input.close();
		if (validDate( day, month, year))
		{
			System.out.print("The date " + day + "/" + month + "/" + year + " is valid. ");
		}
		else
		{
			System.out.print("The date " + day + "/" + month + "/" + year + " is invalid. ");
			
		}
	}
		
    public static boolean isLeapYear ( int year )
    {
        // return true if leap year return 0 is not, to know how many days should be in feb
        int yearEntered = year;
        return ((yearEntered % 400 == 0)|| ((yearEntered % 4 == 0) && (yearEntered % 100 != 0)));
    }
    
    public static int daysInMonth (int month, int year);
        // returns number of days in the given month
    {
        int numberOfDaysInMonth = DAYS_IN_MOST_MONTHS;
        int monthEntered = month; 
        switch (monthEntered)
        { 	
        case 2:
       	 numberOfDaysInMonth = isLeapYear(year) ? DAYS_IN_FEBRUARY_IN_LEAP_YEAR : DAYS_IN_FEBRUARY_NORMALLY;
       	 break;
        case 9:
        case 4:
        case 6:
        case 11:
        	numberOfDaysInMonth = DAYS_IN_APRIL_JUNE_SEPT_NOV;
        	break;
        default: 
        	numberOfDaysInMonth = DAYS_IN_MOST_MONTHS;
        	break; 
        }
        return numberOfDaysInMonth;
    }   
    
    public static boolean validDate (int day, int month, int year);
        // is day correct for month, is year correct if leap day entered
    
    	return ((year >= 0) && (month >= 1) && (month <= NUMBER_OF_MONTHS) && (day >= 1) && (day <= daysInMonth(month, year)));
    }
        	

}
