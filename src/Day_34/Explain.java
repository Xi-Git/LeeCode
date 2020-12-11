package Day_34;

import java.util.ArrayList;
import java.util.List;
/**
 * https://leetcode-cn.com/problems/goal-parser-interpretation/
 * 1678. Éè¼Æ Goal ½âÎöÆ÷
 * @author MyPC
 *
 */
public class Explain {
    public String interpret(String command) {
    	char[] list = command.toCharArray();
    	StringBuilder tmp = new StringBuilder();
    	tmp.append('G');
    	for(int i=1;i<list.length;i++) {
    		if(list[i] == '(') {
    			if(list[i+1] ==')') {
	    			i=i+1;
	    			tmp.append('o');
	    		}
    		}else {
    			if(list[i] != ')') {
	    			tmp.append(list[i]);
    			}
    		}
    	}
    	return tmp.toString();
    }
}
