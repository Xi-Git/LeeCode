package Day_07;
import java.util.Scanner;
/**
 * https://leetcode-cn.com/problems/rotate-matrix-lcci/ 给你一幅由 N × N
 * 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。 不占用额外内存空间能否做到？
 * 
 * @param args
 */
public class Rotate {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] x = new int[2][2];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				x[i][j] = sc.nextInt();
			}
		}
		rotate(x);
		sc.close();
	}

	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; ++i) {
			for (int j = 0; j < (n + 1) / 2; ++j) { 			// for (int j = i; j < n - 1- i; ++j) ???
				int t = matrix[i][j];
				matrix[i][j] = matrix[n - j - 1][i];
				matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
				matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
				matrix[j][n - i - 1] = t;
			}
		}
	}

}
