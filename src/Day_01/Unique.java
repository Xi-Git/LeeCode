package Day_01;
import java.util.HashSet;
import java.util.Scanner;

/***
 * https://leetcode-cn.com/problems/is-unique-lcci/
 * ʵ��һ���㷨��ȷ��һ���ַ��� s �������ַ��Ƿ�ȫ����ͬ��
 * @author MyPC
 *
 */

public class Unique {
	public static void main(String[] args) {
		String s = new String();
		Scanner sc = new Scanner(System.in);
		s = sc.nextLine();
		
		System.out.println(Solution.isUnique(s));
		sc.close();
	}

}
class Solution {
//	�ⷨ1������String�ĺ���
    public static boolean isUnique(String astr) {
		for(int i=0;i<astr.length();i++){
			if(astr.indexOf(astr.charAt(i))!= astr.lastIndexOf(astr.charAt(i))){
				return false;
			}
		}
		return true;
    }
    
//    �ⷨ��:����String��ÿ�α���ʹ��indexof(c,index)�������ĺ����Ƿ��и��ַ�
    public boolean isUnique_3(String astr) {
        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            //�鿴�����Ƿ��е�ǰ�ַ�
            if (astr.indexOf(c, i + 1) != -1)
                return false;
        }
        return true;
    }

    
//    �ⷨ��:����hashSet�Ĳ����ظ�
    public static boolean isUnique_2(String astr) {
    	HashSet<Character> es = new HashSet<Character>();
    	for(char c : astr.toCharArray()){
            if(!es.add(c)) {
                return false;
            }
        }
		return true;
    }
    
}
