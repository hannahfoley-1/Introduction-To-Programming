public class LinkedList {
	private int listCount;
    private Node head;

    public LinkedList()
    {
        head = new Node();
        listCount = 0;
    }

    public void add(int data)
    {
        Node newNode = new Node(data);
        Node currentNode = head;

        while (currentNode.getNextNode() != null)
        {
            currentNode = currentNode.getNextNode();
        }

        currentNode.setNextNode(newNode);
        listCount++;
    }
    
    public void insert(int index, int data) {
    	Node newNode = new Node (data);
    	Node currentNode = head;
    	int nodeListIndex = 0;
    	
    	for (int i = nodeListIndex; i < index; i++)
    	{
    		currentNode = currentNode.getNextNode();
    	}
    	Node tempNode = currentNode.getNextNode();
    	currentNode.setNextNode(newNode);
    	currentNode = currentNode.getNextNode();
    	currentNode.setNextNode(tempNode);
    	listCount++;
    }
    
    public Node get(int index) {
        if (index > listCount || index <= 0) {
        	return null;
        }

    	Node currentNode = head;
    	for (int i = 0; i < index; i++) {
    		currentNode = currentNode.getNextNode();
    	}
    	return currentNode.getNextNode();
    }
    
    public void remove(int index) {
    	Node currentNode = head;
    	for (int i = 0; i < index - 2; i++) {
    		currentNode = currentNode.getNextNode();
    	}
    	currentNode.setNextNode(currentNode.getNextNode().getNextNode());
        listCount--;
    }
    
    public int size(){
    	return listCount;
    }

}
