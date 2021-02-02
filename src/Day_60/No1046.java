package Day_60;

import java.util.Arrays;

public class No1046 {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int len = stones.length - 1;
        while (len >= 1) {
            int x = stones[len - 1];
            int y = stones[len];
            int r = x - y >= 0 ? x - y : y - x;
            if (r > 0) {
                len -= 1;
                int i = len - 1;
                while (i >= 0 && stones[i] > r) {
                    stones[i + 1] = stones[i];
                    i--;
                }
                stones[i + 1] = r;
            } else {
                len -= 2;
            }
        }
        return len > -1 ? stones[len] : 0;
    }
}
