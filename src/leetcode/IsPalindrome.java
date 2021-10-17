package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chen Lin
 * @date 2021-08-07
 */

public class IsPalindrome {
	
	public static void main(String[] args) {
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(1);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;	
		
		IsPalindrome instance = new IsPalindrome();
		System.out.println(instance.isPalindrome(node1));
		
	}

	private boolean isPalindrome(ListNode head) {
		
		if(null == head) {
			return true;
		}
		
		ListNode workNode = head;
		List<ListNode> list = new ArrayList<ListNode>();
		
		//填充list
		while(null != workNode) {
			list.add(workNode);
			workNode = workNode.next;
		}
		
		workNode = head;
		for(int i = 0; i < list.size()/2 ; i++) {
			if(list.get(list.size()-i-1).val != workNode.val) {
				return false;
			}
			workNode = workNode.next;
		}
		
		return true;	
	}

}
