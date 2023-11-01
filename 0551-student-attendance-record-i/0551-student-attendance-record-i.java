   class Solution{
    public boolean checkRecord(String s) {
        int lateCount = 0;
        int absenceCount = 0;
        for (char c : s.toCharArray()) {
            if (c != 'L')
                lateCount = 0;
            if (c == 'L') {
                lateCount++;
                if (lateCount == 3)
                    return false;
            }
            if (c == 'A') {
                absenceCount++;
                if (absenceCount == 2)
                    return false;
            }
        }
        return true;
    }
   }