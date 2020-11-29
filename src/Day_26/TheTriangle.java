package Day_26;

import java.util.Arrays;

/*
 * https://leetcode-cn.com/problems/largest-perimeter-triangle/
 * ������һЩ�����������ȣ���ɵ����� A����������������������ɵġ������Ϊ��������ε�����ܳ���
 * ��������γ��κ������Ϊ��������Σ����� 0��
 */

public class TheTriangle {
	
	//�Լ��Ľⷨ
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
	
	//������ĸ�����,ע�������ʽ��ϵ:a<b<c,a+b>c�������Ƴ�����������ʽ��ϵ
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
