import java.util.Scanner;
public class BMI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("What is your weight in kg? ");
		Scanner input = new Scanner( System.in );
		double kg = input.nextDouble();
		System.out.print("What is your height in metres? ");
		double metres = input.nextDouble();
		input.close ();
		double heightByHeight = metres*metres; //multiply their height by itself to get height^2
		double answer = kg/heightByHeight ; //divide this by their weight
		System.out.println("Your BMI is " + answer);
        }
	}


