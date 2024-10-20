class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
          // Get the arrival and leaving time of the target friend
        int[] targetTime = times[targetFriend];
        
        // Sort times by arrival time
        Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));

        // Number of friends
        int n = times.length;
        
        // Array to track when each chair will be free
        int[] chairTime = new int[n];
       for (int[] time : times) {
            // Look for the first available chair
            for (int i = 0; i < n; i++) {
                // If the chair is free at this friend's arrival time
                if (chairTime[i] <= time[0]) {
                    // Assign the chair to this friend and update when it will be free
                    chairTime[i] = time[1]; // Occupy the chair until the friend leaves
                    
                    // If this is the target friend, return the chair number
                    if (Arrays.equals(time, targetTime)) {
                        return i;
                    }
                    
                    // Move to the next friend
                    break;
                }
            }
        }
        return -1;


    }
}