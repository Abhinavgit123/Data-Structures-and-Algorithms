class Solution {

    public int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length];
        // If k is 0, return the result directly.
        if (k == 0) {
            return result;
        }
        for (int i = 0; i < result.length; i++) {
            if (k > 0) {
                // If k is greater than 0, store the sum of next k numbers.
                for (int j = i + 1; j < i + k + 1; j++) {
                    result[i] += code[j % code.length];
                }
            } else {
                // If k is less than 0, store the sum of previous -1*k numbers.
               int n = code.length;
                    int start = (i - Math.abs(k) + n) % n; // Calculate the starting index in a circular manner
                    for (int j = 0; j < Math.abs(k); j++) {
                        result[i] += code[(start + j) % n]; // Access elements in a circular manner
                    }


            }
        }
        return result;
    }
}
