import java.util.ArrayList;

public class Stack {
	static ArrayList<Integer> stack = new ArrayList<Integer>();
	
	
	//push function
	public static void push(int number)
	{
		ArrayList<Integer> tempStack = new ArrayList<Integer>();
		for (int i = 0; i < stack.size(); i++)
		{
			int currentElement = stack.get(i);
			tempStack.add(currentElement);
		}
		tempStack.add(0, number);
		stack = tempStack;
	}
	
	//pop function
	public Integer pop() 
	{
		if (stack.size() == 0)
		{
			System.out.print("ERROR: Empty array");
			return -1;
		}
		else
		{
			int poppedNo = stack.get(0);
			stack.remove(0);
			return poppedNo;
		}	
	}
	
	//peek function
	public Integer peek ()
	{
		if (stack.size() == 0)
		{
			System.out.print("ERROR: Empty array");
			return -1;
		}
		else
		{
			return stack.get(0);
		}	
	}
	
	//search for object in the stack, else return -1
	public int search(Integer number)
	{
		for (int i = 0; i < stack.size(); i++)
		{
			Integer stackElement = stack.get(i);
			if (stackElement == number)
			{
				return i;
			}
		}
		return -1;
	}
	
	//move method to move element to the top of the stack, without removing 
	//it from the stack
	public void move(Integer element)
	{
		int i = search(element);
		if (i != -1)
		{
			ArrayList<Integer> tempStack = new ArrayList<Integer>();
			for(int j = 0; j < i; j++)
			{
				int currentElement = stack.get(j);
				tempStack.add(currentElement);	
			}
			tempStack.add(0, element);
			
			for(int j = i+1; j < stack.size(); j++)
			{
				int currentElement = stack.get(j);
				tempStack.add(j, currentElement);
			}
			
			stack = tempStack;
		}
		else
		{
			System.out.print("ERROR: This element is not in the stack");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//will create a stack object with numbers from 1-10
		Stack stack = new Stack();
		for (int i = 1; i < 11; i++)
		{
			stack.push(i);
		}
		System.out.println(stack.stack);
		
		//using push, pop, peek, sort and move
		stack.push(11);
		System.out.println("Stack after pushing 11: " + stack.stack);
		
		stack.pop();
		System.out.println("Stack after popping " + stack.stack);
		
		int topOfStack = stack.peek();
		System.out.println("Top of stack element: " + topOfStack);
		
		stack.move(3);
		System.out.println("Stack after moving 3 " + stack.stack);
		
		//no user input, print out results 
		
	}

}
