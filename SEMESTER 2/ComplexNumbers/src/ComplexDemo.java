
public class ComplexDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Complex number1 = new Complex(5, 2);
		System.out.println(number1.toString());
		Complex number2 = new Complex(7,3);
		System.out.println(number2.toString());
		
		Complex numbersAdd = new Complex();
		System.out.print("The two complex numbers added gives : ");
		System.out.println(numbersAdd.add(number1, number2).toString());
		
		Complex numbersMul = new Complex();
		System.out.print("The two complex numbers multiplied gives : ");
		System.out.println(numbersMul.multiply(number1, number2).toString());
		
		Complex numbersDiv = new Complex();
		System.out.print("The two complex numbers divided gives : ");
		System.out.print(numbersDiv.divide(number1, number2).toString());
		
	}

}
