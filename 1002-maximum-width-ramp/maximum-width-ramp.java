class Solution {
    public int maxWidthRamp(int[] nums) {
        int n=nums.length;
        int[] maxarr=new int[n];
        maxarr[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            maxarr[i]=Math.max(nums[i],maxarr[i+1]);
        }
        int left=0,right=0,maxwidth=0;
        while(right<n){
            while(left<right && nums[left]>maxarr[right]){
                left++;
            }
            maxwidth=Math.max(maxwidth,right-left);
            right++;
        }
        return maxwidth;
    }
}