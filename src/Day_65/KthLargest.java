package Day_65;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * ��ָ Offer 54. �����������ĵ�k��ڵ�
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
 * �����������Binary Search Tree����
 * ���֣���������������������������������һ�ÿ�����
 * �����Ǿ����������ʵĶ������� 
 * ���������������գ��������������н���ֵ��С�����ĸ�����ֵ�� 
 * ���������������գ��������������н���ֵ���������ĸ�����ֵ�� 
 * ������������Ҳ�ֱ�Ϊ������������
 * 
 * 
 * 
 * ���ʣ��������������������Ϊ �������� ��
 * �����������ʣ��׵ö����������� ����������� Ϊ �ݼ����� ��
 * ��ˣ��� �������������� kk ��Ľڵ㡱 ��ת��Ϊ�� �������������������ĵ� kk ���ڵ㡱��
 * 
 * �ȱ�����Բ�����ֱ�ӱ�������k���ڵ�Ϳ������
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
