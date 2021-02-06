package Day_66;
/**
 * 剑指 Offer 15. 二进制中1的个数
 * @author MyPC
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 *
 */


public class HammingWeight {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    	String binary = Integer.toBinaryString(n);
    	int number = 0;
    	int len = binary.length();
    	for(int i=0 ; i< len ;i++) {
    		if(binary.charAt(i)== '1' ) {
    			number ++ ;
    		}
    	}
		return number;
    }
    
    
    public int hammingWeight2(int n) {
    	int number = 0;
    	while( n != 0) {
    		if( (n&1) == 1) {
    			number ++;
    		}
    		n = n >>> 1;
    		/*
    		 * 注意此处 使用的是 无符号右移而不是 >> ，如果使用 >> 会导致处理负数时，最左端补 1 
    		 * ，而导致的死循环
    		 * 
    		 * 
    		 */
    	}
    	return number;
    }
	
}
