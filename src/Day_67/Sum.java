package Day_67;

/*
 * ��ָ Offer 64. ��1+2+��+n
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 */

public class Sum {
	int res = 0;
    public int sumNums(int n) {
    	boolean x = n>1 && sumNums(n-1)>0;
    	res += n;
		return res;

    }
    /**
     * �����ѵ������������Ŀ��Ҫ�����ж�ֹͣ����
     */
}
