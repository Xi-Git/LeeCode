package Day_28;


/*
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *进阶：
 *你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 */

import java.util.ArrayList;
import java.util.Collections;


public class SearchRange {
	
	//暴力查找
    public int[] searchRange(int[] nums, int target) {
    	
    	ArrayList<Integer> tmp =new ArrayList<Integer>();
    	for(int i =0;i<nums.length;i++) {
    		if(nums[i] == target) {
    			tmp.add(i);
    		}
    	}
    	if(tmp.size()>0) {
    		Collections.sort(tmp);
    		int a = tmp.get(0);
    		int b = tmp.get(tmp.size()-1);
    		return new int[] {a,b};
    	}else {
    		return new int[] {-1,-1};
    	}

    }
    //暴力查找换成数组
    public int[] searchRange2(int[] nums, int target) {
        int len = nums.length;
        int[] tmp  = new int[len];
        int count =0 ;
        int index = 0;
    	for(int i =0;i<len;i++) {
    		if(nums[i] == target) {
    			count ++ ;
                tmp[index++]=i;
    		}
    	}
    	if(count>0) {
    		return new int[] {tmp[0],tmp[index-1]};
    	}
    	return new int[] {-1,-1};
    }
    
    
    //二分查找
    public int[] searchRange4(int[] nums, int target) {
        assert nums!= null;
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        int[] res = new int[]{findLeft(nums, target),findRight(nums, target)};
        return res;
    }

    private int findLeft(int[] nums, int target){
        int len = nums.length;
        int res = -1;
        int start = 0;
        int end = len - 1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] < target){
                start = mid + 1;
            }
             else {
                if(nums[mid] == target){
                    res = mid;
                }
                end = mid - 1;
            }
        }

        return res;

    }

    private int findRight(int[] nums, int target){
        int len = nums.length;
        int res = -1;
        int start = 0;
        int end = len - 1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] > target){
                end = mid - 1;
            }
            else {
                if(nums[mid] == target){
                    res = mid;
                }
                start = mid + 1;

            }
        }

        return res;

    }

}
