class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int n=nums.length;
        int currmax=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                currmax+=1;
                max=Math.max(currmax,max);
            }else{
                currmax=0;
            }
        }
        return max;
    }
}