import java.util.Scanner;
public class WeightConversion {
	
	public static final int POUNDS_IN_A_STONE = 14;
	public static final int OUNCES_IN_A_POUND = 16;
	public static final double KGS_IN_AN_OUNCE = 0.02834952;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean quit = false;
		int stones = 0;
		int pounds = 0;
		int ounces = 0; 
		Scanner input = new Scanner (System.in);
		
		while (!quit)
			{
			   System.out.print("Enter the number of Stones, Pounds and Ounces separated by spaces (or enter quit): ");
               input.useDelimiter("(\\p{javaWhitespace})+");
			
			   if (input.hasNext("quit"))
			   {
				   quit = true;      
		       }
			   else 
			   {
			       stones = input.nextInt();
			       pounds = input.nextInt();
			       ounces = input.nextInt();
			       double kilograms = convertToKilograms(stones, pounds, ounces);
			       System.out.println(getFormattedOutputString(stones, pounds, ounces));     
			   }
			}
			input.close();	
	}

    public static double convertToKilograms(double stones, double pounds, double ounces)
    {
    	double stonesToPounds = stones*POUNDS_IN_A_STONE;
    	double totalPounds = pounds + stonesToPounds;
    	double poundsToOunces = totalPounds*OUNCES_IN_A_POUND;
    	double totalOunces = ounces + poundsToOunces;
    	double ouncesToKilograms = totalOunces*KGS_IN_AN_OUNCE; 
    	return ouncesToKilograms;
    }

    public static String getFormattedOutputString(int stones, int pounds, int ounces)
    {
            String output = "";
    		if (stones != 0)
    		{
    			output += stones + " stone" + (stones>1 ? "s" : "");
    		}
    		else
    		{
    		    output += "";
    		}
    		if (pounds != 0)
    		{
    			output += (stones>1 ? ", " : "") + pounds + " pound" + (pounds>1 ? "s" : "");
    		}
    		else 
    		{
    			output += "";
    		}
    		if (ounces != 0)
    		{
    			output += (pounds>1 ? ", " : "") + ounces + " ounce" + (ounces>1 ? "s" : "");
    		}
    		else
    		{
    			output += "";
    		}
    		if (stones==0 && pounds==0 && ounces==0)
    		{
    			output += "0 ounces ";
    		}
    		output += " is equal to " + convertToKilograms(stones, pounds, ounces) + "kg";
    		return output;
    	
    }
    }