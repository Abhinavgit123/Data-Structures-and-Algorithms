class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         HashMap<String,List<String>> map=new HashMap<>();
         if (strs == null || strs.length == 0) return new ArrayList<>();
             for (String s : strs) {
                 char[] ch=new char[26];
                 for(char c:s.toCharArray()){
                     ch[c-'a']++;
                 }
                 String keyStr=String.valueOf(ch);
                //  Will store this as key and string as value
                 if(!map.containsKey(keyStr)){
                     map.put(keyStr,new ArrayList<>());
                    //  Used to declare new Arraylist whenever its a new anagram 
                    // this loop is Used only for creating a new arraylist
                 }
                 map.get(keyStr).add(s);

        }
        return new ArrayList<>(map.values());
        // the values will be of List<String> already
    }
}