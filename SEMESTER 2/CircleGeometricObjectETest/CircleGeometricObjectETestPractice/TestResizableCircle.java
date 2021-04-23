
public class TestResizableCircle {

	public static void main(String[] args) {
		ResizableCircle circle = new ResizableCircle(100);
		System.out.printf("Perimeter of the circle is %.2f", circle.getPerimeter());
		System.out.printf("\nArea of the circle is %.2f", circle.getArea());
		circle.resize(10);
		System.out.printf("\nPerimeter of the circle is %.2f", circle.getPerimeter());
		System.out.printf("\nArea of the circle is %.2f", circle.getArea());

	}

}
