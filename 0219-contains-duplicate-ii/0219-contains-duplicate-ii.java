   public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<nums.length;i++){
                if(!map.containsKey(nums[i])){
                    map.put(nums[i],i);
                }else{
                    int val=map.get(nums[i]);
                    if(Math.abs(val-i)<=k){
                        return true;
                    }else{
                        map.put(nums[i],i);
                        // This check is used because if we keep the val as it is and we loop further the value will be greater than k only
                        // hence we replace it 
                    }
                }
            }
                return false;

        }
   }