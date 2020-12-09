package Day_37;
/*
 * https://leetcode-cn.com/problems/permutations/
 * 46. ȫ����
 */

import java.util.LinkedList;
import java.util.List;

class ���� {
	List<List<Integer>> res = new LinkedList<>();

	public List<List<Integer>> permute(int[] nums) {
		// ��¼��·����
		LinkedList<Integer> track = new LinkedList<Integer>();
		backtrack(nums, track);
		return res;
	}

// ·������¼�� track ��
// ѡ���б�nums �в������� track ����ЩԪ��
// ����������nums �е�Ԫ��ȫ���� track �г���
	void backtrack(int[] nums, LinkedList<Integer> track) {
		// ������������
		if(track.size() == nums.length) {
			res.add(track);
			return;
		}
		
		for(int i =0 ;i< nums.length ;i++) {
			if(track.contains(nums[i])) {
				continue;
			}
			track.add(nums[i]);
			backtrack(nums, track);
			track.removeLast();
		}

	}
}