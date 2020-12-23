package Day_50;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Set<Character> hashset = new HashSet<>();
        char[] ss = s.toCharArray();
        for(int i=0;i<ss.length;i++) {
        	hashset.add(ss[i]);
        }
        String tmp = null;
        Iterator<Character> hashit = hashset.iterator();
        while(hashit.hasNext()) {
        	tmp+= hashit.next();
        }
        return tmp;
    }
}
