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
	
	
	
	public void main(String[] args) {
		
		BankCustomer one = new BankCustomer();
		
		one.setAccountNumber(123456);
		one.setName("Hannah Foley");
		one.setAddress("64 beach road");
		one.setDateOfBirth("February 5th");
	}
		
		
		
		public static void switchAccountNumbers(int accountNumber1, int accountNumber2)
		{
			accountNumber1 += accountNumber2;
			accountNumber2 = accountNumber1 - accountNumber2;
			accountNumber1 = accountNumber1 - accountNumber2;
		}


}
