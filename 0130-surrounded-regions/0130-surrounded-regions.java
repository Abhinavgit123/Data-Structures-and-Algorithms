class Solution {
    public void solve(char[][] board) {
        if(board.length==0||board==null){
            return;
        }
        int n=board.length;
        int m=board[0].length;
        Queue<Pair> q=new LinkedList<>();


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && (i==0 || i==n-1 || j==0 ||j ==m-1)){
                    q.add(new Pair(i,j));
                    board[i][j]='V';
                }
            }
        }
        int[] drow={-1,0,+1,0};
        int[] dcol={0,+1,0,-1};

        while(!q.isEmpty()){
            int first_=q.peek().first;
            int second_=q.peek().second;
            q.remove();
            for(int i=0;i<4;i++){
                int nrow=first_+drow[i];
                int ncol=second_+dcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && board[nrow][ncol]=='O'){
                    board[nrow][ncol]='V';
                    q.add(new Pair(nrow,ncol));
                }
            }

        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='V'){
                    board[i][j]='O';
                }
            }
        }

    }
}

class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}