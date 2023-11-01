class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length()<2) return true;
        if(Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))){
            // This is for fully upper case characters
            for(int i = 1; i < word.length(); i++){
                if(Character.isLowerCase(word.charAt(i))) return false;
            }
        }
        else{
            // this is for fully lower case 
            for(int i = 1; i < word.length(); i++){
                if(Character.isUpperCase(word.charAt(i))) return false;
            }
        }
        // else if 1st letter is uppercase and rest is lower case it will come here
        return true;
    }
}