
public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		
		ll.add(3);
		System.out.println("Linked List size: " + ll.size());
		for (int i = 0; i < ll.size(); i++) {
			Node currentNode = ll.get(i);
			int nodeValue = currentNode.getData();
			System.out.println("Element " + i + " = " + nodeValue);
		}
		
		ll.add(4);
		System.out.println("Linked List size: " + ll.size());
		for (int i = 0; i < ll.size(); i++) {
			Node currentNode = ll.get(i);
			int nodeValue = currentNode.getData();
			System.out.println("Element " + i + " = " + nodeValue);
		}
		
		ll.insert(1, 5);
		System.out.println("Linked List size: " + ll.size());
		for (int i = 0; i < ll.size(); i++) {
			Node currentNode = ll.get(i);
			int nodeValue = currentNode.getData();
			System.out.println("Element " + i + " = " + nodeValue);
		}
		
		ll.remove(1);
		System.out.println("Linked List size: " + ll.size());
		for (int i = 0; i < ll.size(); i++) {
			Node currentNode = ll.get(i);
			int nodeValue = currentNode.getData();
			System.out.println("Element " + i + " = " + nodeValue);
		}
		
		ll.add(11);
		System.out.println("Linked List size: " + ll.size());
		for (int i = 0; i < ll.size(); i++) {
			Node currentNode = ll.get(i);
			int nodeValue = currentNode.getData();
			System.out.println("Element " + i + " = " + nodeValue);
		}
		
		ll.insert(0, 59);
		System.out.println("Linked List size: " + ll.size());
		for (int i = 0; i < ll.size(); i++) {
			Node currentNode = ll.get(i);
			int nodeValue = currentNode.getData();
			System.out.println("Element " + i + " = " + nodeValue);
		}

	}

}
