class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] array = new int[2];
        if(nums==null||nums.length<2){
            return array;
        }
        A: for (int i=0;i<nums.length-1;i++){
            B: for(int j = i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    array[0]=i;
                    array[1]=j;
                    break A;
                }
            }
        }
        return array;
    }
}