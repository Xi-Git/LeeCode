package Day_37;

/*
 * https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/
 * ����
 * 842. �������ֳ�쳲���������
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SplitIntoFibonacci {
	List<List<Integer>> res = new LinkedList<>();
	public List<Integer> splitIntoFibonacci(String S) {
	    List<Integer> res=new ArrayList<>();
	    backtrack(S,0,res);
	    return res;
	}

	public boolean backtrack(String s,int start,List<Integer> res){
	    if(start==s.length()){
	        //��start==s.length()ʱ���������������ܷ񹹽���쳲��������������res���Ž��
	        return res.size()>2;
	    }
	    long curNum=0; 
	    for(int i=start;i<s.length();i++){
	        //����֦��ÿ�����ֲ�����ǰ���㣬���Ǳ�ʾ��λ��0
	        if(s.charAt(start)-'0'==0&&i!=start)break;
	        //����֦������Ϊ32Ϊ���ͷ�Χ
	        curNum=curNum*10+s.charAt(i)-'0';
	        if(curNum>Integer.MAX_VALUE)break;
	        //����Ҫ����쳲���������F[i] + F[i+1] = F[i+2]����������ʱֱ�Ӽ��룩
	        if(res.size()>=2){
	            int pre2NumSum=res.get(res.size()-1)+res.get(res.size()-2);
	            //����֦���������presum�����Ķ��ᳬ��������������
	            if((int) curNum>pre2NumSum)break;
	            //���С��presum��������һ��ѭ��
	            else if((int) curNum<pre2NumSum)continue;
	            //���ǡ�õ�������쳲��������򣬽�����һ��
	        }
	        //�����㷨���֣��Ƚ���ǰ���ּ���res
	        res.add((int) curNum);
	        //�������ĵݹ�ȫ������false�����ھͿ��Է���true�����벢����
	        if(backtrack(s,i+1,res)){
	            return true;
	        }
	        //����ǰ�Ĳ�ֲ�����������remove
	        res.remove(res.size()-1);
	    }
	    return false;
	}
}
