class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> result=new ArrayList<>();
       Arrays.sort(nums);
       int n=nums.length;
        for(int i=0;i<n-2;i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            // i should not be same as previous hence skip to new element
            // i not 0 check  because nums[i-1] would be -1 hence would return 
            // error

            int j=i+1;
            int k=n-1;

            // for every i j and k would be placed
            while(j<k){

                int sum=nums[i]+nums[j]+nums[k];
                if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }else{
                    // List<Integer> l=new ArrayList<>();
                    // l.add(nums[i]);
                    // l.add(nums[j]);
                    // l.add(nums[k]); 
                    List<Integer> l=Arrays.asList(nums[i],nums[j],nums[k]);
                    result.add(l);
                    j++;
                    k--;
                    // we move j and k to next element.

                    while(j<k && nums[j]==nums[j-1]){
                        j++;
                    }
                     while(j<k && nums[k]==nums[k+1]){
                         k--;
                    }

                    // These 2 while loops are for when we find a match in i and with same i we can find with other j and k elements.since it shld be unique j and k cannot be same as before when it matched.

                }
            }
        }
        return result;
    }
}