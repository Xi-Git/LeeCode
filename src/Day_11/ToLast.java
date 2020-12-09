package Day_11;
import java.util.Stack;
/**
 * https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * @param args
 */
public class ToLast {


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
	
	//解法一：正常解法
	public int kthToLast(ListNode head, int k) {
		int count = 0;
		ListNode cur = head;
	    while (cur != null && cur.next!=null){
	    	   count ++ ;
	    	   cur = cur.next;
	    }
//	    System.out.println(count);
	    int tmp = count - k + 1;		//上面只遍历到倒数第二个节点，记得加一
	    
	    for(int i=0;i<tmp;i++){
	    	cur = cur.next;
	    }
	    return cur.val;
	}
	
	// 解法二： 双指针解法，两个指针之间相差n个位置
	public int kthToLast_2(ListNode head, int k) {
		ListNode first = head,second = head;
		
		while (k-- >0){
			first = first.next;
		}
		
		while (first.next != null){
			first = first.next;
			second = second.next;
		}
		
		return second.val;
	}

	//解法三： 使用栈来实现
	public int kthToLast_3(ListNode head, int k){
		Stack<ListNode> s = new Stack<ListNode>();
		while( head != null){
			s.push(head);
		}
		ListNode firstNode = null;
		while(k-->0){
			firstNode = s.pop();
		}
		
		return firstNode.val;
	}
	
		//解法四：递归实现
	    //全局变量，记录递归往回走的时候访问的结点数量
	    int size;

	    public int kthToLast_4(ListNode head, int k) {
	        //边界条件判断
	        if (head == null)
	            return 0;
	        int val = kthToLast(head.next, k);
//	        ++size;
//	        //从后面数结点数小于k，返回空
//	        if (size < k) {
//	            return 0;
//	        } else if (size == k) {
//	            //从后面数访问结点等于k，直接返回传递的结点k即可
//	            return head.val;
//	        } else {
//	            //从后面数访问的结点大于k，说明我们已经找到了，
//	            //直接返回node即可
//	            return val;
//	        }
	        if (++size == k)
	            return head.val;
	        return val;
	    }
}
