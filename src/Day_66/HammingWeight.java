package Day_66;
/**
 * ��ָ Offer 15. ��������1�ĸ���
 * @author MyPC
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 *
 */


public class HammingWeight {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    	String binary = Integer.toBinaryString(n);
    	int number = 0;
    	int len = binary.length();
    	for(int i=0 ; i< len ;i++) {
    		if(binary.charAt(i)== '1' ) {
    			number ++ ;
    		}
    	}
		return number;
    }
    
    
    public int hammingWeight2(int n) {
    	int number = 0;
    	while( n != 0) {
    		if( (n&1) == 1) {
    			number ++;
    		}
    		n = n >>> 1;
    		/*
    		 * ע��˴� ʹ�õ��� �޷������ƶ����� >> �����ʹ�� >> �ᵼ�´�����ʱ������˲� 1 
    		 * �������µ���ѭ��
    		 * 
    		 * 
    		 */
    	}
    	return number;
    }
	
}
