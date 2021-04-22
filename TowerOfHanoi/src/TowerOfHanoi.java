import java.util.Scanner;
public class TowerOfHanoi {

	public static void main(String[] args) {
		
	
		System.out.print("How many disks have you? ");
		Scanner input = new Scanner (System.in);
		int diskAmount = input.nextInt();
		
		String rod1 = "rod 1";         //starting rod
		String rod2 = "rod 2"; 
		String rod3 = "rod 3";         //destination rod
		
		solve(diskAmount, rod1, rod2, rod3);

	}
	
	public static void solve(int diskAmount, String sourcerod, String middlerod, String destinationrod)
	{
		if (diskAmount == 1)
		{
			System.out.print("Move top disk from " + sourcerod + " to " + destinationrod);
			
		}
		solve(diskAmount-1, sourcerod, middlerod, destinationrod); 
        System.out.println("Move disk " + diskAmount + " from rod " +  sourcerod + " to rod " + destinationrod); 
        solve(diskAmount-1, sourcerod, middlerod, destinationrod); 
		
	 
		   
	}
		
		
}



//public class Disks {
	//private int size;   
	//private int rodItsOn;
	//private int positionOnRod;
	
	
//}
