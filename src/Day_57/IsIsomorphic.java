package Day_57;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            char tmp1 = s.charAt(i);
            char tmp2 = t.charAt(i);
        	if(map.containsKey(tmp1) ) {
        		if(map.get(tmp1) != tmp2) {
        			return false;
        		}
        	}else {
                if(map.containsValue(tmp2)){
                    return false;
                }
        		map.put(tmp1, tmp2);
        	}
        }
        return true;
     }
}
