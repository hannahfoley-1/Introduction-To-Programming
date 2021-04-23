
public class Student extends Person {
	private double gpa;

	public Student(String firstName, String lastName, String address, int id, double gpa) {
		super(firstName, lastName, address, id);
		this.gpa = gpa;
	}
	
	public double getGPA() {
		return gpa;
	}
	
	public void setGPA(double gpa) {
		this.gpa = gpa;
	}
	
	@Override
	public void display() {
		System.out.print("Name: " +  getFirstName() + " " + getLastName() + " \n Address: " +  getAddress() + "\n ID:" + id
				+ "\n GPA: " + gpa);
	}

}
