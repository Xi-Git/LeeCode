package Day_40;
/***
 * https://leetcode-cn.com/problems/queries-on-a-permutation-with-key/
 * 1409. 查询带键的排列
 * @author MyPC
 *
 */
public class ProcessQueries {
    public int[] processQueries(int[] queries, int m) {
    	int[] tmp = new int[m];
    	for(int i=0;i<m;i++) {
    		tmp[i]=i+1;
    	}
        int[] trace = new int[queries.length];
    	for(int i = 0;i<queries.length;i++) {
    		for(int j=0;j<m;j++) {
    			if(queries[i]==tmp[j]) {
    				exchange(tmp,j,tmp[j]);
                    trace[i]=j;
    			}
    		}
    	}
    	return trace;
    }
    
    public void exchange(int[] tmp,int n,int target) {
    	if(n==0) {
    		return;
    	}
    	for(int i = n-1;i>=0;i--) {
    		tmp[i+1]=tmp[i];
    	}
    	tmp[0]=target;
    }
}
