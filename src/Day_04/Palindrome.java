package Day_04;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Palindrome {

	/**
	 * https://leetcode-cn.com/problems/palindrome-permutation-lcci/
	 * ����һ���ַ�������дһ�������ж����Ƿ�Ϊĳ�����Ĵ�������֮һ��
	 * ���Ĵ���ָ������������һ���ĵ��ʻ���������ָ��ĸ���������С�
	 * ���Ĵ���һ�����ֵ䵱�еĵ��ʡ�
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

	//�ⷨһ:��ʱ0ms
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
    
    //�ⷨ��������hashset�����ظ�ʵ������ջ�Ĺ���			���м�д��
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
