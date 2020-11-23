package Day_18;

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
