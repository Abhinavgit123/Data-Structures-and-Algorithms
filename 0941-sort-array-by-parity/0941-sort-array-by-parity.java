class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left=0,right=0;
        int n=nums.length;
       while(right<n){
           if(nums[right]%2==0){
               int temp=nums[right];
               nums[right]=nums[left];
               nums[left]=temp;
               left++;
           }
           right++;
       }
       return nums;
    }
}