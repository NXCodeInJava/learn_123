class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int p = 0;
        int q = 1;
        int dupNum = 0;
        while(q<nums.length){
            if(nums[p]!=nums[q]){
                nums[p+1]=nums[q];
                p++;
            }else{
                dupNum++;
            }
            q++;
        }
        

        // for (int i=0;i<nums.length-2;i++){
        //     int j=i+1;//当前元素始终跟下一个比较
        //     while(j<nums.length-1){
        //         if(dupNum==nums.length-1){
        //             break;
        //         }
        //         if(nums[i]==nums[j]){
        //             nums[j]=nums[j+1];//把下一个调到前面来
        //             dupNum++;
        //         }
        //         else{ //两个不相等了，就要比下一个了
        //             break;
        //         }
        //     }
        // }
        return (nums.length-dupNum);

    }
}