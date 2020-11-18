package Day_12;

import Day_11.ToLast.ListNode;

public class DeleteNode {

	/**
	 * https://leetcode-cn.com/problems/delete-middle-node-lcci/
	 * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	//  Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; 
		}
	}
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

}
