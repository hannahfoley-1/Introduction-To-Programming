package tutorial19thOct2020StandardDeviation;

import java.util.Scanner;
import java.lang.Math;
public class standardDeviation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//package tutorial19thoctober2020;

		// Write a program which takes in 3 numbers and computes their average and standard deviation.
		System.out.print("Enter first number ");
		Scanner input = new Scanner (System.in);
		double firstNumber = input.nextDouble();
		System.out.print("Enter second number ");
		double secondNumber = input.nextDouble();
		System.out.print("Enter third number ");
		double thirdNumber = input.nextDouble();
		input.close();
		double average = (firstNumber + secondNumber + thirdNumber)/3;
		System.out.println("Average number is " + average);
		
        //standard deviation part
        double summation = ((Math.pow((average - firstNumber), 2.0)+(Math.pow((average - secondNumber), 2.0))+
        		(Math.pow((average - thirdNumber), 2.0)))/3);
        double standardDeviation = Math.sqrt(summation);
		System.out.print("The standard deviation of your three numbers is " + standardDeviation);	
	    
	}

}



