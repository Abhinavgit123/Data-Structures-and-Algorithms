class Solution {
    public int takeCharacters(String s, int k) {
         int n = s.length();
         if (k == 0) {
    return 0; // No constraints, so no characters need to be removed.
}
        
        // Step 1: Count total occurrences of each character
        Map<Character, Integer> totalCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            totalCount.put(c, totalCount.getOrDefault(c, 0) + 1);
        }
        
        // Step 2: Check if the condition is even possible
        if (totalCount.getOrDefault('a', 0) < k || 
            totalCount.getOrDefault('b', 0) < k || 
            totalCount.getOrDefault('c', 0) < k) {
            return -1; // Not enough characters to satisfy the condition
        }
        
        // Step 3: Sliding window to minimize the removal window
        int requiredA = totalCount.get('a') - k;
        int requiredB = totalCount.get('b') - k;
        int requiredC = totalCount.get('c') - k;
        
        int left = 0, maxWindow = 0;
        Map<Character, Integer> windowCount = new HashMap<>();
        
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);
            
            // Shrink the window from the left if we exceed the required counts
            while (windowCount.getOrDefault('a', 0) > requiredA || 
                   windowCount.getOrDefault('b', 0) > requiredB || 
                   windowCount.getOrDefault('c', 0) > requiredC) {
                char leftChar = s.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);
                left++;
            }
            
            // Update maxWindow length
            maxWindow = Math.max(maxWindow, right - left + 1);
        }
        
        // Step 4: Calculate minimum minutes
        return n - maxWindow;
    }
}