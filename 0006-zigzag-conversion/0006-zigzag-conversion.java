class Solution {
    public String convert(String s, int numRows) {
        // https://www.youtube.com/watch?v=hwuUvJpQ1tI

        if(numRows<=1) return s;

        StringBuilder[] sbs=new StringBuilder[numRows];
        for(int i=0;i<sbs.length;i++){
            sbs[i]=new StringBuilder();
        }
        int direction=-1;
        // Because we are going downwards
        int index=0;
        char[] chars=s.toCharArray();

        for(char ch:chars){
            sbs[index].append(ch);
            // it would be like sbs:
                        //             sb[0]=..,sb[1]=..,sb[2]..
            if(index==0 || index==numRows-1){
                direction=0-direction;

                // if going downward i.e index==0 it wld become 0-(-1) hence 1
                // So idx increases

                // if going upward i.e index==numRows-1 it wld become 0-(1) since direction would be 1 hence it decreases 
                // So idx decreases 

            }
            index+=direction;
            // to change index i.e sbs[0] or sbs[1] ..
        }

        StringBuilder res=new StringBuilder();
        // Append all sb
        for(StringBuilder sb:sbs){
            res.append(sb);
        }

        return res.toString();

    }
}