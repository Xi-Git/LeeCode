package Day_41;

import java.util.ArrayList;

public class PredictPartyVictory {
	public String predictPartyVictory(String senate) {
		char[] people = senate.toCharArray();
        int len = people.length;
		boolean[] R = new boolean[len];
        int Radiant = 0,Dire = 0;
        for (int i = 0; i < len; i++) {
            if(people[i] == 'R'){
                Radiant++;
            }else{
                Dire++;
            }
        }
        while(Radiant>=0 && Dire>=0){				//此处可以不使用这两个变量进行统计人数
		for (int i = 0; i < len; i++) {
			if (R[i]) {
				continue;
			}
			if (people[i] == 'R') {
				int tmp = find(i, 'D', people, R);
				if (tmp == -1) {
					return new String("Radiant");
				} else {
					R[tmp] = true; // 为true则不可以发言
                    Dire--;
				}
			} else {
				int tmp = find(i, 'R', people, R);
				if (tmp == -1) {
					return new String("Dire");
				} else {
					R[tmp] = true; // 为true则不可以发言
                    Radiant--;
				}
			}
		}
        }

        return new String("");
	}

	public static int find(int index, char x, char[] people, boolean[] R) {
		for (int i = index + 1; i < people.length; i++) {
			if (people[i] == x && R[i] == false) {
				return i;
			}
		}
		for (int i = 0; i < index; i++) {
			if (people[i] == x && R[i] == false) {
				return i;
			}
		}
		return -1;
	}
}
