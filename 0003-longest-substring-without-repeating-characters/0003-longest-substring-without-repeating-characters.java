class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int l=0,r=0;
        int len=0;
        int n=s.length();
        while(r<n){
            if(map.containsKey(s.charAt(r))){
                // if element already present add it to the next index of the current index of that element 

                l=Math.max(map.get(s.charAt(r))+1,l);
            }
            
            map.put(s.charAt(r),r);
            // Update right as well and find the max
            len=Math.max(len,r-l+1);
            r++;
        }
        return len;
    }
}