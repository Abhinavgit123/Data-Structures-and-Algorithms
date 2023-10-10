class Solution {
    public int maxProduct(int[] nums) {
        // traverse both first to last and last to first
        // see tuf lecture
        int ftl=0;
        int ltf=0;
        if(nums.length==1){
            return nums[0];
        }
        int currproduct=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
            currproduct*=nums[i];
            ftl=Math.max(currproduct,ftl);
            }else currproduct=1;
        }
             currproduct=1;
          for(int i=nums.length-1;i>=0;i--){
              if(nums[i]!=0){
            currproduct*=nums[i];
            ltf=Math.max(currproduct,ltf);
            }else currproduct=1;
        }
        int ans=Math.max(ltf,ftl);
        return ans;
    }
}