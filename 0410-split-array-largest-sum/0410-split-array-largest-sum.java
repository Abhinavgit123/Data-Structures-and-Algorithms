class Solution {
    public boolean isPossible(int[] nums, int k,int n,int mid){
        int count=1;
        int weight=0;
        for(int i=0;i<n;i++){
            if(weight+nums[i]>mid){
                count++;
                weight=nums[i];
            }else{
                weight+=nums[i];
            }
        }
        if(count<=k) return true;
        return false;
    }
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        int left=Arrays.stream(nums).max().getAsInt();
        int right=0;
        for(int weight:nums){
            right+=weight;
        }
        int res=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(isPossible(nums,k,n,mid)){
                    res=mid;
                    right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return res;
    }
}