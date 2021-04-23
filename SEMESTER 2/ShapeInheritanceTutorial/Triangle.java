
public class Triangle implements Shape{
	private String colour;
	private int base;
	private int height;
	
	Triangle(String colour, int base, int height){
		this.colour = colour;
		this.base = base;
		this.height = height;
	}

	@Override
	public double getArea() {
		return 0.5*base*height;
	}

	@Override
	public double getPerimeter() {
		return 3*base;
	}
	
	public String toString() {
		return ("Colour: " + colour +  " Area: " +  getArea());
	}
}
