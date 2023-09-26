class Solution {
    public int strStr(String haystack, String needle) {
        int l=haystack.length();
        int k=needle.length();
        if(l<k){
            return -1;
        }
        if(k==0){
            return 0;
        }
        int threshold=l-k;
        for(int i=0;i<=threshold;i++){
            if(haystack.substring(i,i+k).equals(needle))
            return i;
        }
        return -1;
    }
}