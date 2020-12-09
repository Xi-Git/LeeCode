package Day_35;
/*
 * 
 * 
 */


import java.util.ArrayList;
import java.util.Arrays;

public class RemoveSum {
	//��ʱ��ֻ����80%������
    public int maxOperations(int[] nums, int k) {
    	Arrays.sort(nums);
    	int count =0;
        int m = nums.length;
    	for(int i=0;i<m;i++) {
    		if(nums[i]==Integer.MAX_VALUE) {
    			continue;
    		}
    		int subtract = k-nums[i];
    		int n =-1;
    		if(subtract >= nums[i]) {
    			n =Arrays.binarySearch(nums,i+1,m,subtract);
    		}else {
    			if(i-1>=0) {
    			    n =Arrays.binarySearch(nums,0,i-1,subtract);
    			}

    		}
    		if(n>=0) {
    			nums[n]=Integer.MAX_VALUE;
    			nums[i]=Integer.MAX_VALUE;
    			count++;
    		}
    	}
    	return count;
    }
    //˫ָ��
    public int maxOperations2(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int left = 0, right = len - 1;
        
        int ans = 0;
        while(left < right){
            int temp = nums[left] + nums[right];
            if(temp < k){
                left++;
            }else if(temp > k){
                right--;
            } else {
                ans++;
                // �Ƴ�
                left++;
                right--;
            }
        }
        
        return ans;
    }
    
    //������ʹ��HashMap
}
