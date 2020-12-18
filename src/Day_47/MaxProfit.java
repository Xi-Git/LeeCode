package Day_47;

public class MaxProfit {
	
	//�ݹ�ֻ�ܹ�һ�������
	public int maxProfit(int[] prices, int fee) {
		return dfs(prices, 0, 0, fee);
	}
	
	private int dfs(int[] prices,int index,int status,int fee) {
		if(index == prices.length) {
			return 0;
		}
		int a=0,b=0,c=0;
		a=dfs(prices, index+1, status, fee);//����
		if(status==1) {						//��
			b=dfs(prices, index+1, 0, fee)+prices[index]-fee;
		}else {								//��
			c=dfs(prices, index+1, 1, fee)-prices[index];
		}
		
		return Math.max(Math.max(a, b), c);
	}
	//ʹ�ö�̬�滮�������
	//dp[0][0]����ǰ��������������������
	//dp[0][1]����ǰ�������������������
    public int maxProfit2(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        //��ʼ����һ��
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i=1;i<n;++i) {
            //���i�������������������������
        	
        	//����ѡ�񲻶�(�ڶ�����������������)�����ߵڶ���������������+������Ĺɼ�-������
        	//���������������(ֵΪǰһ����������)����(ֵΪǰһ�������������ۼӵ��յ�����)
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]-fee);	
            
            //����ѡ�񲻶�(�ڶ���������������)�����ߵڶ����������������-������ɼ�
            //�������(ֵΪǰһ������������ۼ����չɼ�)�Ͳ���(ֵΪǰһ��������������)
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }
}
