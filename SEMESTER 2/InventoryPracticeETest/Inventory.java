import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Inventory {
	ArrayList <Item> items = new ArrayList<Item>();
	ArrayList <Order> orders = new ArrayList<Order>();
	
	public void addItem(String itemName, double itemPrice, int itemQuantity)
	{
		boolean added = false;
		ArrayList <Item> tempItems = new ArrayList<Item>();
		for (Item item: items)
		{
			tempItems.add(item);
		}
		if (tempItems.size() != 0)
		{
			for (Item item: tempItems)
			{
				while (!added)
				{
					if (!item.getName().equalsIgnoreCase(itemName))
					{
						if (item.getPrice() != itemPrice)
						{
							long id = ThreadLocalRandom.current().nextLong(100);
							Item newItem = new Item(id, itemName, itemPrice, itemQuantity);
							items.add(newItem);
							added = true;
						}
						else
						{
							System.out.print("Item already added ");
						}
					}
					else
					{
						System.out.print("Item with same name already added ");
					}
				}
			}
		}
		else
		{
			long id = ThreadLocalRandom.current().nextLong(100);
			Item newItem = new Item(id, itemName, itemPrice, itemQuantity);
			items.add(newItem);
		}
	}
	
	public void createOrder(Item item)
	{
		Order newOrder = new Order (item);
		orders.add(newOrder);
	}
	
	public static void main(String[] args)
	{
		/*a. Create an instance of class Inventory
		  b. Ask the user how many items he/she would like to create and ask the user for the item
			 name, price and quantity for each.
		  c. Initialise the items collection and add each item to it by calling the addItem method.
		  d. Create an order for each item by calling the createOrder method.*/
		Inventory inventory = new Inventory();
		
		boolean ready = false;
		while (!ready)
		{
		System.out.print("How many items would you like to create? ");
		Scanner scanner = new Scanner (System.in);
			if (scanner.hasNextInt())
			{
				int input = scanner.nextInt();
				ready = true;
				for (int i = 0; i < input; i++)
				{
					System.out.print("Please enter name of the item that you wish to add ");
					String itemName = scanner.next();
					System.out.print("Please enter price of the item that you wish to add ");
					double itemPrice = scanner.nextDouble();
					System.out.print("Please enter quantity of the item that you wish to add ");
					int itemQuantity = scanner.nextInt();
					inventory.addItem(itemName, itemPrice, itemQuantity);
					inventory.createOrder(inventory.items.get(i));
					System.out.print("Item added and order created! " + (i!=input-1 ? "Let's move onto your next item! " : "All done!"));
				}
				for (int i = 0; i < inventory.items.size(); i++)
				{
					System.out.println("Item number " + i+1);
					System.out.println("Item name: " + inventory.items.get(i).getName());
					System.out.println("Item price: $" + inventory.items.get(i).getPrice());
					System.out.println("Item quantity: " + inventory.items.get(i).getQuantity());
					System.out.println("Item ID: " + inventory.items.get(i).getId());
				}
			
			}
			else
			{
				System.out.println("Please enter a number ");
			}
		}
	}
}
