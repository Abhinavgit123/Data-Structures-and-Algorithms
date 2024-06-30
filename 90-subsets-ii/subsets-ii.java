

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to handle duplicates
        helper(0, set, ans, nums);
        result.addAll(set);
        return result;
    }

    public void helper(int ind, Set<List<Integer>> set, List<Integer> ans, int[] nums) {
        if (ind == nums.length) {
            set.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums[ind]);
        helper(ind + 1, set, ans, nums);
        ans.remove(ans.size() - 1);
        helper(ind + 1, set, ans, nums);
    }
}
