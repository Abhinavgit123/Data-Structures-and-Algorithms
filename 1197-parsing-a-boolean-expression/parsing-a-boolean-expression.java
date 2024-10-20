class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st=new Stack<>();
         for (char ch : expression.toCharArray()) {
            if(ch=='t' || ch=='f' || ch=='(' || ch==',' || ch=='|' ||ch=='&' || ch=='!'){
                st.push(ch);
            }
            else if(ch==')'){
                Stack<Character> subst=new Stack<>();
                while(st.peek()!='('){
                    subst.push(st.pop());
                }
                st.pop();
                char operator=st.pop();
                boolean res=evaluate(subst,operator);
                st.push(res==true ? 't' : 'f'); 
            }

        }
        return st.pop() == 't' ? true : false;

    }

        public boolean evaluate(Stack<Character> subst,char operator){
            boolean result=false;
                if(operator=='|'){
                     result=false;
                while(!subst.isEmpty()){
                    char c=subst.pop();
                    if(c== 't') result=true;

                    
                     }
                     
                }

                if(operator=='&'){
                     result=true;
                while(!subst.isEmpty()){
                    char c=subst.pop();
                    if(c== 'f') result=false;

                    
                     }
                     
                }
                if(operator=='!'){
                    result= subst.pop()=='t' ? false : true;
                }
            return result;
        }

    
}