class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> current=new ArrayList<>();
        for(int i=1;i<=9;i++){
                generateNextNumbers(i,n,current);
        }
        return current;
    }

        public void generateNextNumbers(int num,int n,List<Integer> current){
            if(num>n) return;
            current.add(num);
            for(int i=0;i<=9;i++){
                if(num*10+i>n){
                    break;
                }else{
                    generateNextNumbers(num*10+i,n,current);
                }
            }


        }
    
    
    
}