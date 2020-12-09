package Day_16;
import java.util.Arrays;
/**
 * https://leetcode-cn.com/problems/valid-anagram/
 * ���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ����ĸ��λ�ʡ�
 * @author MyPC
 *
 */
public class Reverse {
//	�ⷨһ
    public boolean isAnagram(String s, String t) {
    	int[] x = new int[28];
    	if(s.length() != t.length()) {
    		return false;
    	}
    	if(s.equals(t)) {
    		return true;
    	}

    	for(int i=0;i<s.length();i++) {
    		char tmp = s.charAt(i);
    		x[(int)tmp-97]++;
    	}
    	
    	for(int i=0;i<s.length();i++) {
    		char tmp = t.charAt(i);
    		x[(int)tmp-97]--;
    	}
    	for(int i:x) {
    		if(i!=0)
    			return false;
    	}
    	return true;
    }
//	�ⷨ��
    public boolean isAnagram2(String s, String t) {	
    	if(s.length() != t.length()) {
    		return false;
    	}
    	if(s.equals(t)) {
    		return true;
    	}
    	char[] a =s.toCharArray();
    	char[] b =t.toCharArray();
    	Arrays.sort(a);
    	Arrays.sort(b);
    	for(int i=0;i<a.length;i++) {
    		if(a[i]!=b[i]) {
    			return false;
    		}
    	}
    	return true;
    }
}
