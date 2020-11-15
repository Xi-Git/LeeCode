package Day_06;

import java.util.HashSet;
import java.util.Scanner;

public class compressstring {

	/**
	 * https://leetcode-cn.com/problems/compress-string-lcci/
	 * �ַ���ѹ���������ַ��ظ����ֵĴ�������дһ�ַ�����ʵ�ֻ������ַ���ѹ�����ܡ����磬�ַ���aabcccccaaa���Ϊa2b1c5a3��
	 * ����ѹ��������ַ���û�б�̣��򷵻�ԭ�ȵ��ַ���������Լ����ַ�����ֻ������СдӢ����ĸ��a��z����
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
		sb.append(ch).append(count);				//��Ҫ���ǿ���������һ��
		String res = sb.toString();					//����: IIIIeeeeOODDDssppppooQQQQppplllhu
		return res.length() < n ? res : S;


	}

}
