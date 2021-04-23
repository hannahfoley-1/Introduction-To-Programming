package triangleCoordinates;

import java.util.Scanner;

public class triangleCoordinates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Write a program which takes the coordinates of the three vertices of a triangle and computes the area of 
		//the triangle according to the following formula:
		
		System.out.println("A, B and C are the three vertices of a triangle.");
		System.out.print("Enter X Co-Ordinate of point A ");
		Scanner input = new Scanner (System.in);
		double pointAX = input.nextDouble();
		System.out.print("Enter Y Co-Ordinate of point A ");
		double pointAY = input.nextDouble();
		System.out.print("Enter X Co-Ordinate of point B ");
		double pointBX = input.nextDouble();
		System.out.print("Enter Y Co-Ordinate of point B ");
		double pointBY = input.nextDouble();
		System.out.print("Enter X Co-Ordinate of point C ");
		double pointCX = input.nextDouble();
		System.out.print("Enter Y Co-Ordinate of point C ");
		double pointCY = input.nextDouble();
		input.close();
		
		double area = Math.abs((( pointAX*( pointBY - pointCY )) + ( pointBX*( pointCY - pointAY)) 
				+ ( pointCX*( pointAY - pointBY)))/2);
		
		
		System.out.print("The area of the triangle is " + area);
		
	}


}
