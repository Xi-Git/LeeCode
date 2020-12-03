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
	
	//ʹ��Java�Դ�����ʵ��
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
    
    //ʹ��Ͱ��ʵ��
    private class Bucket {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }

    public int maximumGap2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        
        // ����Ͱ�ĳ��Ⱥ͸�����Ͱ����Ĺؼ�
        // �� n �����£��γɵ��������������� n - 1 �������� [2,4,6,8] ����
        // �� 4 ����������ֻ�� 3 �����䣬[2,4], [4,6], [6,8]
        // ��ˣ�Ͱ���� = �����ܳ��� / �����ܸ��� = (max - min) / (nums.length - 1)
        int bucketSize = Math.max(1, (max - min) / (nums.length - 1));
        
        // ����õ���Ͱ�ĳ��ȣ����ǾͿ����Դ���ȷ��Ͱ�ĸ���
        // Ͱ���� = ���䳤�� / Ͱ����
        // ���￼�ǵ�ʵ�ֵķ��㣬�����һ��Ͱ��Ϊʲô��
        // ���Ǿ���������ӣ�[2,4,6,8], Ͱ�ĳ��� = (8 - 2) / (4 - 1) = 2
        //                           Ͱ�ĸ��� = (8 - 2) / 2 = 3
        // ��֪һ��Ԫ�أ���Ҫ��λ��Ͱ��ʱ��һ���� (��ǰԪ�� - ��Сֵ) / Ͱ����
        // ������ʵ��������������������ȡ��������
        // ������������ӣ������ǰԪ���� 8 �Ļ� (8 - 2) / 2 = 3����Ӧ�� 3 ��Ͱ
        //              �����ǰԪ���� 2 �Ļ� (2 - 2) / 2 = 0����Ӧ�� 0 ��Ͱ
        // ��ᷢ�������� 0,1,2,3 ��Ͱ��ʵ���õ���Ͱ�� 4 ���������� 3 ��
        // ͸������Ӧ�úܺ���⣬�������Ҫ˵����ԭ����ʵ�ǿ������������
        // ������ʵ 0,1,2 ��Ͱ��Ӧ�������� [2,4),[4,6),[6,8)
        // �� 8 ��ô�죿���һ��Ͱ�£�3 ��Ͱ��Ӧ���� [8,10)
        Bucket[] buckets = new Bucket[(max - min) / bucketSize + 1];
        
        for (int i = 0; i < nums.length; ++i) {
            int loc = (nums[i] - min) / bucketSize;
            
            if (buckets[loc] == null) {
                buckets[loc] = new Bucket();
            }
            
            buckets[loc].min = Math.min(buckets[loc].min, nums[i]);
            buckets[loc].max = Math.max(buckets[loc].max, nums[i]);
        }
        
        int previousMax = Integer.MAX_VALUE; int maxGap = Integer.MIN_VALUE;
        for (int i = 0; i < buckets.length; ++i) {
            if (buckets[i] != null && previousMax != Integer.MAX_VALUE) {
                maxGap = Math.max(maxGap, buckets[i].min - previousMax);
            }
            
            if (buckets[i] != null) {
                previousMax = buckets[i].max;
                maxGap = Math.max(maxGap, buckets[i].max - buckets[i].min);
            }
        }
        
        return maxGap;
    }
}
