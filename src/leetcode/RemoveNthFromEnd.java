package leetcode;

/**
 * @author Chen Lin
 * @date 2021-09-14
 */

public class RemoveNthFromEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveNthFromEnd instance = new RemoveNthFromEnd();
		System.out.println(instance.removeNthFromEnd(new ListNode(5), 1).val);
	}
	public ListNode removeNthFromEnd(ListNode head, int n ) {
		if (head == null) return head;
		if(head.next == null) return null;
		ListNode slow = head, fast = head;
		for(int i = 0; i<n-1; i++) {
			fast = fast.next;	
		}
		if(fast.next == null) return head.next;			
		fast = fast.next;
		while(fast.next !=null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next =slow.next.next;
		return head;
		
		
	}

}
