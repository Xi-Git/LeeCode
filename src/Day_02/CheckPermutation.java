package Day_02;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://leetcode-cn.com/problems/check-permutation-lcci/ 
 * 给定两个字符串 s1 和
 * s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
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

	// 解法一: 通过比较排序后的数组的每个元素是否相等   使用Arrays自带的方法进行处理
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
			// Arrays.equals(x1, x2); 该方法重写过，不是比较地址，会比较数组中的每个元素是否相等
		}
		return true;
	}
	// 解法二: 使用int数组进行标记
	public boolean judge2(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		int[] nums = new int[26];
		int len = s1.length();
		for (int i = 0; i < len; i++) {
			nums[s1.charAt(i) - 97]++;				//核心代码：分别检测两个数组元素，并使用int数组+1进行标记
			nums[s2.charAt(i) - 97]--;				//		     一个数组检测到就进行加，另一个数组检测到就-1，最
		}											//		     终如果两个数组一致就会返回一个全为零的int数组
		for (int num : nums) {
			if (num != 0)
				return false;
		}
		return true;
	}

}
