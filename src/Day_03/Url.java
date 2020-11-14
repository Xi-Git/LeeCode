package Day_03;

import java.util.Scanner;

public class Url {

	/**
	 * https://leetcode-cn.com/problems/string-to-url-lcci/
	 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，
	 * 并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int len = sc.nextInt();
		System.out.println(replaceSpaces(s, len).toString());

	}

	// 解法一: 使用StringBuilder来实现(时间31)
	public static String replaceSpaces(String S, int length) {
		char[] tmp = S.toCharArray();
		StringBuilder tmp2 = new StringBuilder();
		/*
		 * for(char x:tmp){ if(x == ' '){ tmp2.append("%20");
		 * //这是错误的tmp每次都会有多余的空格被执行 }else{ tmp2.append(String.valueOf(x)); } }
		 */

		for (int i = 0; i < length; i++) { // 不要忽略题目所给的已知数组长度，否则当程序进行到最后会多出现几次循环
			char x = tmp[i];
			if (x == ' ') {
				tmp2.append("%20");
			} else {
				tmp2.append(String.valueOf(x));
			}
		}
		return tmp2.toString();
	}

	// 解法二:（时间11）
	public static String replaceSpaces_2(String S, int length) {
		return S.substring(0, length).replace(" ", "%20");
	}

	// 解法三:(时间10)
	public static String replaceSpaces_3(String S, int length) {
		char[] x = new char[length * 3];
		int index = 0;
		for (int i = 0; i < length; i++) {
			char ch = S.charAt(i);
			if (ch == ' ') {
				x[index++] = '%';
				x[index++] = '2';
				x[index++] = '0';
			} else {
				x[index++] = ch;
			}
		}
		return new String(x, 0, index);
	}

}
