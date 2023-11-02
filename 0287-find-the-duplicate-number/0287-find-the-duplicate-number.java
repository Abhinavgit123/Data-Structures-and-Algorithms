    class Solution{
    public static int findDuplicate(int[] nums) {
        for(int num:nums){
            int n=Math.abs(num);
            if(nums[n-1]<0){
                return n;
            }
            nums[n-1]*=-1;
        }

        return -1;
    }
    }