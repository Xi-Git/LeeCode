package Day_22;

import java.util.Arrays;

/*
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * 如果数组元素个数小于 2，则返回 0。
 * https://leetcode-cn.com/problems/maximum-gap/
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 */

public class MaxGap {
    public int maximumGap(int[] nums) {
    	int len = nums.length;
    	if( len < 2) {
    		return 0;
    	}
    	Arrays.sort(nums);
    	int[] tmp = new int[len-1];
    	for(int i=0;i<len;i++) {
    		if(i==0) {
    			continue;
    		}
    		tmp[i-1] = nums[i]-nums[i-1];
    	}
    	Arrays.sort(tmp);
		return tmp[len-1];
    }
}
