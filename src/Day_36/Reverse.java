package Day_36;
/*
 * https://leetcode-cn.com/problems/score-after-flipping-matrix/
 * 861. 翻转矩阵后的得分
 */

import java.util.Arrays;

public class Reverse {
	public int matrixScore(int[][] A) {
		int[] flag = new int[A[0].length];
		int width = A[0].length;
		int height = A.length;
		// 行反转
		for (int i = 0; i < height; i++) {
			if (A[i][0] == 0) {
				for (int j = 0; j < width; j++) {
					A[i][j] = 1 - A[i][j];
				}
			}
		}
		// 列反转
		for (int i = 0; i < height; i++) {
			for (int j = 1; j < width; j++) {
				if (A[i][j] == 0) {
					flag[j]++;
				}
			}
		}
		for (int j = 1; j < width; j++) {
			if (flag[j] > height / 2.0) {
				for (int m = 0; m < height; m++) {
					A[m][j] = 1 - A[m][j];
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < height; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < width; j++) {
				sb.append(A[i][j]);
			}
			sum = sum + Integer.parseInt(sb.toString(), 2);
		}
		return sum;
	}
}