
public class Order {
	private int orderID;
	private Item orderedItem;
	private int orderDate;
	
	public Order (Item orderedItem)
	{
		this.orderedItem = orderedItem;
		orderDate = 3;
	}
	
	public int getOrderID()
	{
		return orderID;
	}
	
	public void setOrderID(int orderID)
	{
		this.orderID = orderID;
	}
	
	public int getOrderDate()
	{
		return orderDate;
	}
	
	public void setOrderDate(int orderDate)
	{
		this.orderDate = orderDate;
	}
		
	public Item getOrderedItem()
	{
		return orderedItem;
	}
	
	public void setOrderedItem(Item orderedItem)
	{
		this.orderedItem = orderedItem;
	}

}
