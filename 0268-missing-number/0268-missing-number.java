class Solution {
    public int missingNumber(int[] arr) {

        int n=arr.length;
        int sum=0;
       for(int num:arr){
           sum+=num;
       }
       return n*(n+1)/2-sum;
    }
}