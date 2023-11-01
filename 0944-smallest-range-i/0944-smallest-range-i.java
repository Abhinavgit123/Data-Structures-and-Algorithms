class Solution {
    public int smallestRangeI(int[] arr, int k) {
        int min = arr[0];
        int max = arr[0];
        for(int i=1;i<arr.length;i++) {
            min=Math.min(min,arr[i]);
            max=Math.max(max,arr[i]);
        }
        min =(max-k)-(min+k);
        return min<0?0:min;
    }
}


// We want to get min diff between max and min element of array. to get that difference minimum you can subtract and add any value ranging from -k to k. the idea here is to get difference of min and max only. so rest of element dont matter to us.
// so if an array of positive number is given how can we get min diff between max and min element. simple -> just increase min value and decrease max value.
// algo -
// just find min and max first from array in o(n) time. now just add -k to max element and +k to min element. and return the difference.
// As per test case when difference is negative return 0.