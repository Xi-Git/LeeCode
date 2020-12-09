package Day_37;
/*
 * https://leetcode-cn.com/problems/permutations/
 * 46. 全排列
 */

import java.util.LinkedList;
import java.util.List;

class 变种 {
	List<List<Integer>> res = new LinkedList<>();

	public List<List<Integer>> permute(int[] nums) {
		// 记录「路径」
		LinkedList<Integer> track = new LinkedList<Integer>();
		backtrack(nums, track);
		return res;
	}

// 路径：记录在 track 中
// 选择列表：nums 中不存在于 track 的那些元素
// 结束条件：nums 中的元素全都在 track 中出现
	void backtrack(int[] nums, LinkedList<Integer> track) {
		// 触发结束条件
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