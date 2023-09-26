class Solution {
    public int maxArea(int[] height) {
    int n=height.length;
     int left=0;
     int right=n-1;
     int maxArea=0;
    //  Calculate the width 
    // Then multiply it with the min of l,r
     while(left<right){
         int width=right-left;
         maxArea=Math.max(maxArea,Math.min(height[left],height[right])*width);
     
     if(height[left]<=height[right]){
         left++;
     }else{
         right--;
     }
     }
     return maxArea;

    }
}