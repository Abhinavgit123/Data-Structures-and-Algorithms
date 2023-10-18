class Solution {
    public int[] twoSum(int[] arr, int target) {
       HashMap<Integer,Integer> map=new HashMap<>();
       int n=arr.length;
       int res[]=new int[2];
       for(int i=0;i<n;i++){
           if(map.containsKey(target-arr[i])){
            res[0]=i;
            res[1]=map.get(target-arr[i]);
           }
           map.put(arr[i],i);
       }
       return res;

    }
}