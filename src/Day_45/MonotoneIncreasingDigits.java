package Day_45;

import java.util.Arrays;

import com.sun.org.apache.bcel.internal.generic.AALOAD;

/**
 * https://leetcode-cn.com/problems/monotone-increasing-digits/ 738. 单调递增的数字
 * 
 * @author MyPC
 *
 */

public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        char[] strN = Integer.toString(N).toCharArray();
        int i = 1;
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i += 1;
        }
        if (i < strN.length) {
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i -= 1;
            }
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));
    }
}
