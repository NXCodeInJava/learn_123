class Solution {
    public void moveZeroes(int[] nums) {
        //int zeroNum = 0;
        for(int i=0;i<nums.length-1;i++){
            int j = i+1;
            if(nums[i]==0){
                while(j<nums.length){
                    if(nums[j]!=0){
                        nums[i]=nums[j];
                        nums[j]=0;
                        break;
                    }else{
                        j++;
                    }
                }
            }
        }
    }
}