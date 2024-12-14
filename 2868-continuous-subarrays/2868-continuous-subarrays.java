class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;
        long totalSubarrays = 0;
        
        // TreeMap to keep track of the counts of elements in the current window
        TreeMap<Integer, Integer> window = new TreeMap<>();

        while (right < n) {
            // Add the current element to the window
            window.put(nums[right], window.getOrDefault(nums[right], 0) + 1);

            // Check if the current window is valid
            while (window.lastKey() - window.firstKey() > 2) {
                // Remove the element at left pointer from the window
                window.put(nums[left], window.get(nums[left]) - 1);
                if (window.get(nums[left]) == 0) {
                    window.remove(nums[left]);
                }
                left++;
            }

            // All subarrays ending at `right` and starting from `left` to `right` are valid
            totalSubarrays += right - left + 1;

            // Move the right pointer to expand the window
            right++;
        }

        return totalSubarrays;
    }
}