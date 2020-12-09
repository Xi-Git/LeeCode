package Day_09;
/**
 * https://leetcode-cn.com/problems/string-rotation-lcci/
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 * A:判断两字符串的长度
 * B:使用双指针法判断有多少各个相同的字符
 * @param args
 */
public class FlipedString {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isFlipedString(String s1, String s2) {
//		if ( s1.length() != s2.length()){
//			return false;
//		}
//		String s3 = s2.concat(s2);
//		if( s3.indexOf(s1)!= -1 ){
//			return true;
//		}else {
//			return false;
//		}
		
		return s1.length() == s2.length() && s2.concat(s2).indexOf(s1)!= -1;
	}
	
	 public boolean isFlipedString_2(String s1, String s2) {
	        if(s1.length() != s2.length()) return false;

	        int i = 0;
	        int j = 0;
	        int len = 0;
	        while(i != s1.length() && j != s2.length()){
	            if(s1.charAt(i) == s2.charAt(j)){
	                i++;
	                j++;
	                len++;
	            }else{
	                j = 0;
	                i++;
	                len = 0;
	            }
	        }
	        if(i == s1.length()){
	            int k = 0;
	            while(j != s2.length()){
	                if(s2.charAt(j) == s1.charAt(k)){
	                    k++;
	                    j++;
	                    len++;
	                }else{
	                    break;
	                }
	            }
	            return len == s1.length();
	        }
	        return false;
	    }
}
