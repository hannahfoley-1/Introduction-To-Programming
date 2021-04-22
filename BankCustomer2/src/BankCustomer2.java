public class BankCustomer {
	
	private int customerAccountNumber;
	private String customerName;
	private String customerAddress;
	private String customerDateOfBirth;
	
	public int getAccountNumber ()
	{
		return customerAccountNumber;
	}
	
	public void setAccountNumber (int accountNumber1)
	{
		customerAccountNumber = accountNumber1;
	}
	
	public String getName ()
	{
		return customerName;
	}

	public void setName(String name)
	{
		customerName = name;
	}
	
	public String getAddress ()
	{
		return customerAddress;
	}
	
	public void setAddress (String address)
	{
		customerAddress = address;
	}
	
	public String getDateOfBirth ()
	{
		return customerDateOfBirth;
	}
	
	public void setDateOfBirth (String dob)
	{
		customerDateOfBirth = dob;
	}
}
	
public class bankCustomerArray {
	
	public void main(String[] args) {
		BankCustomer [] customerArray = null;
		
		BankCustomer customer1 = new BankCustomer();
		customer1.setAccountNumber(12345678);
		customer1.setAddress("123 house");
		customer1.setName("Hannah");
		customer1.setDateOfBirth("18th July");
		
		
		BankCustomer [] tempArray = new BankCustomer[customerArray.length+1];
		tempArray[tempArray.length] = customer1;
		System.arraycopy(customerArray, 0, tempArray, 0, customerArray.length);
		customerArray = tempArray;
		
		System.out.print("Customer account number is " + customerArray[0].getAccountNumber());
	
	}
}

