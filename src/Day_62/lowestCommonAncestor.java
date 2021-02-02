package Day_62;
/*
 * 贼旧没做，今天来一题
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class lowestCommonAncestor {
	 public TreeNode lowestCommonAncestorTest(TreeNode root, TreeNode p, TreeNode q) {
	        if(root == null){
	            return null;
	        }
	        if(root == p || root == q)			//处理p或q自己为结果
	            return root;
	            
	        TreeNode left = lowestCommonAncestorTest(root.left,p,q);
	        TreeNode right = lowestCommonAncestorTest(root.right,p,q);

	        if(left == null){
	            return right;		//处理左子树是否找到p或q
	        }else if(right == null){
	            return left;		//处理右子树是否找到p或q
	        }else{
	            return root;		//左右都不为空则p和q在根节点的左右两边，即根节点为结果
	        }
	    }
}
