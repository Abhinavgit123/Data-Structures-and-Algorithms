class Solution {
    public String customSortString(String order, String s) {
        Map<Character,Integer> map=new HashMap<>();
        int k=order.length();
        int n=s.length();
        for(int i=0;i<n;i++){
            char letter=s.charAt(i);
            map.put(letter,map.getOrDefault(letter,0)+1);
        }
        StringBuilder result=new StringBuilder();
        for(int j=0;j<k;j++){
            char letter=order.charAt(j);
            while(map.getOrDefault(letter,0)>0){
                result.append(letter);
                map.put(letter,map.get(letter)-1);
            }
        }

        for(char letter:map.keySet()){
            int count=map.get(letter);
            while(count>0){
                result.append(letter);
                count--;
            }
        }
        return result.toString();
    }
}