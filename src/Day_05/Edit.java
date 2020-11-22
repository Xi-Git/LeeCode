package Day_05;

import java.util.Scanner;

/***
 * https://leetcode-cn.com/problems/one-away-lcci/
 * �ַ��������ֱ༭����:����һ���ַ���ɾ��һ���ַ������滻һ���ַ��� ���������ַ�������дһ�������ж������Ƿ�ֻ��Ҫһ��(�������)�༭
 * 
 * @author MyPC 
 * A:f��sһ�������Ƚ��ַ�˳��ͼ����ַ���ͬ �����滻
 * B��f��s��һ����(���Ȳ��Ƿ����1)��
 *         �Ƚϻ���˳����ַ����ݣ��жϲ�ͬ���ж��� �Ƚϵ���ͬ���ȶ̵�Ҫ�����ٱ�һ�� �����Գ��ȳ��ļ�һ���������һ��ѭ���ٽ�һλ�����ٱ�һλ
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

	// �ⷨһ
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
					if ((tmpf.length - tmps.length) == 1) { // ������
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

	// �ⷨ��:�ݹ�ʵ��
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
