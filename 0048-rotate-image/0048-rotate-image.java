class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=i;j<m;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        // shift matrix to 147
                        // 258
                        // 369
        for(int i=0;i<n;i++){
            for(int j=0;j<m/2;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][m-j-1];
                matrix[i][m-j-1]=temp;

            }
        }
        // shift 1st col and last col elements
    }
}