class Solution {
    public int findMaxLength(int[] nums) {
        //trick is that find the count, if you encounter the same count again 
        // it means that the 0's ans 1's have cancelled out. so it can be a subarray

        int i=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
        int max=0;
        // this is for the case [0,1]
        map.put(0,-1);

        while(i<nums.length){
            if(nums[i]==0){
                count++;
            } else{
                count--;
            }
            if(map.containsKey(count)){
                max=Math.max(max,i-map.get(count));
            }else{
            map.put(count,i);
            }
            i++;
        }
        return max;
    }
}