package Day_19;


/* Definition for a binary tree node.*/
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
public class Nodes {
	
	//解法一：常规递归解法
    public int countNodes(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	return 1+countNodes(root.left)+countNodes(root.right);
    }
    //解法二
    public int countNodes2(TreeNode root) {
        if(root == null){
           return 0;
        } 
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if(left == right){
            return countNodes2(root.right) + (1<<left);
        }else{
            return countNodes2(root.left) + (1<<right);
        }
    }
    private int countLevel(TreeNode root){
        int level = 0;
        while(root != null){
            level++;
            root = root.left;
        }
        return level;
    }
}
