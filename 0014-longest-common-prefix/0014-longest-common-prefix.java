class Solution {
    public String longestCommonPrefix(String[] strs) {

        // https://leetcode.com/problems/longest-common-prefix/solutions/3174307/well-explained-code-using-strings-in-java/?envType=study-plan-v2&envId=top-interview-150

        Arrays.sort(strs);
        // Sort the arrays since lexicograpphically string from 0 to n-1 will be sorted.hence can compare only the 0th and n-1 strings
        
        String s1=strs[0];
        String s2=strs[strs.length-1];
        int index=0;
        while(index<s1.length() && index<s2.length()){
            if(s1.charAt(index)==s2.charAt(index)){
                index++;
            }else{
                break;
            }
        }
        return s1.substring(0,index);
    }
}