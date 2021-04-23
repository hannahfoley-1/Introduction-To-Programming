/* Implement a test class (LineTest.java) that demonstrates the correct functionality of each of
the methods listed above and makes use of the Point class functionality. LineTest creates
a new Line and makes use of the methods getP1() and getP2() to print the Line’s end
points (x1, y1) and (x2, y2). Use the second constructor with four parameters to create
another Line and print the line’s end points. Finally obtain the slope of the Line using the
getSlope() method. */


public class LineTest {

	public static void main(String[] args) {
		//1. create new line (1st constructor)
		Point line1point1 = new Point(3, 2);
		Point line1point2 = new Point(6, 8);
		
		Line line1 = new Line(line1point1, line1point2);
		
		//2. print the lines end points
		System.out.println("Line one has end points of (" + line1point1.getX() + ", " + line1point1.getY() + ")"
				+ " and (" + line1point2.getX() + ", " + line1point2.getY() + ")");
		
		//3. create a second line (2nd constructor)
		Line line2 = new Line(5, 8, 12, 16);
		
		//4. print the lines end points
		Point line2point1 = line2.getP1();
		Point line2point2 = line2.getP2();
		System.out.println("Line two has end points of (" + line2point1.getX() + ", " + line2point1.getY() + ")"
				+ " and (" + line2point2.getX() + ", " + line2point2.getY() + ")");
		
		//5. obtain the slope of the lines
		double slope1 = line1.getSlope();
		double slope2 = line2.getSlope();
		System.out.print("The slope of line one is " + slope1 + " and the slope of line 2 is " + slope2);

	}

}
