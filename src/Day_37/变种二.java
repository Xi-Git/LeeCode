package Day_37;

import java.util.Arrays;
/*
 * https://leetcode-cn.com/problems/permutations-ii/
 * 47. ȫ���� II
 * ����һ���ɰ����ظ����ֵ����� nums ��������˳�� �������в��ظ���ȫ���С�
 */
import java.util.LinkedList;
import java.util.List;
/**
 * https://leetcode-cn.com/problems/permutations-ii/
 * 47. ȫ���� II
 * @author MyPC
 *
 */
public class ���ֶ� {
	public static void main(String[] args) {
		int[] nums = new int[] {1,1,1,2};
		permuteUnique(nums);
	}
	
	
	static List<List<Integer>> res = new LinkedList<>();

	public static List<List<Integer>> permuteUnique(int[] nums) {
		LinkedList<Integer> track = new LinkedList<>();
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		backtrack(nums, track, used);
		return res;
	}

	static void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
		if (track.size() == nums.length) {
			res.add(new LinkedList<Integer>(track));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if(used[i]) {
				continue;
			}
			if (i >= 1 && nums[i - 1] == nums[i] && used[i-1] ) {
				continue;
			}
			if (used[i] == false) {
				used[i] = true;
				track.add(nums[i]);
				backtrack(nums, track, used);
				track.removeLast();
				used[i] = false;
			}

		}
	}
}
