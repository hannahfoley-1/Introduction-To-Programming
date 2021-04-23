
public class Square extends Rectangle{
	private String colour;
	private int length;
	
	Square(String colour, int length) {
		super(colour, length, length);
	}
	
	public double getPerimeter() {
		return 4*length;
	}
	
	public String toString() {
	 return ("Colour: " + colour +  " Length: " +  length);
	}
	
	

}
