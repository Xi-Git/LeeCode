package Day_13; 
import java.util.Scanner;

public class MyPow {

	/**
	 * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
	 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
	 * -100.0 < x < 100.0
	 * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。   
	 * 注意负数区有一个2^31如果将它转换为正数记得减一，否则会超出最大能表示范围
	 * 否者会有以下用例过不去
		1.00000
		-2147483648
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a;
		int b;
		Scanner sc = new Scanner(System.in);
		a = sc.nextDouble();
		b = sc.nextInt();
		System.out.println(myPow(a,b));

	}
	
	//解法一：递归实现
	 static double myPow(double x, int n) {
		 if(n == 0){
			 return 1;
		 }
         if(n>0) {
			 return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);	 
		 }  
		return 1/x*myPow(1/x, -n-1);
	 }
	 
	 //解法二：非递归实现
	 static double myPow_2(double x, int n) {
	        if(x == 0) return 0;
	        long b = n;
	        double res = 1.0;
	        if(b < 0) {
	            x = 1 / x;
	            b = -b;
	        }
	        while(b > 0) {
	            if((b & 1) == 1) res *= x;				//判断奇偶
	            x *= x;
	            b >>= 1;								//左移为乘，右移为除
	        }
	        return res;
	 }

}
