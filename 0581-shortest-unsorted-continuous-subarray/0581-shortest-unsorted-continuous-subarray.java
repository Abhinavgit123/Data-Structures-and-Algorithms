class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] target=Arrays.copyOf(nums,nums.length);
        Arrays.sort(target);
        int i=0;
        int j=nums.length-1;
        while(i<nums.length && target[i]==nums[i]){
            i++;
        }
        if(i==nums.length){
            return 0;
            // sorted array already
        }
         while(j>=0 && target[j]==nums[j]){
            j--;
        }
        return j-i+1;

    }
}