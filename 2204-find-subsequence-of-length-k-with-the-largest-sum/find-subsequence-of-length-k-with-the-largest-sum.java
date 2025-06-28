class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
      PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0]) // sort by value
        );

        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(new int[]{nums[i], i});
            if (minHeap.size() > k) {
                minHeap.poll(); // remove the smallest value
            }
        }

        // Extract elements from heap
        List<int[]> topK = new ArrayList<>(minHeap);

        // Sort by original index to maintain subsequence order
        topK.sort(Comparator.comparingInt(a -> a[1]));

        // Build result array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topK.get(i)[0];
        }

        return result;  
    }
}