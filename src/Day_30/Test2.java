package Day_30;

import java.util.Arrays;

public class Test2 {
	/*
	 * 厄拉多塞筛法
	 * 
	 * 西元前250年，希腊数学家厄拉多塞(Eeatosthese)想到了一个非常美妙的质数筛法，
	 * 减少了逐一检查每个数的的步骤，可以比较简单的从一大堆数字之中，筛选出质数来， 这方法被称作厄拉多塞筛法(Sieve of Eeatosthese)。
	 * 具体操作：先将 2~n 的各个数放入表中，然后在2的上面画一个圆圈 ，然后划去2的其他倍数；第一个既未画圈又没有被划去的数是3，将它画圈，
	 * 再划去3的其他倍数；现在既未画圈又没有被划去的第一个数 是5，将它画圈， 并划去5的其他倍数……依次类推，一直到所有小于或等于 n
	 * 的各数都画了圈或划去为止。 这时，表中画了圈的以及未划去的那些数正好就是小于 n 的素数
	 */
	class Solution {
		public int countPrimes(int n) {
			byte[] isPrime = new byte[n];
			int ans = 0;
			for (int i = 2; i < n; ++i) {
				if (isPrime[i] == 0) {
					ans += 1;
					if ((long) i * i < n) {
						for (int j = i * i; j < n; j += i) {
							isPrime[j] = 1;
						}
					}
				}
			}
			return ans;
		}
	}
}
