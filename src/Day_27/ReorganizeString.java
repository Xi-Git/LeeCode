package Day_27;

/*
 * https://leetcode-cn.com/problems/reorganize-string/
 * 767. �ع��ַ���
 * ����һ���ַ���S������Ƿ��������Ų����е���ĸ��ʹ�������ڵ��ַ���ͬ��
 * �����У����������еĽ�����������У����ؿ��ַ���
 * 
 */

public class ReorganizeString {
	
	//ʹ��������
    public String reorganizeString2(String S) {
        //���ַ���Sת��Ϊ�ַ�����
        char[] alphabetArr = S.toCharArray();
        //��¼ÿ���ַ����ֵĴ���
        int[] alphabetCount = new int[26];
        //�ַ����ĳ���
        int length = S.length();
        //ͳ��ÿ���ַ����ֵĴ���
        for (int i = 0; i < length; i++) {
            alphabetCount[alphabetArr[i] - 'a']++;
        }
        int max = 0, alphabet = 0, threshold = (length + 1) >> 1;
        //�ҳ����ִ��������Ǹ��ַ�
        for (int i = 0; i < alphabetCount.length; i++) {
            if (alphabetCount[i] > max) {
                max = alphabetCount[i];
                alphabet = i;
                //������ִ��������Ǹ��ַ�������������ֵ��˵��������ʹ��
                // �����ڵ��ַ���ͬ��ֱ�ӷ��ؿ��ַ�������
                if (max > threshold)
                    return "";
            }
        }
        //����һ��˵��������ʹ�������ڵ��ַ���ͬ��������㷵��һ�������res���Ƿ���
        //�����������ʽ��������ת��Ϊ�ַ�����
        char[] res = new char[length];
        int index = 0;
        //�Ȱѳ��ִ��������ַ��洢�������±�Ϊż����λ����
        while (alphabetCount[alphabet]-- > 0) {
            res[index] = (char) (alphabet + 'a');
            index += 2;
        }
        //Ȼ���ٰ�ʣ�µ��ַ��洢������λ����
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
    
    
    //ʹ��StringBuffer��
    public String reorganizeString3(String S) {
        int len = S.length();
		//��¼�ַ�������
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
		//�Ȱ���������ַ��̿����ȴ����
		while(arr[idx] > 0) {
			sb.append((char)(idx+'a'));
			arr[idx]--;
		}
		int position = 1;
		for(int i=0; i<arr.length; i++) {
			
			while(arr[i] > 0) {
				//���
				sb.insert(position, (char)(i+'a'));
				arr[i]--;
				//��λ������
				position += 2;
				//��ĩβʱ����ͷ��
				if(position > sb.length()) {
					position = 1;
				}
			}
			
		}
		
		return sb.toString();
    }


}
