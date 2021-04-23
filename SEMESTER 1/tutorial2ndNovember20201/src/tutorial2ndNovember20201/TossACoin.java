package tutorial2ndNovember20201;


import java.util.Random;
public class TossACoin {
	
	public static final int NUMBER_OF_THROWS = 10000;
	public static final int HEADS = 1;
	public static final int TAILS = 0;

	public static void main(String[] args) {
		
		Random generator = new Random ();
		boolean headsShownOnCoin = false;
		int headsCount = 0;
		
		for (int throwCount=0 ; throwCount < NUMBER_OF_THROWS; throwCount++)
		{
			headsShownOnCoin = (generator.nextInt(2) == HEADS);
			headsCount += (headsShownOnCoin) ? 1 : 0;
		}
		
		System.out.println("Heads: " + headsCount + "\nTails: " + (NUMBER_OF_THROWS - headsCount) + "\nLast: " + 
		((headsShownOnCoin)? "Heads" :"Tails"));
	

	}

}
