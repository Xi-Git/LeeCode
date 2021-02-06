package Day_65;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

/**
 * 二叉查找树（Binary Search Tree），
 * （又：二叉搜索树，二叉排序树）它或者是一棵空树，
 * 或者是具有下列性质的二叉树： 
 * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 
 * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 
 * 它的左、右子树也分别为二叉排序树。
 * 
 * 
 * 
 * 性质：二叉搜索树的中序遍历为 递增序列 。
 * 根据以上性质，易得二叉搜索树的 中序遍历倒序 为 递减序列 。
 * 因此，求 “二叉搜索树第 kk 大的节点” 可转化为求 “此树的中序遍历倒序的第 kk 个节点”。
 * 
 * 既本题可以不排序，直接便利到第k个节点就可以完成
 * @author GitMars
 *
 */

public class KthLargest {

	public int kthLargest(TreeNode root, int k) {
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode tmp = stack.pop();
			list.add(tmp.val);

			if (tmp.right != null) {
				stack.push(tmp.right);
			}

			if (tmp.left != null) {
				stack.push(tmp.left);
			}
		}
		Comparator<Integer> c = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
		};
		list.sort(c);
		System.out.println(list.toString());
		return list.get(k);

	}
}
