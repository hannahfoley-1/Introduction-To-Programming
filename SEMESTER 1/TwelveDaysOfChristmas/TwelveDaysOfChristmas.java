import java.util.Scanner;
public class TwelveDaysOfChristmas {

	public static final int DAYS_OF_CHRISTMAS = 12;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //loop for entire song
		//switch statements for each verse
		
	
		//switch statement for verse
		
		System.out.print("How many verses would you like? ");
		Scanner input = new Scanner (System.in);
		int currentDay = input.nextInt();
		
		
		while (currentDay <= DAYS_OF_CHRISTMAS && currentDay > 0)
		{
			input.close();  
			System.out.print("On the ");
				switch(currentDay) 
						{
					    	case 12: System.out.print("twelfth"); 
					    	break;
					    	case 11: System.out.print("eleventh"); 
					    	break;
					    	case 10: System.out.print("tenth"); 
					    	break;
					    	case 9:  System.out.print("ninth"); 
					    	break;
					    	case 8:  System.out.print("eight"); 
					    	break;
					    	case 7:  System.out.print("seventh");
					    	break;
					    	case 6:  System.out.print("sixth");
					    	break;
						    case 5:  System.out.print("fifth");
						    break;
						    case 4:  System.out.print("fourth");
						    break;
						    case 3:  System.out.print("third");
						    break;
						    case 2:  System.out.print("second");
						    break;
						    case 1:  System.out.print("first");
						    break;
						    default: break; 
						} 
				System.out.println(" day of Christmas, my true love sent to me: ");
				
				switch (currentDay)
				{
			      case 12: System.out.println("12 drummers drumming,");
			      case 11: System.out.println("11 pipers piping,");
		       	  case 10: System.out.println("10 lords a leaping,");
			      case 9:  System.out.println("9 ladies dancing,");
			      case 8:  System.out.println("8 maids a milking,");
			      case 7:  System.out.println("7 swans a swimming,");
			      case 6:  System.out.println("6 geese a laying,");
			      case 5:  System.out.println("5 golden rings,");
	       		  case 4:  System.out.println("4 calling birds,");
			      case 3:  System.out.println("3 french hens,");
			      case 2:  System.out.println("2 turtle doves and");
			      case 1:  System.out.println("a partridge in a pear tree");	
			    
				}
				currentDay = currentDay - 1;
		}
		
	}
	

}
