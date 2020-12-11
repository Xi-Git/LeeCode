package Day_29;

import java.util.ArrayList;
/****
 * https://leetcode-cn.com/problems/create-maximum-number/
 * 321. ƴ�������
 * @author MyPC
 *
 */
public class MaxNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    	ArrayList<Integer> tmp1 = new ArrayList<Integer>();
    	ArrayList<Integer> tmp2 = new ArrayList<Integer>();
    	int len =0;
    	if(nums1.length > nums2.length) {
    		len = nums2.length;
    	}else {
    		len = nums1.length;
    	}
    	
    	for(int i=0;i<len;i++) {
    		if(nums1[i]>nums2[i]) {
    			tmp1.add(nums1[i]);
    		}else if(nums1[i]==nums2[i]){
    			tmp1.add(nums1[i]);
    			tmp2.add(nums2[i]);
    		}else {
    			tmp2.add(nums2[i]);
    		}
    	}
    	
    	if(nums1.length != len ) {
    		for(int i=len ;i<nums1.length;i++) {
    			tmp1.add(nums1[i]);
    		}
    	}
    	if(nums2.length != len ) {
    		for(int i=len ;i<nums2.length;i++) {
    			tmp1.add(nums2[i]);
    		}
    	}
    	

    	
		return nums2;
    }
    
    public int[] maxNumber2(int[] nums1, int[] nums2, int k) {
        int[] res = new int[0];
        // �� nums1 ��ѡ���� i ��������
        for (int i = 0; i <= k && i <= nums1.length; i++) {
            // �� nums2 ��ѡ���� k - i ��������
            if (k - i >= 0 && k - i <= nums2.length) {
                // �ϲ�
                int[] tmp = merge(subMaxNumber(nums1, i), subMaxNumber(nums2, k - i));
                // ȡ���ֵ
                if (compare(tmp, 0, res, 0)) {
                    res = tmp;
                }
            }
        }
        return res;
    }

    // �����ڵ����ݼ�ջ
    public int[] subMaxNumber(int[] nums, int len) {
        int[] subNums = new int[len];
        int cur = 0, rem = nums.length - len; // rem ��ʾ������ɾȥ�����ַ�
        for (int i = 0; i < nums.length; i++) {
            while (cur > 0 && subNums[cur - 1] < nums[i] && rem > 0) {
                cur--;
                rem--;
            }
            if (cur < len) {
                subNums[cur++] = nums[i];
            } else {
                rem--; // ���ⳬ���߽����ɾ�ַ�
            }
        }
        return subNums;
    }

    public int[] merge(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int cur = 0, p1 = 0, p2 = 0;
        while (cur < nums1.length + nums2.length) {
            if (compare(nums1, p1, nums2, p2)) { // ����ֻ�Ƚϵ�ǰֵ�������ǰֵ��Ȼ���Ҫ�ȽϺ����ĸ���
                res[cur++] = nums1[p1++];
            } else {
                res[cur++] = nums2[p2++];
            }
        }
        return res;
    }
    
    public boolean compare(int[] nums1, int p1, int[] nums2, int p2) {
        if (p2 >= nums2.length) return true;
        if (p1 >= nums1.length) return false;
        if (nums1[p1] > nums2[p2]) return true;
        if (nums1[p1] < nums2[p2]) return false;
        return compare(nums1, p1 + 1, nums2, p2 + 1);
    }

}
