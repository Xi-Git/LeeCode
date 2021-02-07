package Day_67;

/*
 * 剑指 Offer 64. 求1+2+…+n
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 */

public class Sum {
	int res = 0;
    public int sumNums(int n) {
    	boolean x = n>1 && sumNums(n-1)>0;
    	res += n;
		return res;

    }
    /**
     * 本题难点在于如何在题目的要求下判断停止条件
     */
}
