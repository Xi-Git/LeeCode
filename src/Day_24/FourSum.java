package Day_24;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FourSum {
	public static void main(String[] args) {

	}

	// 解法三：一个hashmap处理
	public int fourSumCount3(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> ab = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				int sum = A[i] + B[j];
				if (!ab.containsKey(sum)) {
					ab.put(sum, 1);
				} else {
					ab.put(sum, ab.get(sum) + 1);
				}
			}
		}
		int count = 0;
		for (int k = 0; k < C.length; k++) {
			for (int m = 0; m < D.length; m++) {
				int sum = -(C[k] + D[m]);
				if (ab.containsKey(sum)) {
					count += ab.get(sum);
				}
			}
		}
		return count;
	}

	// 解法二；两个hashmap处理
	public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> ab = new HashMap<Integer, Integer>();
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				sum = A[i] + B[j];
				if (!ab.containsKey(sum)) {
					ab.put(sum, 1);
					continue;
				}
				ab.put(sum, ab.get(sum) + 1);

			}
		}

		Map<Integer, Integer> cd = new HashMap<Integer, Integer>();
		for (int k = 0; k < C.length; k++) {
			for (int m = 0; m < D.length; m++) {
				sum = C[k] + D[m];
				if (!cd.containsKey(sum)) {
					cd.put(sum, 1);
					continue;
				}
				cd.put(sum, (cd.get(sum) + 1));

			}
		}
		Set<Map.Entry<Integer, Integer>> set1 = ab.entrySet();
		int count = 0;
		for (Map.Entry<Integer, Integer> a : set1) {
			if (cd.containsKey(-a.getKey())) {
				count = count + a.getValue() * cd.get(-a.getKey());
			}

		}
		return count;

	}

	// 解法一:过39/48个用例
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				for (int k = 0; k < C.length; k++) {
					for (int m = 0; m < D.length; m++) {
						int sum = A[i] + B[j] + C[k] + D[m];
						if (sum == 0) {
							count++;
						}
					}
				}
			}
		}
		return count;
	}
}
