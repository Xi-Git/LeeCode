package Day_64;

import java.util.Stack;

import sun.reflect.generics.tree.Tree;

/*
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * ��ָ Offer 27. �������ľ���
 */

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class Mirro {
    public TreeNode mirrorTree(TreeNode root) {
    	if( root == null ) {
    		return root;
    	}
    	/*
    	 * �������Stack��ΪLinedList�ٶ�����������������Ϊ
    	 * Stack��Vector����ķ�֧����������ʵ�֣������ȡ�Ϻã�����
    	 * ֻҪ�Դ洢������β��������ɾ������ʹ��LinedList�Ķ�ȡЧ����
    	 * Զ��StackҪ�õġ�
    	 * ����LinkedList����ʵ������ջ�ķ��������Ա���ʹ��LinedList�Ǹ��ŵ�
    	 * 
    	 */
    	
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	stack.push(root);
    	while( !stack.empty() ) {
    		TreeNode m = stack.pop();
    		
    		TreeNode tmp = m.left;
    		m.left = m.right;
    		m.right = tmp;
    		
    		if( m.left != null ) {
    			stack.push(m.left);
    		}
    		
    		if( m.right != null) {
    			stack.push(m.right);
    		}
    	}
    	return root;
    }
}
