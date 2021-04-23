import java.util.ArrayList;
 
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
	
	public String findCustomer(int accountNo, BankCustomer [] customerArray)
	{
	   //array circling through each account until you find the account that your looking for 
	
		for (int i = 0; i < customerArray.length; i++)
		{
			int currentAccNo = customerArray[i].getAccountNumber();
			if (currentAccNo == accountNo)
			{
				return customerArray[i].getName();
			}
			
		}
	    return "";	
	}
	
	public String findCustomer(ArrayList<BankCustomer> array, int accNo)
	{
		for(int i = 0; i < array.size(); i++)
		{
		  if (array.get(i).getAccountNumber() == accNo)
		  {
			  return array.get(i).getName();
		  } 
		}
        return "";
	}
	
	public String findCustomer(String DOB, String address, BankCustomer [] customerArray)
	{
		
		for (int i = 0; i < customerArray.length; i++)
		{
			String currentDOB = customerArray[i].getDateOfBirth();
			if (currentDOB == DOB)
			{
			    String currentAddress = customerArray[i].getAddress();
			    if (currentAddress == address)
			    {
			    	return customerArray[i].getName();
			    }
			}
			
		}
		return "";
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

public class bankCustomerArrayList {
	
	public void main(String[] args)
	{
		ArrayList<BankCustomer> customerArray = new ArrayList<BankCustomer>();	
		int accountNo = customerArray.get(0).getAccountNumber();
		customerArray.get(0).findCustomer(customerArray, accountNo);
	}
}


}
