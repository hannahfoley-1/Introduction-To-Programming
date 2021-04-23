
public abstract class Rectangle implements Shape {
	private String colour;
	private int length;
	private int width;
	
	Rectangle(String colour, int length, int width){
		this.colour = colour;
		this.length = length;
		this.width = width;
	}

	@Override
	public double getArea() {
		return length*width;
	}

	@Override
	public abstract double getPerimeter();


}
