package Day_52;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


 class TreeNode {
     int val;
     TreeNode left;
    TreeNode right;
   TreeNode(int x) { val = x; }
 }
 
public class ZigzagLevelOrder {
	List<List<Integer>> list = new ArrayList<List<Integer>>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	bfs(root);
		return list;
    }
    public void bfs(TreeNode root) {
    	if(root == null) {
    		return;
    	}
    	List<TreeNode> treetmp = new ArrayList<TreeNode>();
    	boolean flag = true;
    	treetmp.add(root);
    	while( treetmp.size() != 0) {
        	Deque<Integer> listtmp = new LinkedList<>(); //´æÊý×Ö
            int a = treetmp.size();
        	for(int i=0;i<a;i++) {
    			TreeNode cur = treetmp.remove(0);
        		if(flag) {
        			listtmp.offerLast(cur.val);
        		}else {
        			listtmp.offerFirst(cur.val);
        		}
        		if(cur.left != null) {
        			treetmp.add(cur.left);
        		}
        		if(cur.right != null) {
        			treetmp.add(cur.right);
        		}
        	}
        	list.add(new LinkedList<>(listtmp));
        	flag = !flag;
    	}
    	
    }
}