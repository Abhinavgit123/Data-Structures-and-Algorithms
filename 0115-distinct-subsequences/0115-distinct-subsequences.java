class Solution {
    static int prime = (int)(Math.pow(10,9)+7);
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[][] dp=new int[n][m];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
       return distinct(s,t,n-1,m-1,dp);
    }
    public int distinct(String s,String t,int i,int j,int[][] dp){
         if(j<0){
            return 1; //We exhausted 2nd string hence match found
        }
        
        if(i<0){
            return 0; //No match found
        }
       
        if(dp[i][j]!=-1) return dp[i][j];

        if(s.charAt(i)==t.charAt(j)){
            int foundMatchMoveToNext=distinct(s,t,i-1,j-1,dp);
            int foundMatchButStay=distinct(s,t,i-1,j,dp);
            return dp[i][j]=(foundMatchMoveToNext+foundMatchButStay)%prime;
        }
        else{
            return dp[i][j]=distinct(s,t,i-1,j,dp);
        }
    }
}