
public class Employee extends Person {
	private String jobTitle;

	public Employee(String firstName, String lastName, String address, int id, String jobTitle) {
		super(firstName, lastName, address, id);
		this.jobTitle = jobTitle;
	}
	
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public String getJobTitle() {
		return jobTitle;
	}
	
	@Override
	public void display() {
		System.out.print("Name: " +  getFirstName() + " " + getLastName() + " \n Address: " +  getAddress() + "\n ID:" + id
				+ "\n JOb title: " + jobTitle);
	}

}
