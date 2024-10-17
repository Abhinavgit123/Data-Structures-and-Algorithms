class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->(y.count-x.count));
        if(a>0){
            pq.add(new Pair(a,'a'));
        } 
         if(b>0){
            pq.add(new Pair(b,'b'));
        } 
         if(c>0){
            pq.add(new Pair(c,'c'));
        }  
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int count=p.count;
            char character=p.character;

            if(sb.length()>=2 && sb.charAt(sb.length()-1)==character && sb.charAt(sb.length()-2)==character){
                if(pq.isEmpty()) break;
                Pair temp=pq.poll();
                sb.append(temp.character);
                if(temp.count-1>0){
                    pq.add(new Pair(temp.count-1,temp.character));
                }
            }else{
                count--;
                sb.append(character);
            }
            if(count>0){
                pq.add(new Pair(count,character));
            }
        }  
    
        return sb.toString();
    }
}
class Pair{
    int count;
    char character;
    Pair(int count,char character){
        this.count=count;
        this.character=character;
    }
}