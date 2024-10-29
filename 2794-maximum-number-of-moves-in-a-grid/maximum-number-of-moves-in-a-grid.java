class Solution {
    public int maxMoves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis=new int[m][n];
        int[][] directions={{-1,1},{0,1},{1,1}};
        int maxMoves=0;
        for(int i=0;i<m;i++){
            Queue<int[]> q=new LinkedList<>();
            q.add(new int[]{i,0}); 
            // Indicates add i as the row no and 0 is for first col since we traverse all elements in 1st col
            while(!q.isEmpty()){
                int[] node=q.poll();
                int row=node[0];
                int col=node[1];

                for(int[] dir:directions){
                    int nrow=row+dir[0];
                    int ncol=col+dir[1];

                    if(nrow>=0 && ncol>=0 && nrow<m && ncol<n && vis[nrow][ncol]==0){
                        if(grid[row][col]<grid[nrow][ncol]){
                            vis[nrow][ncol]=vis[row][col]+1;
                            maxMoves=Math.max(maxMoves,vis[nrow][ncol]);
                            q.add(new int[]{nrow,ncol});

                        }
                    }
                }
            }
        }
        return maxMoves;
    }
}