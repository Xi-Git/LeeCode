package Day_01;
import java.util.HashSet;
import java.util.Scanner;

/***
 * https://leetcode-cn.com/problems/is-unique-lcci/
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
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
//	解法1：利用String的函数
    public static boolean isUnique(String astr) {
		for(int i=0;i<astr.length();i++){
			if(astr.indexOf(astr.charAt(i))!= astr.lastIndexOf(astr.charAt(i))){
				return false;
			}
		}
		return true;
    }
    
//    解法二:遍历String，每次遍历使用indexof(c,index)检查遍历的后面是否还有该字符
    public boolean isUnique_3(String astr) {
        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            //查看后面是否有当前字符
            if (astr.indexOf(c, i + 1) != -1)
                return false;
        }
        return true;
    }

    
//    解法三:利用hashSet的不可重复
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
