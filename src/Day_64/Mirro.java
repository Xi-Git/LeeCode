package Day_64;

import java.util.Stack;

import sun.reflect.generics.tree.Tree;

/*
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * 剑指 Offer 27. 二叉树的镜像
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
    	 * 将本题的Stack改为LinedList速度明显提升，这是因为
    	 * Stack是Vector下面的分支，利用数组实现，随机读取较好，本题
    	 * 只要对存储的数据尾部进行增删，所以使用LinedList的读取效率是
    	 * 远比Stack要好的。
    	 * 并且LinkedList是有实现类似栈的方法，所以本题使用LinedList是更优的
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
