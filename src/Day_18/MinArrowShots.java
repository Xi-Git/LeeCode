package Day_18;

/*
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * �ڶ�ά�ռ�����������ε����򡣶���ÿ�������ṩ��������ˮƽ�����ϣ�
 * ����ֱ���Ŀ�ʼ�ͽ������ꡣ��������ˮƽ�ģ����������겢����Ҫ��
 * ���ֻҪ֪����ʼ�ͽ����ĺ�������㹻�ˡ���ʼ��������С�ڽ������ꡣ
 * һ֧������������ x ��Ӳ�ͬ����ȫ��ֱ������������� x �����һ֧����
 * ����һ�������ֱ���Ŀ�ʼ�ͽ�������Ϊ xstart��xend�� ������ 
 *  xstart �� x �� xend���������ᱻ��������������Ĺ���������û�����ơ� 
 *  ����һ�������֮�󣬿������޵�ǰ�����������ҵ�ʹ����������ȫ��������������Ĺ�������С������
 *  ����һ������ points ������ points [i] = [xstart,xend] �������������������������������С��������
 */


import java.util.Arrays;
import java.util.Comparator;

public class MinArrowShots {
	public int findMinArrowShots(int[][] points){
        if(points.length <= 1){
            return points.length;
        }
		Arrays.sort(points,new Comparator<int[]>() {
			public int compare(int[] point1,int[] point2) {
				return (point1[0]>point2[0])?1:-1;
			}
		});
		
		int start = points[0][0],end = points[0][1];
		int count = 1;
		for(int i=0;i<points.length;i++) {
			if(points[i][0] <= end ) {
				start = Math.max(points[i][0], start);
				end = Math.min(points[i][1], end);
			}else {
				count++;
				start = points[i][0];
				end = points[i][1];
			}
		}
		return count;
	}
	
	


}
