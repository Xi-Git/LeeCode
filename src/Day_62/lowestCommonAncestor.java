package Day_62;
/*
 * ����û����������һ��
 * ��ָ Offer 68 - II. �������������������
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
	        if(root == p || root == q)			//����p��q�Լ�Ϊ���
	            return root;
	            
	        TreeNode left = lowestCommonAncestorTest(root.left,p,q);
	        TreeNode right = lowestCommonAncestorTest(root.right,p,q);

	        if(left == null){
	            return right;		//�����������Ƿ��ҵ�p��q
	        }else if(right == null){
	            return left;		//�����������Ƿ��ҵ�p��q
	        }else{
	            return root;		//���Ҷ���Ϊ����p��q�ڸ��ڵ���������ߣ������ڵ�Ϊ���
	        }
	    }
}
