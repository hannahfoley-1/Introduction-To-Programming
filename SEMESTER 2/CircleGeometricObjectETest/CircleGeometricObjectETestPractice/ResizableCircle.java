
public class ResizableCircle extends Circle implements Resizable{

	ResizableCircle(double radius) {
		super(radius);
	}

	@Override
	public void resize(int percent)
	{
		double resizePercent = (double)percent/(double)100;
		radius -= radius*resizePercent;
		
	}

}
