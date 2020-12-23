package Day_53;
/***
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * 387. 字符串中的第一个唯一字符
 */
import java.util.LinkedList;
import java.util.List;

public class FirstUniqChar {
	//解法一
    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (s.indexOf(ch) == s.lastIndexOf(ch)) {
                return i;
            }
        }
        return -1;
    }
    
    //解法二
    public int firstUniqChar2(String s) {
        int[] chars=new int[26];
        for(int i=0;i<s.length();i++){
            chars[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(chars[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }
}
