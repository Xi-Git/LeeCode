package Day_04;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Palindrome {

	/**
	 * https://leetcode-cn.com/problems/palindrome-permutation-lcci/
	 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
	 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
	 * 回文串不一定是字典当中的单词。
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((int)('a'-96));
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(canPermutePalindrome(s));
		sc.close();
	}

	//解法一:用时0ms
    public static boolean canPermutePalindrome(String s) {
    	int[] tmp = new int[130];
    	char[] x = s.toCharArray();
    	int n =0;
    	for(int i=0;i<x.length;i++){
    		n = x[i];
    		tmp[n]++;
    	}
    	int count = 0;
    	for(int i=0;i<130;i++){
    		if(tmp[i]%2 != 0){
    			count++;
    		}
    	}
    	if(count == 1 || count == 0){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    
    //解法二：利用hashset不可重复实现类似栈的功能			大佬级写法
    public boolean canPermutePalindrome2(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.add(c)) {
                set.remove(c);
            }
        }
        return set.size() <= 1;
    }


}
