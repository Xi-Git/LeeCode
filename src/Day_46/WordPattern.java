package Day_46;

/**
 * https://leetcode-cn.com/problems/word-pattern/submissions/
 * 290. µ¥´Ê¹æÂÉ
 */

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
		public static void main(String[] args) {
			System.out.println(2<<4);
			System.out.println(40>>2);
		}
	   public boolean wordPattern(String pattern, String s) {
	    	Map<Character,String> patternmap = new HashMap<>();
	    	String[] ss = s.split(" ");
	    	char[] array = pattern.toCharArray();
           if(ss.length!= array.length){
               return false;
           }
	    	for(int i =0;i< array.length;i++) {
	    		if(!patternmap.containsKey(array[i])) {
                   if(!patternmap.containsValue(ss[i])){
                   		patternmap.put(array[i],ss[i]);
                   }else{
                       return false;
                   }
	    		}else {
	    			if(!patternmap.get(array[i]).equals(ss[i])) {
	    				return false;
	    			}
	    		}
	    	}

//	    	String[] tmp = new String[array.length];
//	    	for(int i =0 ; i<array.length;i++) {
//	    		if(patternmap.containsKey(array[i])) {
//	    			tmp[i]=patternmap.get(array[i]);
//	    		}else {
//	    			return false;
//	    		}
//	    	}
//           for(int i =0;i<ss.length;i++){
//               if(!tmp[i].equals(ss[i])){
//                   return false;
//               }
//           }
           return true;
	    }
}
