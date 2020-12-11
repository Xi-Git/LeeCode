package Day_31;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/***
 * https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/
 * 659. 分割数组为连续子序列
 * @author MyPC
 *
 */

public class IsPossible {
	public boolean isPossible(int[] nums) {
		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> endMap = new HashMap<Integer, Integer>();
		for (int x : nums) {
			int count = countMap.getOrDefault(x, 0) + 1;
			countMap.put(x, count);
		}
		for (int x : nums) {
			int count = countMap.getOrDefault(x, 0);
			if (count > 0) {
				int prevEndCount = endMap.getOrDefault(x - 1, 0);
				if (prevEndCount > 0) {
					countMap.put(x, count - 1);
					endMap.put(x - 1, prevEndCount - 1);
					endMap.put(x, endMap.getOrDefault(x, 0) + 1);
				} else {
					int count1 = countMap.getOrDefault(x + 1, 0);
					int count2 = countMap.getOrDefault(x + 2, 0);
					if (count1 > 0 && count2 > 0) {
						countMap.put(x, count - 1);
						countMap.put(x + 1, count1 - 1);
						countMap.put(x + 2, count2 - 1);
						endMap.put(x + 2, endMap.getOrDefault(x + 2, 0) + 1);
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}

	public boolean isPossible3(int[] nums) {
		if (nums.length <= 2)
			return false;
		int[] rec = new int[nums.length / 3 + 1];
		int recHead = 0, recTail = 1;
		int recIndex = 0;
		rec[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				if (recIndex != recTail - 1) {
					rec[recIndex--]++;
					if (recIndex < recHead)
						recIndex = recTail - 1;
				} else if (recTail >= rec.length) {
					return false;
				} else {
					rec[recTail] = 1;
					recIndex = (++recTail) - 1;
				}
			} else if (nums[i] != nums[i - 1] + 1) {
				for (int j = recHead; j < recTail; j++) {
					if (rec[j] < 3) {
						return false;
					}
				}
				return isPossible(Arrays.copyOfRange(nums, i, nums.length));
			} else if (recIndex == recTail - 1) {
				rec[recIndex--]++;
				if (recIndex < recHead)
					recIndex = recTail - 1;
			} else {
				while (recHead != recIndex + 1) {
					if (rec[recHead] < 3) {
						return false;
					}
					recHead++;
				}
				recIndex = recTail - 1;
				rec[recIndex--]++;
				if (recIndex < recHead) {
					recIndex = recTail - 1;
				}
			}
		}
		for (int j = recTail - 1; j >= recHead; j--) {
			if (rec[j] < 3)
				return false;
		}
		return true;
	}

	//测试中发现nums元素值都在正负10000以内
    public boolean isPossible2(int[] nums) {
        int[] counts = new int[20000];
        int[] need = new int[20000];

        for (int i = 0; i < nums.length; i ++) {
            //将所有负数转为正数
            nums[i] += 10000;
            counts[nums[i]] ++;
        }

        for (int n : nums) {
            if (counts[n] == 0) continue;

            if (need[n] > 0){
                need[n] --;
                need[n + 1] ++;
            } else if (counts[n + 1] > 0 && counts[n + 2] > 0){
                counts[n + 1] --;
                counts[n + 2] --;
                need[n + 3] ++;
            } else return false;
            counts[n] --;
        }
        return true;
    }

}
