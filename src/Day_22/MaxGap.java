package Day_22;

import java.util.Arrays;

/*
 * ����һ����������飬�ҳ�����������֮������Ԫ��֮�����Ĳ�ֵ��
 * �������Ԫ�ظ���С�� 2���򷵻� 0��
 * https://leetcode-cn.com/problems/maximum-gap/
 * ����: [3,6,9,1]
 * ���: 3
 * ����: ������������ [1,3,6,9], ��������Ԫ�� (3,6) �� (6,9) ֮�䶼��������ֵ 3��
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
