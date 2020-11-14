package Day_03;

import java.util.Scanner;

public class Url {

	/**
	 * https://leetcode-cn.com/problems/string-to-url-lcci/
	 * URL������дһ�ַ��������ַ����еĿո�ȫ���滻Ϊ%20���ٶ����ַ���β�����㹻�Ŀռ��������ַ���
	 * ����֪���ַ����ġ���ʵ�����ȡ���ע����Javaʵ�ֵĻ�����ʹ���ַ�����ʵ�֣��Ա�ֱ���������ϲ�������
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

	// �ⷨһ: ʹ��StringBuilder��ʵ��(ʱ��31)
	public static String replaceSpaces(String S, int length) {
		char[] tmp = S.toCharArray();
		StringBuilder tmp2 = new StringBuilder();
		/*
		 * for(char x:tmp){ if(x == ' '){ tmp2.append("%20");
		 * //���Ǵ����tmpÿ�ζ����ж���Ŀո�ִ�� }else{ tmp2.append(String.valueOf(x)); } }
		 */

		for (int i = 0; i < length; i++) { // ��Ҫ������Ŀ��������֪���鳤�ȣ����򵱳�����е��������ּ���ѭ��
			char x = tmp[i];
			if (x == ' ') {
				tmp2.append("%20");
			} else {
				tmp2.append(String.valueOf(x));
			}
		}
		return tmp2.toString();
	}

	// �ⷨ��:��ʱ��11��
	public static String replaceSpaces_2(String S, int length) {
		return S.substring(0, length).replace(" ", "%20");
	}

	// �ⷨ��:(ʱ��10)
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
