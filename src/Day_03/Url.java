package Day_03;
import java.util.Scanner;

/**
 * https://leetcode-cn.com/problems/string-to-url-lcci/
 * 面试题 01.03. URL化
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串
 * 尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：
 * 用Java实现的话，请使用字符数组实现，以便直接在数组上操作。） 
 * @param args
 */

public class Url {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int len = sc.nextInt();
		System.out.println(replaceSpaces_4(s, len));
		sc.close();

	}

	// 瑙ｆ硶涓�: 浣跨敤StringBuilder鏉ュ疄鐜�(鏃堕棿31)		stringbuilder鏄嚎绋嬩笉瀹夊叏绫伙紝姣攕tringbuffer鏇村揩
	public static String replaceSpaces(String S, int length) {
		char[] tmp = S.toCharArray();
		StringBuilder tmp2 = new StringBuilder();
		/*
		 * for(char x:tmp){ if(x == ' '){ tmp2.append("%20");
		 * //杩欐槸閿欒鐨則mp姣忔閮戒細鏈夊浣欑殑绌烘牸琚墽琛� }else{ tmp2.append(String.valueOf(x)); } }
		 */

		for (int i = 0; i < length; i++) { // 涓嶈蹇界暐棰樼洰鎵�缁欑殑宸茬煡鏁扮粍闀垮害锛屽惁鍒欏綋绋嬪簭杩涜鍒版渶鍚庝細澶氬嚭鐜板嚑娆″惊鐜�
			char x = tmp[i];
			if (x == ' ') {
				tmp2.append("%20");
			} else {
				tmp2.append(String.valueOf(x));
			}
		}
		return tmp2.toString();
	}

	// 瑙ｆ硶浜�:锛堟椂闂�11锛�
	public static String replaceSpaces_2(String S, int length) {
		return S.substring(0, length).replace(" ", "%20");
	}

	// 瑙ｆ硶涓�:(鏃堕棿10)
	public static String replaceSpaces_3(String S, int length) {
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
	//瑙ｆ硶鍥涳細鍙屾寚閽堟硶					鎵ц鐢ㄦ椂鐭紝鍐呭瓨娑堣�楅珮锛涘彲浠ュ皢tmp鏁板瓧鏀逛负charAt鏂规硶 锛涘皢浼氬唴瀛樻秷鑰楀ぇ骞呴檷浣庯紝鎵ц鏃堕棿鎻愬崌
	public static String replaceSpaces_4(String S, int length){
      int count=0;
      char[] tmp = S.toCharArray();
      for(int i=0;i<length;i++){	
          if(tmp[i] == ' '){
              count++;						//浣跨敤count鐢ㄤ簬璁＄畻鏇挎崲鍚庣殑瀛楃涓查暱搴︼紝涓嶅拰瑙ｆ硶涓変竴鏍锋氮璐瑰唴瀛�
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
