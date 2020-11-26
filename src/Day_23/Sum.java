package Day_23;

/*
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 
 * 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */


// Definition for singly-linked list.
  class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class Sum {
	//解法一：强行解,过了1565个用例还有三个用例过不去
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        while((l1) != null) {
        	str1.append(l1.val);
        	l1 = l1.next;
        }
        while((l2) != null) {
        	str2.append(l2.val);
        	l2 = l2.next;
        }
        
       Long tmp1 = Long.parseLong(str1.reverse().toString());
       Long tmp2 = Long.parseLong(str2.reverse().toString());
       tmp1 = tmp2 + tmp1;
       StringBuilder str3 = new StringBuilder();
       str3.append(tmp1.toString());
       str3.reverse();
       ListNode l3 = new ListNode();
       ListNode head = l3;
       for(int i =0 ; i< str3.length() ; i++) {
    	   ListNode tmp = new ListNode();
    	   if(i == 0) {
    		   l3.val = Integer.parseInt(String.valueOf(str3.charAt(i)));
    	   }else{
       	   l3.next = tmp;
    	   tmp.val =Integer.parseInt(String.valueOf(str3.charAt(i)));
    	   l3 = tmp;
           }

       }
       return head;
    }
      
   
    //解法二：按位进行计算，注意进位和两个不一样高长度的链表处理方式
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
