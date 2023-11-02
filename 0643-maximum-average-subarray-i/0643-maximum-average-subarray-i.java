/*
1.Brute force
Time complexity: O(n^2) 
Space complexity: O(1)
*/

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0, ans = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        ans = sum / k;

        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i-k];
            // sliding window technique
            // we initially take the sum and add the current element and remove the initial element
            ans = Math.max(ans, sum / k);
        }
        return ans;
    }
}