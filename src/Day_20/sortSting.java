package Day_20;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * https://leetcode-cn.com/problems/increasing-decreasing-string/
 * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 * 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 * 重复步骤 2 ，直到你没法从 s 中选择字符。
 * 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 * 重复步骤 5 ，直到你没法从 s 中选择字符。
 * 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 * 请你返回将 s 中字符重新排序后的 结果字符串 。
 * 
 * @author MyPC
 *
 */

public class sortSting {

	//解法一:桶计数
	public String SortString(String s) {
    	StringBuilder ret =new StringBuilder();
    	char[] strchar = s.toCharArray();
    	Arrays.sort(strchar);
    	
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        while (ret.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (num[i] > 0) {
                    ret.append((char) (i + 'a'));
                    num[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (num[i] > 0) {
                    ret.append((char) (i + 'a'));
                    num[i]--;
                }
            }
        }
    	return ret.toString();
    }
    
	//解法二:通过map的特性将String的所有元素统计后加入，再通过map获取键值对存入Map.Entry
	 public String sortString2(String s) {
	        //将字符串按照各字符大小装入TreeMap中，key为字符，value为出现次数
	        TreeMap<Character, Integer> params = new TreeMap<>(new Comparator<Object>() {
	        	@Override
	        	public int compare(Object o1, Object o2) {
	        		// TODO Auto-generated method stub
	        		return (Integer.parseInt((String)o1))-(Integer.parseInt((String)o2));
	        	}
			});
	        for (char item: s.toCharArray()) {
	            if(params.containsKey(item)){
	                params.put(item, params.get(item)+1);
	            }else {
	                params.put(item, 1);
	            }
	        }

	        StringBuilder result = new StringBuilder();
	        Boolean desc = true;
	        //由题意知结果字符串为先从小到大筛选各字符排列，然后从大到小筛选排列，然后又从小到大筛选排列，直至全部筛选完
	        //故此可利用有序treeMap的higherEntry和lowerEntry方法进行筛选获取
	        Map.Entry<Character, Integer> entry = params.firstEntry();
	        Map.Entry<Character, Integer> temp = entry;
	        while (params.size() > 0){
	            if(entry != null){
	                result.append(entry.getKey());
	                if(entry.getValue() > 1){
	                    params.put(entry.getKey(), entry.getValue()-1);
	                }else {
	                    params.remove(entry.getKey());
	                }
	            }else {
	                desc = !desc;
	            }
	            if(desc){
	                entry = (entry != null ?params.higherEntry(entry.getKey()) : params.firstEntry());
	            }else {
	                entry = (entry != null ?params.lowerEntry(entry.getKey()) : params.lastEntry());
	            }

	        }
	        return result.toString();
	    }
	 
	 
	

}
