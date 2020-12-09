package Day_38;

public class FindWay {
	// 递归(过一半的用例就超时)
	public int uniquePaths(int m, int n) {
		return uniquePathsHelper(0, 0, m, n);
	}
	public int uniquePathsHelper(int i, int j, int m, int n) {
		if (i > m - 1 || j > n - 1) {
			return 0;
		}
		if (i == m - 1 && j == n - 1) {
			return 1;
		}
		int right = uniquePathsHelper(i, j + 1, m, n);
		int down = uniquePathsHelper(i + 1, j, m, n);
		return right + down;
	}

	// 递归的备忘录写法 (使用一个数组记录当前已经被计算过的)
	public int uniquePaths2(int m, int n) {
		int[][] tmp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				tmp[i][j] = Integer.MAX_VALUE;
			}
		}
		return uniquePathsHelper2(0, 0, m, n, tmp);
	}

	public int uniquePathsHelper2(int i, int j, int m, int n, int[][] tmp) {
		if (i > m - 1 || j > n - 1) {
			return 0;
		}
		if (i == m - 1 && j == n - 1) {
			return 1;
		}
		if (tmp[i][j] != Integer.MAX_VALUE) {
			return tmp[i][j];
		}
		tmp[i][j] = uniquePathsHelper2(i, j + 1, m, n, tmp) + uniquePathsHelper2(i + 1, j, m, n, tmp);
		return tmp[i][j];
	}

	// DP
	public int uniquePaths3(int m, int n) {
		int[][] f = new int[m][n];
		for (int i = 0; i < m; ++i) {
			f[i][0] = 1;
		}
		for (int j = 0; j < n; ++j) {
			f[0][j] = 1;
		}
		for (int i = 1; i < m; ++i) {
			for (int j = 1; j < n; ++j) {
				f[i][j] = f[i - 1][j] + f[i][j - 1];
			}
		}
		return f[m - 1][n - 1];
	}
}
