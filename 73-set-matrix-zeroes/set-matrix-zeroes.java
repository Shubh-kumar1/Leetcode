class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] temp =  new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                temp[i][j] = matrix[i][j];

            }
        
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == 0){
                    for(int row=0; row<n; row++){
                        temp[row][j] = 0;
                    }
                     for(int col=0; col<m; col++){
                        temp[i][col] = 0;
                    }

                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m;j++){
                matrix[i][j] = temp[i][j];
            }
        }
    }
}