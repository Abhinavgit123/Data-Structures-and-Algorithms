class Solution {
    public String licenseKeyFormatting(String s, int k) {
        int count=0;
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)!='-'){
                sb.append(Character.toUpperCase(s.charAt(i)));
                count++;
            }
            if(count==k){
                sb.append('-');
                count=0;
            }
        }
        if(sb.length()>0 && sb.charAt(sb.length()-1)=='-'){
            sb=new StringBuilder(sb.substring(0,sb.length()-1));
        }
        sb.reverse();
        return sb.toString();
    }
}