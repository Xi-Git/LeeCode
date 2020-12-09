package Day_33;

/*
 * https://leetcode-cn.com/problems/pascals-triangle/
 * 18. Ñî»ÔÈý½Ç
 * 
 */


import java.util.ArrayList;
import java.util.List;

public class triangle {
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> tmp = new ArrayList<List<Integer>>();
        for(int i=0;i < numRows ; i++){
        	ArrayList<Integer> tmp2 = new ArrayList<Integer>();
            for(int j = 0 ; j <= i ;j++) {
            	if(j==0 || j==i) {
                	tmp2.add(1);
            	}else {
            		tmp2.add(tmp.get(i-1).get(j)+tmp.get(i-1).get(j-1));
            	}
            }
            tmp.add(tmp2);
        }
		return tmp;
    }
}
