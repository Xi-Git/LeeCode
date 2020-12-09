package Day_08;
/**
 * https://leetcode-cn.com/problems/zero-matrix-lcci/ 编写一种算法，若M ×
 * N矩阵中某个元素为0，则将其所在的行与列清零。
 * 
 * @param args
 */
public class SetZeroes {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	//执行用时：1 ms	, 在所有 Java 提交中击败了	99.97%	的用户
	//内存消耗：	39.8 MB	, 在所有 Java 提交中击败了	95.06%	的用户
	public void setZeroes(int[][] matrix) {
		//行数=数组名.length,	高度		列数=数组名[0].length;长度
		boolean colZero = false;
		boolean rowZero = false;
		
		for (int i = 0;i < matrix.length ;i++){
			for (int j=0;j<matrix[0].length ;j++){
				if(matrix[i][j] == 0){
					if(i == 0){
						colZero = true;
					}
					if(j == 0){
						rowZero = true;
					}
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		for(int i=1; i< matrix.length  ;i++ ){
			if(matrix[i][0] == 0){
				for(int j=1;j<matrix[0].length;j++){
					matrix[i][j] = 0;
				}
			}
		}
		for(int i=1; i < matrix[0].length ;i++){
			if(matrix[0][i] == 0 ){
				for(int j=1;j<matrix.length;j++){
					matrix[j][i] = 0;
				}
			}
		}
		
		if(colZero){
			for(int i=0;i<matrix[0].length;i++){
				matrix[0][i]=0;
			}
		}
		if(rowZero){
			for(int i=0;i<matrix.length;i++){
				matrix[i][0]=0;
			}
		}
		
	}
}
