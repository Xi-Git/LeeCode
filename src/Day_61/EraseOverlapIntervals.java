package Day_61;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {
	public int eraseOverlapIntervals(int[][] intervals) {
		if (intervals.length == 0) {
			return 0;
		}
		// sort里面只需要关心比较器的返回值，如果返回值大于0，则说明比较参数1大于比较参数2，则把参数1”沉底”（换过来说就是参数2冒泡）升序
		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] interval1, int[] interval2) {
				return interval1[1] - interval2[1];
			}
		});
		for (int[] x : intervals) {
			System.out.println(x[0] + " " + x[1]);
		}

		int n = intervals.length;
		int right = intervals[0][1];
		int ans = 1;
		for (int i = 1; i < n; ++i) {
			if (intervals[i][0] >= right) {
				++ans;
				right = intervals[i][1];
			}
		}
		return n - ans;
	}
}
