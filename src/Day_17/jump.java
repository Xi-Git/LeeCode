package Day_17;

/***
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 *一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 
 * @author MyPC
 *
 */
public class jump {
	
	
//	直接递归只能过42个测试用例
    public int numWays(int n) {
//    	if(n <= 1) {
//    		return 1;
//    	}
//    	if(n < 3){
//    		return n;
//    	}
//    	return (numWays(n-1)+numWays(n-2))%1000000007;
    	
    	
		//必须改为非递归才可以过 
        if (n <= 1)
            return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }
}
