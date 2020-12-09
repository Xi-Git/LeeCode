package Day_08;
/**
 * https://leetcode-cn.com/problems/zero-matrix-lcci/ ��дһ���㷨����M ��
 * N������ĳ��Ԫ��Ϊ0���������ڵ����������㡣
 * 
 * @param args
 */
public class SetZeroes {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	//ִ����ʱ��1 ms	, ������ Java �ύ�л�����	99.97%	���û�
	//�ڴ����ģ�	39.8 MB	, ������ Java �ύ�л�����	95.06%	���û�
	public void setZeroes(int[][] matrix) {
		//����=������.length,	�߶�		����=������[0].length;����
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
