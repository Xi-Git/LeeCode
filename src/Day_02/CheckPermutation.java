package Day_02;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://leetcode-cn.com/problems/check-permutation-lcci/ 
 * ���������ַ��� s1 ��
 * s2�����дһ������ȷ������һ���ַ������ַ��������к��ܷ�����һ���ַ�����
 * 
 * @param args
 */
public class CheckPermutation {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		System.out.println(CheckPermutation.judge(s1, s2));
		sc.close();

	}

	// �ⷨһ: ͨ���Ƚ������������ÿ��Ԫ���Ƿ����   ʹ��Arrays�Դ��ķ������д���
	public static boolean judge(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		} else {
			char[] x1 = s1.toCharArray();
			char[] x2 = s2.toCharArray();
			Arrays.sort(x1);
			Arrays.sort(x2);
			for (int i = 0; i < x1.length; i++) {
				if (x1[i] != x2[i]) {
					return false;
				}
			}
			// Arrays.equals(x1, x2); �÷�����д�������ǱȽϵ�ַ����Ƚ������е�ÿ��Ԫ���Ƿ����
		}
		return true;
	}
	// �ⷨ��: ʹ��int������б��
	public boolean judge2(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		int[] nums = new int[26];
		int len = s1.length();
		for (int i = 0; i < len; i++) {
			nums[s1.charAt(i) - 97]++;				//���Ĵ��룺�ֱ�����������Ԫ�أ���ʹ��int����+1���б��
			nums[s2.charAt(i) - 97]--;				//		     һ�������⵽�ͽ��мӣ���һ�������⵽��-1����
		}											//		     �������������һ�¾ͻ᷵��һ��ȫΪ���int����
		for (int num : nums) {
			if (num != 0)
				return false;
		}
		return true;
	}

}
