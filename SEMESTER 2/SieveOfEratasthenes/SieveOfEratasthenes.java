/* SELF ASSESSMENT 
   1.    createSequence:
   Did I use the correct method definition?
   Mark out of 5: 5
   Comment: My methods has the given name from the assignment outline, I've also used the return type int [] as it 
            returns an int array. I have passed parameter with the same name as it is defined in the outline into the
            method. Beside all the methods I included a comment which describes what the method does.
   Did I create an array of size n (passed as the parameter) and initialise it?
   Mark out of 5: 5
   Comment: I created the array of the size of the maximum number that was taken in as input. I passed this number as
            a parameter. I initialised it by putting the values up to the maximum number in the array element spaces.
   Did I return the correct item?
   Mark out of 5: 5
   Comment: The outline says it should return an int array, which it does.
   
   2.    crossOutMultiples
	Did I use the correct method definition?
	Mark out of 5: 5	
	Comment: Yes my method has the name outlined in the outline. It is of the return type void which also is in line 
			 with the assignment outline. I have passed parameter with the same name as it is defined in the outline into the
             method. Beside all the methods I included a comment which describes what the method does.
	Did I ensure the parameters are not null and one of them is a valid index into the array
	Mark out of 2: 2
	Comment: Yes it checks the number is a valid index of the array (between 0 and array.length) and it checks that the
			 array passed in is not null
	Did I loop through the array using the correct multiple?
	Mark out of 5: 5
	Comment: The integer passed in as a paramter is the correct multiple and I used that to loop through
	Did I cross out correct items in the array that were not already crossed out?
	Mark out of 3: 3
	Comment: Yes this method only crosses out numbers that aren't prime and will skip over a number if it has already been 
			 defined as not a prime
   
   3.    sieve   
	Did I have the correct function definition?
	Mark out of 5: 5
	Comment: Yes my method has the name outlined in the outline. It is of the return type int array which also is in line 
			 with the assignment outline. I have passed parameter with the same name as it is defined in the outline into the
             method. Beside all the methods I included a comment which describes what the method does.
	Did I make calls to other methods?
	Mark out of 5: 5
	Comment: Yes it calls to create sequence and cross out higher multiples as it should return an int array in which the non
	         prime numbers have been crossed out    
	Did I return an array with all non-prime numbers are crossed out?
	Mark out of 2: 2
	Comment: Yes it return what is required
  
   4.    sequenceTostring  
	Did I have the correct function definition?
	Mark out of 5: 5
	Comment: Yes my method has the name outlined in the outline. It is of the return type string which also is in line 
			 with the assignment outline. I have passed parameter with the same name as it is defined in the outline into the
             method. Beside all the methods I included a comment which describes what the method does.
	Did I ensure the parameter to be used is not null?
	Mark out of 3:3
	Comment: Yes it checks the array is not null before carrying out the function of the method
	Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets? 
	Mark out of 10: 10
	Comment: Yes it adds the new value and brackets (if not prime) at each iteration through the array

   5.    nonCrossedOutSubseqToString  
	Did I have the correct function definition
	Mark out of 5: 5
	Comment: Yes my method has the name outlined in the outline. It is of the return type string which also is in line 
			 with the assignment outline. I have passed parameter with the same name as it is defined in the outline into the
             method. Beside all the methods I included a comment which describes what the method does.       
	Did I ensure the parameter to be used is not null?  
	Mark out of 3: 3
	Comment: Yes, if array is null , it returns an empty string
	Did I loop through the array updating the String variable with just the non-crossed out numbers? 
	Mark out of 5: 5
	Comment: Yes it adds the new value (if prime) at each iteration through the array
 
   6.    main  
	Did I ask  the user for input n and handles input errors?  
	Mark out of 5: 5
	Comments: Yes it asks for inputs and only accepts integers above  or equal to 2. If given anything else
	 		it prints invalid input and loops back again asking to enter a number again
	Did I make calls to other methods (at least one)?
	Mark out of 5: 5
	Comment:  yes it calls to sieve and nonCrossedOutSubseqToString
	Did I print the output as shown in the question?  
	Mark out of 5: 5
	Comment:  yes, the number string outputs are the same, but not the text requesting number as i wanted mine to
	          en when the user enters quit 
   
   7.    Overall
	Is my code indented correctly?
	Mark out of 4: 4
	Comments: Yes my code follows the indentation outlined in the coding standard from last semester which I assume
	 		carries over
	Do my variable names make sense?
	Mark out of 4: 4
	Comments: Yes I used meaningful variable names which could be understood by someone else reading my code
 	Do my variable names, method names and class name follow the Java coding standard
	Mark out of 4: 4
	Comments: yes my code follows standard outlined in the coding standard
      
      Total Mark out of 100 (Add all the previous marks): 100
*/


import java.util.Scanner;

public class SieveOfEratasthenes {

	public static void main(String[] args) {
		 boolean quit = false;
		 do 
		 {
			System.out.print("Enter an integer greater than or equal to 2 or enter 'quit': ");
			Scanner input = new Scanner (System.in);
    
			 if (input.hasNextInt())
			 {
				 int N = input.nextInt();
				 int [] listOfAllNumberObjects = sieve(N);       
				 System.out.println(nonCrossedOutSubseqToString(listOfAllNumberObjects));
			 }
			 else if (input.hasNext("quit"))
			 {
				 System.out.print("Goodbye!");
				 quit = true;
			 }
			 else
			 {
				 System.out.println("Invalid input. ");
				 input.next();
			 }
		 } while(!quit);
		 
	}
	
	public static int[] sieve (int maxNumber) //returns the sequence where all non primes have been crossed out
	{
		int[] listOfAllNumbers = createSequence(maxNumber);
		for (int counter = 0; counter < listOfAllNumbers.length; counter++)
		{
			int n = listOfAllNumbers[counter];
			// n should only be the numbers which were not already crossed off
			//so if n is not prime (== -1) we can skip onto next index
			if (n != -1)
			{
			crossOutHigherMultiples(listOfAllNumbers, n);
			}
		}
		return listOfAllNumbers;
	}
	
	public static int[] createSequence (int N) //returns an array with the sequence of numbers from 2 to N
	{
		int maxNumber = N;
		int currentNumberInSequence = 2;
	    int [] listOfNumbers = new int [maxNumber-1];
	    for (int index = 0; index < listOfNumbers.length; index++)
	    {
	    	//set default of numbers to all be prime(not -1), so they print without brackets when passed 
	    	listOfNumbers[index] = currentNumberInSequence;
	    	currentNumberInSequence++;
	    }
	    String fullListOfNumbers = sequenceToString(listOfNumbers);
        System.out.println(fullListOfNumbers);
		return listOfNumbers;
	}
	
	public static String sequenceToString (int [] array) //returns string where non primes are crossed out using 
	// square brackets
	{
		String listOfNumbers = "";
		//checking array is not null
		if (array != null)
		{
			for (int index = 0; index < array.length; index++)
			{
				int currentNumber = array[index];
				if (currentNumber == -1)         //ie is not prime, brackets will be added
				{
					int actualNumber = index+2;  //have to do this because the element is -1, so index+2 will give the true value
					listOfNumbers += ", [" + actualNumber + "]";
				}
				else
				{
					if (index > 0)
					{
						listOfNumbers += ", " ;
					}
					listOfNumbers += array[index];
				}
			}
		}
		return listOfNumbers;

	}
	
	public static void crossOutHigherMultiples(int[] listOfNumbers, int n) //crosses out all higher 
	//multiples of n from the sequence
	{
		//checking for validity
		if ((listOfNumbers != null) && (n>=0) && (n<listOfNumbers.length))
		{
			int maximumNumber = listOfNumbers.length+1;
			int multiplyBy = 2;
			int currentMultiple = n*multiplyBy;
		
			while (currentMultiple <= maximumNumber)
			{
				//find this number in the sequence and make it not Prime by changing it's value to -1
				for (int index = 0; index < listOfNumbers.length; index++)
				{
					int currentNumber = listOfNumbers[index];
					if (currentNumber != -1)        //if it's already defined as not prime, we dont need to redefine as not prime again
					{
						if (currentNumber == currentMultiple)
						{
							listOfNumbers[index] = -1; 
						} 
					}
				}
				multiplyBy++; 
				currentMultiple = n*multiplyBy;
			}
			System.out.println(sequenceToString(listOfNumbers));
		
		}
	}
	
	public static String nonCrossedOutSubseqToString (int [] array) // returns string containing primes only, last line of output
	{
		String primesOnly = "";
		//checking array is not null
		if (array != null)
		{
			for (int index = 0; index < array.length; index++)
			{
				int element = array[index];
				if (element != -1)
				{
					primesOnly += (index>0 ? ", " : "") + element;
				}
			}
		}
		return primesOnly;
	}
}
