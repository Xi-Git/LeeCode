package Day_49;

public class Rotate {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for(int i = 0 ;i < len ;i++ ){
            for(int j =0; j <= i ; j++){
                int tmp;
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for( int i = 0;i<len ;i++){
            for(int j = 0 ; j < len/2 ;j++){
                int tmp;
                tmp = matrix[i][j];
                matrix[i][j] = matrix[i][len-1-j];
                matrix[i][len-1-j] = tmp;
            }

        }
    }
}
