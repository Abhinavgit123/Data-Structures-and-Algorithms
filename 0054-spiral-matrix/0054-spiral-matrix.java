class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        int n=matrix.length;
        int m=matrix[0].length;
        int top=0;
        int left=0;
        int low=n-1;
        int right=m-1;
        while(top<=low && left<=right){
        for(int i=left;i<=right;i++){
            list.add(matrix[top][i]);
        }
            top++;
        for(int i=top;i<=low;i++){
            list.add(matrix[i][right]);
        }
            right--;
            if(top<=low){
             //top<=low this is used to check when there is only 1 line i.e 123
                // 
                // hence we need this check if it goes from r to l
        for(int i=right;i>=left;i--){
        list.add(matrix[low][i]);
        }
        low--;
        }
        if(left<=right){
            // left<=right this is done in case there is only 1 col
            // 1
            // 2
        for(int i=low;i>=top;i--){
        list.add(matrix[i][left]);
        }
        left++;
        }
        }
        return list;

    
    }
}