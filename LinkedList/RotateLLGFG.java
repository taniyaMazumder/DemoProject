// rotate a list by left side by K times

package LinkedList;

public class RotateLLGFG {
 
	class Node {
		int data;
		Node next;
		
		public Node(int val) {
			this.data = data;
		}
	}
	public static Node rotateLeft(Node head, int k) { // 4->5>6->1->2->3->null
													// 5->6->1->2->3->4=>null
		if(k ==0) {
			return head;
		}
		Node current = head;
		Node prev = null;
		int count =1;
		
		while(count <=k && current != null) {
			count++;
			prev = current;
			current = current.next;
		}
		
		if(current == null) {
			return head;
		}
		prev.next = null;
		Node newHead = current;
		while(current.next!= null) {
			current = current.next;
		}
		current.next = head;
		return newHead;
	}
}
