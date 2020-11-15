package Day_06;

import java.util.HashSet;
import java.util.Scanner;

public class compressstring {

	/**
	 * https://leetcode-cn.com/problems/compress-string-lcci/
	 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。
	 * 若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(compressString(s));

	}

	public static String compressString(String S) {
		if (S == null || S.length() < 2) {
			return S;
		}
		char[] chars = S.toCharArray();
		int  n = chars.length;
		StringBuilder sb = new StringBuilder();
		int count = 0;
		char ch = chars[0];

		for (int i = 0; i < n ; i++) {
			if( ch == chars[i])
				count ++;
			else {
				sb.append(ch).append(count);
				count = 1;
				ch = chars[i];
			}
		}
		sb.append(ch).append(count);				//不要忘记考虑最后的这一段
		String res = sb.toString();					//测试: IIIIeeeeOODDDssppppooQQQQppplllhu
		return res.length() < n ? res : S;


	}

}
