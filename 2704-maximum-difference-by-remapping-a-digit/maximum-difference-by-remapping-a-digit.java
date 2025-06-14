class Solution {
    public int minMaxDifference(int num) {
        String strNum = Integer.toString(num);

        // --- Step 1: Get the max value by replacing first non-9 digit with 9 ---
        char maxReplace = 0;
        for (char c : strNum.toCharArray()) {
            if (c != '9') {
                maxReplace = c;
                break;
            }
        }

        String maxStr = strNum;
        if (maxReplace != 0) {
            maxStr = strNum.replace(maxReplace, '9');
        }

        // --- Step 2: Get the min value by replacing first non-0 digit with 0 ---
        char minReplace = 0;
        for (char c : strNum.toCharArray()) {
            if (c != '0') {
                minReplace = c;
                break;
            }
        }

        String minStr = strNum;
        if (minReplace != 0) {
            minStr = strNum.replace(minReplace, '0');
        }

        int maxVal = Integer.parseInt(maxStr);
        int minVal = Integer.parseInt(minStr);

        return maxVal - minVal;
    }
}