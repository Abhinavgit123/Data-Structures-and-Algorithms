class Solution {
    public void rotate(int[] arr, int k) {
        int n=arr.length;
        k=k%n;

    
    
    reverse(arr,n-k,n-1);
    reverse(arr,0,n-k-1);
    reverse(arr,0,n-1);
    }
    public void reverse(int[] arr,int l,int r){
        while(l<r){
        int temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
        l++;
        r--;
        }
    }
    }
    
