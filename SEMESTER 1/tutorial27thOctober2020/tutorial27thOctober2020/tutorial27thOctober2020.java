package tutorial27thOctober2020;
import java.util.Scanner; 
public class tutorial27thOctober2020 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("Is the animal cold blooded? (Yes/No) ");
		Scanner input = new Scanner (System.in);
		String isColdBlooded = input.next();
		
		boolean isColdBloodedAnswer = isColdBlooded.equalsIgnoreCase("Yes");
		
		if (isColdBloodedAnswer)
		{ //when the animal is cold blooded
			System.out.print("Does the animal have a covering of moist skin? (Yes/No) ");
			String hasMoistSkin = input.next();
			
			boolean hasMoistSkinAnswer = hasMoistSkin.equalsIgnoreCase("Yes");
			
			if (hasMoistSkinAnswer)
			{ //when the animal is cold blooded and has moist skin
				System.out.print("Does the animal have fins? (Yes/No) ");
				String hasFins = input.next();
				
				boolean hasFinsAnswer = hasFins.equalsIgnoreCase("No");
				
				if (hasFinsAnswer)
					{
						System.out.print("The animal is an amphibian." ); //cold blooded, moist skin, no fins
					}
				else 
				{
				}
				
			}
			else 
			{ //when the animal is cold blooded and does not have moist skin
				System.out.print("Does the animal have a covering of scales? (Yes/No) ");
				String hasScales = input.next();
				
				boolean hasScalesAnswer = hasScales.equalsIgnoreCase("Yes");
				
				if (hasScalesAnswer)
				{
					System.out.print("Does the animal have fins? (Yes/No) ");
	                String hasFins2 = input.next();
	                
	                boolean hasFinsAnswer2 = hasFins2.equalsIgnoreCase("No");
					
	                if (hasFinsAnswer2)
	                {
	                	System.out.print("The animal is a reptile." ); //cold blooded, no moist skin, scales, no fins
	                }
	                else 
	                {
	                	System.out.print("The animal is a Fish." ); //cold blooded, no moist skin, scales, fins	
	                }
	           }
			}
		}
		else
		{ //when the animal is not cold blooded
			System.out.print("Does the animal have a covering of hair or fur? (Yes/No) ");
			String hasHairFur = input.next();
			
			boolean hasHairFurAnswer = hasHairFur.equalsIgnoreCase("Yes");
			
			if (hasHairFurAnswer)
			{
			System.out.print("The animal is a mammal");
			}
			else 
			{
				System.out.print("The animal is a bird");
			}
		}
	}

}
