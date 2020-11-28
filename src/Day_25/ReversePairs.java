package Day_25;

import java.util.Arrays;

import sun.applet.Main;

public class ReversePairs {
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE+ " " + Integer.MIN_VALUE);
	}
	
	//当场超时
    public int reversePairs(int[] nums) {
    	int len = nums.length;
    	int count = 0;
    	for(int i=0;i<len;i++) {
    		for(int j=i+1;j<len;j++) {
    			long tmp = (long)2*(long)nums[j];
    			 if(nums[i] > tmp) {
    				 count ++;
    			 }
    		}
    	}
		return count;
    }
    
    //CV的答案
    public int reversePairs2(int[] nums) {
        // 使用归并排序，从小到大的进行排序
        if(nums.length < 2) {
            return 0;
        }
        return sort(nums,0,nums.length - 1);

    }

    public int sort(int[] nums,int left,int right) {
        if(left >= right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int leftRes = sort(nums,left,mid);
        int rightRes = sort(nums,mid + 1,right);
       
        return leftRes + rightRes + merge(nums,left,mid,right);
    }

    public int merge(int[] nums,int left,int mid,int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int res = 0;
        int flag = 0;
        // 计算翻转对
        while(i <= mid && j <= right) {
            if(nums[i] > 2 * (long)nums[j]) {
                res += mid - i + 1;
                j++;
            }else {
                i++;
            }
        }

        i = left;
        j = mid + 1;

        // 进行排序
        while(i <= mid && j <= right) {
            
            if(nums[i] < nums[j]) {
                temp[flag++] = nums[i++];
            }else {
                temp[flag++] = nums[j++];
            }
        }

        while(i <= mid) {
            temp[flag++] = nums[i++];
        }
        while(j <= right) {
            temp[flag++] = nums[j++];
        }
        for(int k = 0;k < temp.length;k++) {
            nums[left + k] = temp[k];
        }
        return res;
    }

}
