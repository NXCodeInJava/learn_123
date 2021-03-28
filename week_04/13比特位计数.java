class Solution {
    public int[] countBits(int num) {
        // 偶数的二进制数中1的个数与它的一半的数的二进制数相同
        // 奇数就是比前面那个偶数多1个1
        // 需要静下心来找到这个规律
        int[] res = new int[num+1]; // 从0开始的
        res[0] = 0;

        for(int i=1;i<=num;i++){
            if(i%2==1){
                res[i] = res[i-1]+1;
                }else{
                    res[i] = res[i/2];
                }
        }
        return res;
    }
}