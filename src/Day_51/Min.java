package Day_51;

import java.util.HashMap;
import java.util.Map;

public class Min {

	public int minCostClimbingStairs(int[] cost) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		return Math.min(dfs(0, cost, map) + cost[0], dfs(1, cost, map) + cost[1]);
	}
	public int dfs(int index, int[] cost, Map<Integer, Integer> map) {
		if (index + 1 >= cost.length || index + 2 >= cost.length) {
			return 0;
		}
		int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
		if (map.containsKey(index + 1) && map.containsKey(index + 2)) {
			return Math.min(map.get(index + 1), map.get(index + 2));
		} else if (map.containsKey(index + 1) && !map.containsKey(index + 2)) {
			left = map.get(index + 1);
			right = dfs(index + 2, cost, map) + cost[index + 2];
			map.put(index + 2, right);
		} else if (!map.containsKey(index + 1) && map.containsKey(index + 2)) {
			left = dfs(index + 1, cost, map) + cost[index + 1];
			map.put(index + 1, left);
			right = map.get(index + 2);
		} else {
			left = dfs(index + 1, cost, map) + cost[index + 1];
			right = dfs(index + 2, cost, map) + cost[index + 2];
			map.put(index + 1, left);
			map.put(index + 2, right);
		}
		return Math.min(left, right);

	}
}
