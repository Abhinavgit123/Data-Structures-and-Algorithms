class Solution {
    public int pivotIndex(int[] nums) {

        // We initialize leftSum =0. Because for index =0 the leftSum is 0 totalSum for this array is 7+2+1+5+4=19

// At index=0, leftSum=0 and  totalSum-array[index] = 19-7 = 12
// Now leftSum and totalSum(which works as rightSum in this case) is not equal . We add array[index] to leftSum , leftSum =7 and  , move index++


        int leftSum=0;
        int totalSum=0;
        for(int i:nums){
            totalSum+=i;
        }

        for(int i=0;i<nums.length;i++){
            totalSum=totalSum-nums[i];

            if(leftSum==totalSum){
                return i;
            }

            leftSum+=nums[i];
        }
        return -1;
    }
}