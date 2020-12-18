package Day_48;

import java.util.Arrays;

public class FindTheDifference {
	public static void main(String[] args) {
		char x = '9';
		System.out.println( x - '0');
	}
	//解法一
    public char findTheDifference(String s, String t) {
    	char[] ss = s.toCharArray();
    	char[] st = t.toCharArray();
    	int len = ss.length;
    	Arrays.sort(ss);
    	Arrays.sort(st);
    	for(int i = 0 ;i<len ;i++) {
    		if(ss[i] != st[i]) {
    			return st[i];
    		}
    	}
    	return st[len-1];
    }
    //解法二:做加法
    public char findTheDifference2(String s, String t) {
    	char[] ss = s.toCharArray();
    	char[] st = t.toCharArray();
    	int s1 = 0,s2 = 0;
    	for(int i = 0 ;i<ss.length ;i++) {
    		s1 = s1 + ss[i] - '0';
    		s2 = s2 + st[i] - '0';
    	}
    	s2 = s2 + st[ss.length] - '0';
    	return (char)(s2-s1);
    }
}	
