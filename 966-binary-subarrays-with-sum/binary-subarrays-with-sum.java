class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int left=0,right=0;
        int windowSum=0;
        int count=0;
        while(right<nums.length){
            windowSum+=nums[right];

            while(left<right && windowSum>goal){
                windowSum-=nums[left];
                left++;
            }
            if(windowSum==goal){
                count++;
                int temp=left;
                while(temp<right && nums[temp]==0){
                    count++;
                    temp++;
                }
            }
            right++;
        }
        return count;
    }
}