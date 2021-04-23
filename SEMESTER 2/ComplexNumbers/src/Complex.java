public class Complex {
	private double x; //for the real part of the number
	private double y; //for the imaginary part of the number
	
	public Complex()
	{
		x = 0;
		y = 0;
	}
	
	public Complex(double realPart, double imaginaryPart)
	{
		x = realPart;
		y = imaginaryPart;
	}
	
	public static Complex add (Complex a, Complex b)
	{
		double xpart = a.x + b.x;
		double ypart = a.y + b.y;
		Complex result = new Complex(xpart, ypart);
		return (result);
	}
	
	public static Complex multiply (Complex a, Complex b)
	{
		double xpart = (a.x*b.x) - (a.y*b.y);
		double ypart = (a.x*b.y) + (a.y*b.x);
		Complex result = new Complex(xpart, ypart);
		return (result);
	}
	
	public static Complex divide (Complex a, Complex b)
	{
		double xpart = ((a.x*b.x) + (a.y*b.y))/((b.x*b.x) + (b.y*b.y));
		double ypart = ((a.y*b.x) - (a.x*b.y))/((b.x*b.x) + (b.y*b.y));
		Complex result = new Complex(xpart, ypart);
		return (result);
	}
	
	public String toString ()
	{
		return (x  + " + " + y + "i");
	}

}
