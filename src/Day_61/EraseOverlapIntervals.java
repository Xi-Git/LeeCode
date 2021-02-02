package Day_61;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {
	public int eraseOverlapIntervals(int[][] intervals) {
		if (intervals.length == 0) {
			return 0;
		}
		// sort����ֻ��Ҫ���ıȽ����ķ���ֵ���������ֵ����0����˵���Ƚϲ���1���ڱȽϲ���2����Ѳ���1�����ס���������˵���ǲ���2ð�ݣ�����
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
