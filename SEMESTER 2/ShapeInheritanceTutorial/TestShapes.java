
public class TestShapes {

	public static void main(String[] args) {
		Square square = new Square ("red", 4);
		Triangle triangle = new Triangle("pink", 12, 3);

		System.out.println(square.getArea());
		System.out.println(triangle.toString());
	}

}
