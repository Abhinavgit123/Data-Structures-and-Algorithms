class Solution {
    public int dominantIndex(int[] nums) {
        int greatest=Integer.MIN_VALUE;
        int secondGreatest=Integer.MIN_VALUE;
        int idx=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>greatest){
                secondGreatest=greatest;
                greatest=nums[i];
                idx=i;
            }
            else if(nums[i]>secondGreatest && nums[i]<greatest){
                secondGreatest=nums[i];
            }

        }
        return greatest>=(2*secondGreatest)?idx:-1;
    }
}