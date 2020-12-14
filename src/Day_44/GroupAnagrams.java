package Day_44;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	//使用HashMap进行，注意键可以先进行排序再放进去作为键
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> all = new HashMap<String, List<String>>();
		for(int i=0;i<strs.length;i++) {
			char[] tmp = strs[i].toCharArray();
			Arrays.sort(tmp);
			String tmp2 = new String(tmp);
			List<String> value = new ArrayList<String>();
			if(all.containsKey(tmp2)) {
				value = all.get(tmp2);
				value.add(strs[i]);
				all.put(tmp2, value);
				
			}else {
				value.add(strs[i]);
				all.put(tmp2, value);
			}
		}
		return new ArrayList<List<String>>(all.values());
	}
	
	//直接比较
	public List<List<String>> groupAnagrams2(String[] strs) {
		List<List<String>> all = new ArrayList<List<String>>();
		List<String> single = new ArrayList<>();
		int count = strs.length;
		boolean[] flag = new boolean[count];
		for (int i = 0; i < count; i++) {
			if (!flag[i]) {
				if (single.isEmpty()) {
					single.add(strs[i]);
					flag[i] = true;
					for (int j = i + 1; j < count; j++) {
						if (!flag[j]) {
							if (compareTwo(strs[i], strs[j])) {
								single.add(strs[j]);
								flag[j] = true;
							}
						}
					}
					if (!single.isEmpty()) {
						all.add(new ArrayList<String>(single));
						single.removeAll(single);
					}
				}
			}

		}

		return all;
	}

	public static boolean compareTwo(String tmp1, String tmp2) {
		if (tmp1.length() != tmp2.length()) {
			return false;
		}
		char[] tmp3 = tmp1.toCharArray();
		char[] tmp4 = tmp2.toCharArray();
		Arrays.sort(tmp3);
		Arrays.sort(tmp4);
		for (int i = 0; i < tmp3.length; i++) {
			if (tmp3[i] != tmp4[i]) {
				return false;
			}
		}
		return true;
	}
}
