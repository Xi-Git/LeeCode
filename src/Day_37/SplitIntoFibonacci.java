package Day_37;

/*
 * https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/
 * 回溯
 * 842. 将数组拆分成斐波那契序列
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
	        //当start==s.length()时遍历结束，返回能否构建成斐波那契，如果能则res里存放结果
	        return res.size()>2;
	    }
	    long curNum=0; 
	    for(int i=start;i<s.length();i++){
	        //【剪枝】每块数字不能有前导零，除非表示个位数0
	        if(s.charAt(start)-'0'==0&&i!=start)break;
	        //【剪枝】数字为32为整型范围
	        curNum=curNum*10+s.charAt(i)-'0';
	        if(curNum>Integer.MAX_VALUE)break;
	        //数字要满足斐波那契规则F[i] + F[i+1] = F[i+2]（不足三个时直接加入）
	        if(res.size()>=2){
	            int pre2NumSum=res.get(res.size()-1)+res.get(res.size()-2);
	            //【剪枝】如果大于presum则后面的都会超出，不用再算了
	            if((int) curNum>pre2NumSum)break;
	            //如果小于presum，进行下一轮循环
	            else if((int) curNum<pre2NumSum)continue;
	            //如果恰好等于满足斐波那契规则，进行下一步
	        }
	        //回溯算法部分，先将当前数字加入res
	        res.add((int) curNum);
	        //如果后面的递归全部返回false，现在就可以返回true，深入并回溯
	        if(backtrack(s,i+1,res)){
	            return true;
	        }
	        //否则当前的拆分不满足条件，remove
	        res.remove(res.size()-1);
	    }
	    return false;
	}
}
