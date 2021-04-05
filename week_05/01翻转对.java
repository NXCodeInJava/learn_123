class Solution {

    private int count; // 这里就是要返回的答案

    public int reversePairs(int[] nums) {
        // 利用归并排序的方法
        if(nums==null||nums.length<2) return 0;
        
        count = 0;
        
        mergeSort(nums, 0, nums.length-1); // 原数组，起始下标，结束下标

        return count;
    }

    private void mergeSort(int[] nums, int begin, int end){
        if(begin>=end) return;

        int middle = begin + (end-begin)/2; // 取到中间的下标

        mergeSort(nums, begin, middle);
        mergeSort(nums, middle+1, end); // 把左半边和右半边一直分别归并排序--记住传递的是下标

        int i = begin, j = middle+1, c = 0;

        while(i<=middle&&j<=end){
            if((long)nums[i]>2*(long)nums[j]){
                count+=middle-i+1; // 在左半边，所有比i大的下标，都满足条件
                j++; // 继续找下一个j【nums[j]更大】
            }else{
                i++; // 当前的nums[i]不满足，继续找下一个i【nums[i]更大】
            }
        }

        // 合并 -- 这个是归并排序的必须操作
        int[] cache = new int[end-begin+1]; // 起始就是跟nums一样大，这是新开辟了一个数组
        i = begin;
        j = middle + 1;
        int idx = 0;
        while (i <= middle && j <= end) {
            cache[idx++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= middle) {
            cache[idx++] = nums[i++];
        } 
        while (j <= end) {
            cache[idx++] = nums[j++];
        }
        for (i = 0, j = begin; j <= end; i++, j++) {
            nums[j] = cache[i];
        }
    }
}