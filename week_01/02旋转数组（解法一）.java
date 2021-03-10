class Solution {
    public void rotate(int[] nums, int k) {
        int[] numsDes = new int[nums.length];
        System.arraycopy(nums, nums.length-k,numsDes,0,k);
         System.arraycopy(nums, 0,numsDes,k,nums.length-k);
         nums=numsDes;

    }
}