package Day_39;

import java.util.HashMap;
/*
 * https://leetcode-cn.com/problems/lemonade-change/
 * 860. 柠檬水找零
 */
import java.util.Map;

public class Leomon {
	// 使用map解
	public boolean lemonadeChange(int[] bills) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		if (bills[0] != 5) {
			return false;
		}
		for (int i = 0; i < bills.length; i++) {
			if (map.containsKey(bills[i])) {
				map.put(bills[i], map.get(bills[i]) + 1);
			} else {
				map.put(bills[i], 1);
			}

			if (bills[i] == 10) {
				if (map.containsKey(5) && map.get(5) >= 1) {
					map.put(5, map.get(5) - 1);
				} else {
					return false;
				}
			}
			if (bills[i] == 20) {
				int change = 15;
				while (change > 0) {
					if (map.containsKey(10) && map.get(10) >= 1 && change >= 10) {
						map.put(10, map.get(10) - 1);
						change = change - 10;
					} else if (map.containsKey(5) && map.get(5) >= 1) {
						map.put(5, map.get(5) - 1);
						change = change - 5;
					} else {
						return false;
					}
				}

			}
		}

		return true;
	}

	// 使用int 变量写
	public boolean lemonadeChange2(int[] bills) {
		int five = 0, ten = 0;
		for (int bill : bills) {
			if(bill == 5) {
				five++;
			}else if( bill == 10){
				if(five > 0 ) {
					five--;
					ten++;
				}else {
					return false;
				}
			}else {
				if(five>0 && ten>0) {
					five--;
					ten--;
				}else if(five >= 3){
					five = five -3;
				}else {
					return false;
				}
			}
		}
		return true;
	}
}
