package Day_10;
import java.util.HashSet;
/***
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * @author MyPC
 *
 */
// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
public class removeNodes {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}	
	public ListNode removeDuplicateNodes(ListNode head) {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		ListNode cur = head ;
		while( cur != null && cur.next != null ){
			hashSet.add(cur.val);
			if(hashSet.contains(cur.next.val)){
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		return head;		
	}

}
