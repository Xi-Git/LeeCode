package Day_55;

import java.util.Arrays;

public class FindContentChildren {
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int ssize = s.length - 1; // 饼干的
		int index = g.length - 1; // 人的
		int number = 0;
		while (ssize >= 0 && index >= 0) {
			// System.out.println(s[ssize] + " " + g[index]);
			if (s[ssize] >= g[index]) {
				number++;
				ssize--;
				index--;
			} else {
				index--;
			}
		}

		return number;
	}
}
