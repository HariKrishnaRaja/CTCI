import java.util.Set;
import java.util.HashSet;

class LinkedList{
	public Node head = null;
	class Node{
		int data;
		Node next;
		
		public Node(){
			
		}
		
		public Node(int data){
			this.data = data;
			this.next = null;
		}
		
		public void setData(int data){
			this.data = data;
		}
		
		public int data(){
			return this.data;
		}
		
		public void setNext(Node next){
			this.next = next;
		}
		
		public Node next(){
			return this.next;
		}
		
	}
	
	public void addFirst(int data){
		Node n = new Node(data);
		if (head != null){
			n.setNext(this.head);
		}
		this.head = n;
	}
	
	public void addLast(int data){
		Node n = head;
		while(n.next() != null){
			n = n.next();
		}
		n.setNext(new Node(data));
		
	}
	
	public void printList(){
		Node n = head;
		while(n != null){
			System.out.print(n.data()+"-->");
			n = n.next();
		}
	}
	
	
}

public class RemoveDups{
	
	static LinkedList l = new LinkedList();
	
	public static void main(String[] args){
		l.addFirst(5);
		l.addFirst(4);
		l.addFirst(3);
		l.addFirst(2);
		l.addFirst(1);
		l.addFirst(4);
		l.addLast(6);
		l.addLast(6);
		l.addFirst(4);
		
		l.printList();
		
		removeDuplicates2(l);
		System.out.println("List After Removing duplicates");
		l.printList();
		
		
	}
	
	
	/*Time complexity - O(n)
	 *Space complexity - O(n)
	 */
	public static void removeDuplicates(LinkedList l){
		if(l == null || l.head == null || l.head.next() == null)
			return;
		Set<Integer> elements = new HashSet<Integer>();
		
		LinkedList.Node tortoise2 = l.head.next();
		LinkedList.Node tortoise1 = l.head;
		
		elements.add(tortoise1.data());
		
		while (tortoise2 != null){
			if(elements.contains(tortoise2.data())){
				tortoise1.setNext(tortoise2.next);
			}else{
				elements.add(tortoise2.data);
				tortoise1 = tortoise1.next();
			}
				
			tortoise2= tortoise2.next();
		}
		
	}
	
	/*Time complexity - O(n ^ 2)
	 *Space complexity - O(1)
	 */
	public static void removeDuplicates2(LinkedList l){
		if(l == null || l.head == null || l.head.next() == null)
			return;
		LinkedList.Node tortoise1 = l.head;
		
		while(tortoise1 != null){
			LinkedList.Node tortoise2 = tortoise1;
			LinkedList.Node tortoise3 = tortoise2.next();
			
			while(tortoise3 !=null ){
				if(tortoise1.data == tortoise3.data){
					tortoise2.setNext(tortoise3.next());
				}
				else{
					tortoise2 = tortoise2.next();
				}
				tortoise3 = tortoise3.next();
			}
			tortoise1 = tortoise1.next();
			
		}
		
	}
	
}
