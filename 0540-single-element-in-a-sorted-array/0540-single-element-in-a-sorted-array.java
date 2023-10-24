class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        int start=0;
        int end=n-1;
        while(start<end){
            if(nums[start]!=nums[start+1]){
                return nums[start];
            }
            if(nums[end]!=nums[end-1]){
                return nums[end];
            }
            start+=2;
            end-=2;
        }
        return nums[start];
    }
}