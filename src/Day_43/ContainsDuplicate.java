package Day_43;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> tmp = new HashSet<>();
		for (int x : nums) {
			if (!tmp.add(x)) {
				return true;
			}
		}
		return false;
	}
	
	
    public int minPartitions(String n) {
        int[] tmp = new int[n.length()];
        char[] tmp2 = n.toCharArray();
        int count =0 ;
        int cishu = 0;
        for(int i =0;i<n.length();i++){
            tmp[i] = Integer.valueOf(tmp2[i]);
            count = count + tmp[i];
        }
        while(count>0) {
        	for(int i=0;i<tmp.length;i++) {
        		if(tmp[i]>0) {
        			tmp[i] = tmp[i]-1;
        			count --;
        		}
        	}
        	cishu++;
        }
        return cishu;

    }
}
