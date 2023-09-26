class Solution {
    public int majorityElement(int[] arr) {
        int ele=0;
        int count=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(count==0){
                count=1;
                ele=arr[i];
            }
            else if(ele == arr[i]){
                count++;
            }
            else{
                count--;
            }
        }
        int counter=0;
        for(int j=0;j<n;j++){
            if(arr[j]==ele){
                counter++;
            }
            if(counter>n/2){
                return ele;
            }
        }
        return -1;
    }
}