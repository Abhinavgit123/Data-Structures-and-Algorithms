class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
         int m = mat.length;    // Number of rows
        int n = mat[0].length; // Number of columns
        
        // Map to store the position of each number in the matrix
        Map<Integer, int[]> positionMap = new HashMap<>();
        
        // Fill the positionMap with each number's row and column position
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                positionMap.put(mat[i][j], new int[]{i, j});
            }
        }

        // Arrays to count the painted cells in each row and column
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        
        // Iterate through the array arr to simulate painting
        for (int i = 0; i < arr.length; i++) {
            int[] position = positionMap.get(arr[i]);
            int row = position[0];
            int col = position[1];
            
            // Paint the current cell by incrementing row and column counts
            rowCount[row]++;
            colCount[col]++;
            
            // Check if any row or column is completely painted
            if (rowCount[row] == n || colCount[col] == m) {
                return i;
            }
        }
        
        // If no row or column is completely painted (shouldn't happen)
        return -1;
    }
}