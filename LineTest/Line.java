
public class Line {
	private Point p1;
	private Point p2;
	
	//Line(Point p1, Point p2) - Constructs a new Line that contains the given two Points
	Line(Point point1, Point point2)
	{
		p1 = point1;
		p2 = point2;
	}
	
	//Line(int x1, int y1, int x2, int y2) - Add a new constructor to your
	//class which constructs a new Line that contains the coordinates passed to the method
	Line(int x1, int y1, int x2, int y2)
	{
		Point ap1 = new Point (x1, y1);
		p1 = ap1;
		Point ap2 = new Point (x2, y2);
		p2 = ap2;
	}
	
	//Point getP1() - Returns this Line’s first endpoint
	Point getP1()
	{
		return p1;
	}
	
	//Point getP2() - Returns this Line’s second endpoint
	Point getP2()
	{
		return p2;
	}
	
	//double getSlope() - Returns the slope of this Line. The slope of a line between
	//points (x1, y1) and (x2, y2) is equal to (y2−y1)/(x2−x1). If x2 equals x1 the
	//denominator is zero and the slope is undefined, so you must throw an exception in
	//this case
	double getSlope() 
	{
		double slope = 0;
		
		int p1x = p1.getX();
		int p1y = p1.getY();
		int p2x = p2.getX();
		int p2y = p2.getY();
		
		if (p2x == p1x)
		{
			throw new IllegalArgumentException();
		}
		else 
		{
			slope = (p2y - p1y)/(p2x - p1x);
			return slope;
		}
	}
	
	

	

}
