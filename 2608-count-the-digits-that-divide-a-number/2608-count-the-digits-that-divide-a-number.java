class Solution {
    public int countDigits(int num) {
        String str = Integer.toString(num);
        int count = 0;
        for(int i = 0;i<str.length();i++){
            int a = str.charAt(i) - '0';
            if(num%a == 0){
                count++;
            }
        }
        return count;
    }
}