import java.util.List;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int result = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> distinctValues = new HashSet<>();
            for (int j = i; j < n; j++) {
                distinctValues.add(nums.get(j));
                result += distinctValues.size() * distinctValues.size();
            }
        }

        return result;
    }
}
