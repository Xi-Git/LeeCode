package Day_05;

import java.util.Scanner;

/***
 * https://leetcode-cn.com/problems/one-away-lcci/
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑
 * 
 * @author MyPC 
 * A:f和s一样长，比较字符顺序和几个字符不同 考虑替换
 * B：f比s不一样长(长度差是否大于1)：
 *         比较基本顺序和字符内容，判断不同处有多少 比较到不同长度短的要回退再比一次 不可以长度长的加一否则会在下一次循环再进一位导致少比一位
 * 
 */

public class Edit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		System.out.println(oneEditAway2(a, b));
		sc.close();

	}

	// 解法一
	public static boolean oneEditAway(String first, String second) {
		if (Math.abs(first.length() - second.length()) > 1) {
			return false;
		}
		char[] tmpf = first.toCharArray();
		char[] tmps = second.toCharArray();
		int count = 0;
		if (tmpf.length == tmps.length) {
			for (int i = 0; i < tmpf.length; i++) {
				if (tmpf[i] != tmps[i]) {
					count++;
				}
			}
		} else {
			for (int i = 0, j = 0; j < tmps.length && i < tmpf.length; i++, j++) {
				if (tmpf[i] != tmps[j]) {
					count++;
					if ((tmpf.length - tmps.length) == 1) { // 核心区
						j--;
					} else {
						i--;
					}
				}
			}
		}
		if (count == 0 || count == 1) {
			return true;
		} else {
			return false;
		}
	}

	// 解法二:递归实现
	public static boolean oneEditAway2(String first, String second) {
		int n1 = first.length(), n2 = second.length();
		int differ = Math.abs(n1 - n2);
		if (differ > 1) {
			return false;
		}
		if (n1 + n2 <= 2) {
			return true;
		}
		if( first.charAt(0) != second.charAt(0)){
			if( n1 == n2){
				return first.substring(1).equals(second.substring(1));
			} else {
				return first.substring(0).equals(second.substring(1)) || first.substring(1).equals(second.substring(0));
			}
		} else {
			return oneEditAway2(first.substring(1), second.substring(1));
		}
	}
}
