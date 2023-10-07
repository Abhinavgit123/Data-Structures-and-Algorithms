class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        // it can eat minimum 1 banan at a time

        int right = Arrays.stream(piles).max().getAsInt();
        // it can eat max banans in array at a time

        int res = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long hours = 0; // Change to long data type
            for (int i : piles) {
                hours += (long) Math.ceil((double) i / mid); // Use long data   type

            }

            if (hours <= h) {
                res = Math.min(res, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
