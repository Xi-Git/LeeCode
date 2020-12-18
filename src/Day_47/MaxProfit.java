package Day_47;

public class MaxProfit {
	
	//递归只能过一半的用例
	public int maxProfit(int[] prices, int fee) {
		return dfs(prices, 0, 0, fee);
	}
	
	private int dfs(int[] prices,int index,int status,int fee) {
		if(index == prices.length) {
			return 0;
		}
		int a=0,b=0,c=0;
		a=dfs(prices, index+1, status, fee);//不动
		if(status==1) {						//卖
			b=dfs(prices, index+1, 0, fee)+prices[index]-fee;
		}else {								//买
			c=dfs(prices, index+1, 1, fee)-prices[index];
		}
		
		return Math.max(Math.max(a, b), c);
	}
	//使用动态规划进行求解
	//dp[0][0]代表当前天如果卖出的最大总收益
	//dp[0][1]代表当前天如果买入的最大总收益
    public int maxProfit2(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        //初始化第一天
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i=1;i<n;++i) {
            //求第i天的买入最大利润，卖出最大利润
        	
        	//可以选择不动(第二天的卖出的最大利润)，或者第二天买入的最大利润+第三天的股价-手续费
        	//卖出存在如果不卖(值为前一天的最大利润)和卖(值为前一天买入的最大理论加当日的利润)
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]-fee);	
            
            //可以选择不动(第二天买入的最大利润)，或者第二天卖出的最大利润-第三天股价
            //买存在买(值为前一天卖出最大理论减当日股价)和不买(值为前一天买入的最大利润)
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }
}
