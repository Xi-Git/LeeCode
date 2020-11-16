package Day_03;

import java.util.Scanner;

public class Url {

	/**
	 * https://leetcode-cn.com/problems/string-to-url-lcci/
	 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，
	 * 并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int len = sc.nextInt();
		System.out.println(replaceSpaces_4(s, len));

	}

	// 解法一: 使用StringBuilder来实现(时间31)		stringbuilder是线程不安全类，比stringbuffer更快
	public static String replaceSpaces(String S, int length) {
		char[] tmp = S.toCharArray();
		StringBuilder tmp2 = new StringBuilder();
		/*
		 * for(char x:tmp){ if(x == ' '){ tmp2.append("%20");
		 * //这是错误的tmp每次都会有多余的空格被执行 }else{ tmp2.append(String.valueOf(x)); } }
		 */

		for (int i = 0; i < length; i++) { // 不要忽略题目所给的已知数组长度，否则当程序进行到最后会多出现几次循环
			char x = tmp[i];
			if (x == ' ') {
				tmp2.append("%20");
			} else {
				tmp2.append(String.valueOf(x));
			}
		}
		return tmp2.toString();
	}

	// 解法二:（时间11）
	public static String replaceSpaces_2(String S, int length) {
		return S.substring(0, length).replace(" ", "%20");
	}

	// 解法三:(时间10)
	public static String replaceSpaces_3(String S, int length) {
		
//        int count=0;					//虽然使用count计数可以减少内存开销但是
//        for(int i=0;i<length;i++){	//15ms
//            if(S.charAt(i) == ' '){
//                count++;
//            }
//        }
        char[] x = new char[length * 3];
		int index = 0;
		for (int i = 0; i < length; i++) {
			char ch = S.charAt(i);
			if (ch == ' ') {
				x[index++] = '%';
				x[index++] = '2';
				x[index++] = '0';
			} else {
				x[index++] = ch;
			}
		}
		return new String(x, 0, index);
	}
	//解法四：双指针法					执行用时短，内存消耗高；可以将tmp数字改为charAt方法 ；将会内存消耗大幅降低，执行时间提升
	public static String replaceSpaces_4(String S, int length){
      int count=0;
      char[] tmp = S.toCharArray();
      for(int i=0;i<length;i++){	
          if(tmp[i] == ' '){
              count++;
          }
      }
      count = length + count*2;
      int m = count-1;
      char[] x= new char[count];
      int i=length-1;
      while( i>=0 ){
    	  if( tmp[i]!= ' '){
    		  x[m--] = tmp[i];
    	  }else{
    		  x[m--] = '0';
    		  x[m--] = '2';
    		  x[m--] = '%';
    	  }
    	  i--;
      }
      return new String(x,0,count);
      
	}

}
