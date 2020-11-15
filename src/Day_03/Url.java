package Day_03;

import java.util.Scanner;

public class Url {

	/**
	 * https://leetcode-cn.com/problems/string-to-url-lcci/
	 * URL������дһ�ַ��������ַ����еĿո�ȫ���滻Ϊ%20���ٶ����ַ���β�����㹻�Ŀռ��������ַ���
	 * ����֪���ַ����ġ���ʵ�����ȡ���ע����Javaʵ�ֵĻ�����ʹ���ַ�����ʵ�֣��Ա�ֱ���������ϲ�������
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

	// �ⷨһ: ʹ��StringBuilder��ʵ��(ʱ��31)		stringbuilderִ���ٶ�������ʹ��stringbuffer
	public static String replaceSpaces(String S, int length) {
		char[] tmp = S.toCharArray();
		StringBuilder tmp2 = new StringBuilder();
		/*
		 * for(char x:tmp){ if(x == ' '){ tmp2.append("%20");
		 * //���Ǵ����tmpÿ�ζ����ж���Ŀո�ִ�� }else{ tmp2.append(String.valueOf(x)); } }
		 */

		for (int i = 0; i < length; i++) { // ��Ҫ������Ŀ��������֪���鳤�ȣ����򵱳�����е��������ּ���ѭ��
			char x = tmp[i];
			if (x == ' ') {
				tmp2.append("%20");
			} else {
				tmp2.append(String.valueOf(x));
			}
		}
		return tmp2.toString();
	}

	// �ⷨ��:��ʱ��11��
	public static String replaceSpaces_2(String S, int length) {
		return S.substring(0, length).replace(" ", "%20");
	}

	// �ⷨ��:(ʱ��10)
	public static String replaceSpaces_3(String S, int length) {
		
//        int count=0;					//��Ȼʹ��count�������Լ����ڴ濪������
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
	//�ⷨ�ģ�˫ָ�뷨					ִ����ʱ�̣��ڴ����ĸߣ����Խ�tmp���ָ�ΪcharAt���� �������ڴ����Ĵ�����ͣ�ִ��ʱ������
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
