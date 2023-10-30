class Solution {
    public int minOperations(List<Integer> nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        int totalOperations=0;
        for(int i=nums.size()-1;i>=0;i--){
            totalOperations++;
            if(nums.get(i)<=k){
                set.add(nums.get(i));
            }
            if(set.size()==k)
            break;
        }
        return totalOperations;
    }
}