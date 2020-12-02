package Day_27;

/*
 * https://leetcode-cn.com/problems/reorganize-string/
 * 767. 重构字符串
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 若可行，输出任意可行的结果。若不可行，返回空字符串
 * 
 */

public class ReorganizeString {
	
	//使用数组做
    public String reorganizeString2(String S) {
        //把字符串S转化为字符数组
        char[] alphabetArr = S.toCharArray();
        //记录每个字符出现的次数
        int[] alphabetCount = new int[26];
        //字符串的长度
        int length = S.length();
        //统计每个字符出现的次数
        for (int i = 0; i < length; i++) {
            alphabetCount[alphabetArr[i] - 'a']++;
        }
        int max = 0, alphabet = 0, threshold = (length + 1) >> 1;
        //找出出现次数最多的那个字符
        for (int i = 0; i < alphabetCount.length; i++) {
            if (alphabetCount[i] > max) {
                max = alphabetCount[i];
                alphabet = i;
                //如果出现次数最多的那个字符的数量大于阈值，说明他不能使得
                // 两相邻的字符不同，直接返回空字符串即可
                if (max > threshold)
                    return "";
            }
        }
        //到这一步说明他可以使得两相邻的字符不同，我们随便返回一个结果，res就是返回
        //结果的数组形式，最后会再转化为字符串的
        char[] res = new char[length];
        int index = 0;
        //先把出现次数最多的字符存储在数组下标为偶数的位置上
        while (alphabetCount[alphabet]-- > 0) {
            res[index] = (char) (alphabet + 'a');
            index += 2;
        }
        //然后再把剩下的字符存储在其他位置上
        for (int i = 0; i < alphabetCount.length; i++) {
            while (alphabetCount[i]-- > 0) {
                if (index >= res.length) {
                    index = 1;
                }
                res[index] = (char) (i + 'a');
                index += 2;
            }
        }
        return new String(res);
    }
    
    
    //使用StringBuffer做
    public String reorganizeString3(String S) {
        int len = S.length();
		//记录字符的数量
		int[] arr = new int[26];
		char[] array = S.toCharArray();
		int max = 0;
		int idx = 0;
		for (char c : array) {
			arr[c - 'a']++;
			if(max < arr[c - 'a']) {
				max = arr[c - 'a'];
				idx = c - 'a';
				
			}
		}
		if((len % 2) == 0 && max > len/2) {
			return "";
		}
		if((len & 2) == 1 && max > len/2 + 1) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		//先把数量最多字符铺开，等待插空
		while(arr[idx] > 0) {
			sb.append((char)(idx+'a'));
			arr[idx]--;
		}
		int position = 1;
		for(int i=0; i<arr.length; i++) {
			
			while(arr[i] > 0) {
				//插空
				sb.insert(position, (char)(i+'a'));
				arr[i]--;
				//空位往后移
				position += 2;
				//到末尾时，重头来
				if(position > sb.length()) {
					position = 1;
				}
			}
			
		}
		
		return sb.toString();
    }


}
