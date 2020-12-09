package Day_11;
import java.util.Stack;
/**
 * https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
 * ʵ��һ���㷨���ҳ����������е����� k ���ڵ㡣���ظýڵ��ֵ��
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
	
	//�ⷨһ�������ⷨ
	public int kthToLast(ListNode head, int k) {
		int count = 0;
		ListNode cur = head;
	    while (cur != null && cur.next!=null){
	    	   count ++ ;
	    	   cur = cur.next;
	    }
//	    System.out.println(count);
	    int tmp = count - k + 1;		//����ֻ�����������ڶ����ڵ㣬�ǵü�һ
	    
	    for(int i=0;i<tmp;i++){
	    	cur = cur.next;
	    }
	    return cur.val;
	}
	
	// �ⷨ���� ˫ָ��ⷨ������ָ��֮�����n��λ��
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

	//�ⷨ���� ʹ��ջ��ʵ��
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
	
		//�ⷨ�ģ��ݹ�ʵ��
	    //ȫ�ֱ�������¼�ݹ������ߵ�ʱ����ʵĽ������
	    int size;

	    public int kthToLast_4(ListNode head, int k) {
	        //�߽������ж�
	        if (head == null)
	            return 0;
	        int val = kthToLast(head.next, k);
//	        ++size;
//	        //�Ӻ����������С��k�����ؿ�
//	        if (size < k) {
//	            return 0;
//	        } else if (size == k) {
//	            //�Ӻ��������ʽ�����k��ֱ�ӷ��ش��ݵĽ��k����
//	            return head.val;
//	        } else {
//	            //�Ӻ��������ʵĽ�����k��˵�������Ѿ��ҵ��ˣ�
//	            //ֱ�ӷ���node����
//	            return val;
//	        }
	        if (++size == k)
	            return head.val;
	        return val;
	    }
}
