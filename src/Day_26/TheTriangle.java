package Day_26;

import java.util.Arrays;

/*
 * https://leetcode-cn.com/problems/largest-perimeter-triangle/
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * 如果不能形成任何面积不为零的三角形，返回 0。
 */

public class TheTriangle {
	
	//自己的解法
	public int largestPerimeter(int[] A) {
		int a = 0;
		Arrays.sort(A);
		int len = A.length;
		if (len < 3  ) {
			return 0;
		}
		for (int i = len - 1; i > 0; i--) {
			a = A[i];
			if (i >= 2) {
				if (A[i - 2] + A[i - 1] <= a) {
					continue;
				} else {
					if (A[i - 2] + A[i - 1] > a && a + A[i-2] > A[i-1] && A[i-1] + a > A[i-2]) {
						return a + A[i-1] + A[i-2];
					}
				}
			}
		}
		return 0;
	}
	
	//看题解后的改良版,注意推算等式关系:a<b<c,a+b>c，即可推出其余两个等式关系
	public int largestPerimeter2(int[] A) {
		int a = 0;
		Arrays.sort(A);
		int len = A.length;
		if (len < 3 || A==null ) {
			return 0;
		}
		for (int i = len - 1; i > 1; i--) {
			a = A[i - 2] + A[i - 1];
			if (a > A[i]) {
				return A[i-2] + A[i-1] + A[i];
			} 
		}
		return 0;
	}
	
}
