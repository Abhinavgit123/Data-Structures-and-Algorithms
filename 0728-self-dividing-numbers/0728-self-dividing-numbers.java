class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res=new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(selfDividing(i)){
                res.add(i);
            }
        }
        return res;
    }

    public boolean selfDividing(int nums){
        int originalNum=nums;

        while(nums>0){
            int digit=nums%10;
            if(digit==0 || originalNum%digit!=0){
                return false;
            }
            nums/=10;
        }
        return true;
    }
}