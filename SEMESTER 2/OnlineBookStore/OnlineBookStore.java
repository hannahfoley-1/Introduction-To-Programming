import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineBookStore
{
    public static int ISBN_INDEX = 0;
    public static int TITLE_INDEX = 1;
    public static int AUTHOR_INDEX = 2;
    public static int PUBLISHER_INDEX = 3;
    public static int PUBLISHER_YEAR_INDEX = 4;
    public static int QUANTITY_INDEX = 5;
    public static int PRICE_INDEX = 6;

    public static void main(String[] args) throws FileNotFoundException
    {
	ArrayList<Book> bookList = new ArrayList<Book>();
	try
	{
	    FileReader fileReader = new FileReader("C:\\Users\\hanna\\OneDrive\\Desktop\\books.txt");// Enter the entire path of the file if needed
	    BufferedReader bufferedReader = new BufferedReader(fileReader);  
	    boolean endOfFile = false;

	    while(!endOfFile)
	    {
                String bookLine = bufferedReader.readLine();
	        if (bookLine != null)
		{
	            String[] bookData = bookLine.split(", ");
	            String isbn = bookData[ISBN_INDEX];
	            String title = bookData[TITLE_INDEX];
	            String author = bookData[AUTHOR_INDEX];
	            String publisher = bookData[PUBLISHER_INDEX];
	            int publishYear = Integer.parseInt (bookData[PUBLISHER_YEAR_INDEX]);
	            int quantity = Integer.parseInt (bookData[QUANTITY_INDEX]);
	            double price = Double.parseDouble (bookData[PRICE_INDEX]);
	            Book book = new Book(isbn, title, author, publisher, publishYear, quantity, price);
	            bookList.add(book);

	         }
		 else
		 {
	            endOfFile = true;
	         }
	    }
	         bufferedReader.close();    
	         fileReader.close();
        } // End try 

	catch (FileNotFoundException e)
	{
	    e.printStackTrace();
	}
	catch (IOException e)
	{
	    e.printStackTrace();
	}

	// Uncomment the following lines once you have implemented the required methods
	printBookDetails(bookList);
	purchaseBook(bookList);
    }
    
    //This method is required to print (to the console) the details (isbn, title, author,
    // publisher, publish year, quantity and price) of each book in bookList
    public static void printBookDetails(ArrayList <Book> bookList ) throws FileNotFoundException
    {
    	for(int i = 0; i < bookList.size(); i++)
    	{
    		Book aBook = (Book) bookList.get(i);
    		System.out.print(aBook.toString());
    	}
    }
    
    //This method is required to return the Book object which has a title that matches the
    //title provided, otherwise it returns null. You can assume the titles in bookList are
    //unique
    public static Book getBook(ArrayList <Book> bookList, String title)
    {
    	Book aBook;
    	for (int i = 0; i < bookList.size(); i++)
    	{
    	    aBook = (Book) bookList.get(i);
    		String aBookTitle = aBook.getTitle();
    		if (title.equalsIgnoreCase(aBookTitle))
    		{
    			return aBook;
    		}
    	}
    	return null;
    }
    
    //This method is required to top-up the charge card with the amount specified
    public static void topUpCard(ChargeCard card, double amount)
    {
    	double funds = card.getFunds();
    	if (amount <= funds)
    	{
    		card.removeFunds(amount);
    	}
    	else
    	{
    		System.out.print("You do not have the sufficient funds to buy this book. ");
    	}
    }
    
    public static void purchaseBook(ArrayList <Book> bookList)
    {
    	//Ask the user to enter the funds (positive number) in his/her card. Use this amount
    	//to create and top-up a ChargeCard object.
    	System.out.print("Enter the funds on your card ");
    	Scanner input = new Scanner(System.in);
    	double funds = 0;
    	ChargeCard card = new ChargeCard();
    	
    	if (input.hasNextDouble())
    	{
    		funds = input.nextDouble();
    		while (funds < 0)
    		{
    			System.out.print("Please enter a positive number" );
    			funds = input.nextDouble();
    			
    		}
    	    if (funds > 0)
    		{
    			card.setFunds(funds);
    		}	
    	}
    	else
    	{
    		System.out.print("Please enter a number ");
    		input.next();
    		funds = input.nextDouble();
			card.setFunds(funds);
    	}
    	
    	//Within a loop, ask the user to enter the book title he/she would like to purchase. Get
    	//the Book from the collection that matches this title. Ensure there is at least one copy
    	//of this book and sufficient funds in the card. What should happen to the quantity
    	//variable and the funds when a book has been purchased? Allow the user to make
    	//more purchases or quit
    	
    	boolean quit = false;
    	while (!quit)
    	{
    		System.out.print("Please enter the title of the book that you would like to buy:");
    		String bookEntered = input.next() + input.nextLine();
    		Book bookReturned = getBook(bookList, bookEntered);
    		
    		if (bookReturned == null)
    		{
    			System.out.println("Sorry, we don't have that book, please try another. ");
    		}
    		else
    		{
    			if (bookReturned.getQuantity() > 0)
    			{
    				if (card.getFunds() >= bookReturned.getPrice())
    				{
    					System.out.print("Please confirm purchase by typing 'confirm' ");
    					String confirmation = input.next();
    					if (confirmation.equalsIgnoreCase("confirm"))
    					{
    						card.removeFunds(bookReturned.getPrice());
    						bookReturned.setQuantity(bookReturned.getQuantity() - 1);
    						System.out.println("Your payment has been made, enjoy your book! ");
    					}
    					else
    					{
    						System.out.println("Payment not confirmed. ");
    					}
    					System.out.print("Continue shopping by entering 'yes' or enter 'quit' to leave ");
    					String stop = input.next();
    					if (stop.equalsIgnoreCase("quit"))
    					{
    						quit = true;
    					}
    					else if (stop.equalsIgnoreCase("yes"))
    					{
    						quit = false;
    					}
    				}
    				else
    				{
    					System.out.println("Sorry, you cannot afford that book, please try another or enter 'quit' to leave ");
    					String stop = input.next();
    					if (stop.equalsIgnoreCase("quit"))
    					{
    						quit = true;
    					}
    				}
    				
    			}
    			else
    			{
    				System.out.println("Sorry, we don't have that book in stock, please try another or enter 'quit' to leave ");
    				String stop = input.next();
					if (stop.equalsIgnoreCase("quit"))
					{
						quit = true;
					}
    			}
    		}
    	
    		
    	}
    }
}