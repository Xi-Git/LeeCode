package Day_30;
/*
 * https://leetcode-cn.com/problems/count-primes/
 * 统计所有小于非负整数 n 的质数的数量。
 * 
 * 
 */

public class CountPrimes {
	
	//
	public int countPrimes(int n) {
		if(n==0 || n==1 || n==2) {
			return 0;
		}

		int count = 1;
		for(int i = 3 ; i < n ; i+=2) {
			if( i >> 1 != 0) {
                boolean flag =true;
				for(int j = 3 ; j*j<=i ; j+=2) {			//此处不调用sqrt速度过慢，Java中乘法速度大于sqrt
					if(i % j == 0) {
                        flag =false;
						break;
					}
				}
                if(flag){
                    count ++;
                }
			}
		}
		return count;
    }
	
    public int countPrimes2(int n) {
    	if(n < 3) {
    		return 0;
    	}
        int ans = 1;
        for (int i = 3; i < n; i+=2) {
            if(i >> 1 != 0){
                ans += isPrime(i) ? 1 : 0;
            }
        }
        return ans;
    }

    public boolean isPrime(int x) {
        for (int i = 3; i*i <x; i+=2) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
