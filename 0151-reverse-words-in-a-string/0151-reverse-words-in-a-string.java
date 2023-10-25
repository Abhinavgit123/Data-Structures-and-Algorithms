class Solution {
    public String reverseWords(String s) {
        String[] stringArray=s.split(" ");
        StringBuilder result=new StringBuilder();
        for(int i=stringArray.length-1;i>=0;i--){
            if(!stringArray[i].isEmpty()){
            result.append(stringArray[i]).append(" ");
        }
        }
        return result.toString().trim();
    }
}