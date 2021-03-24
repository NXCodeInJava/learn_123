    class Solution {
        public boolean canCross(int[] stones) {
            // dp: 1. subproblem; 2. dp-array; 3. equation
            // 单位=两个石头数值的差值
            // 成功过河定义：最后一步（k-1, k, k+1）跳在最后一个石头上
            // dp-array应该是
            // 思维盲点：如果觉得一维数组不好想，就想二维数组
            // dp[i][k] -> 某一个石头i，通过跳k步，可以到达，且它的上一个石头是j，k是石头i和j之间的距离
            // 那么对于j石头，因为它跳了k到达了i，所以跳到j，可以跳k，或者k+1，或者k-1
            // dp[i][k] = dp[j][k-1] || dp[j][k+1] || dp[j][k]
            if (stones[1] != 1)
                return false;
            int len = stones.length;
            boolean[][] dp = new boolean[len][len + 1]; // 一共有i个石头，最多可能会有len+1步跳到i上
            dp[0][0] = true; // 青蛙站在第一块石头上
            for (int i = 1; i < len; i++) {
                for (int j = 0; j < i; j++) { // j一定是i的前一块石头
                    int k = stones[i] - stones[j];
                    if (k <= i) { // 第i块石头最多跳的步数是i+1
                        dp[i][k] = dp[j][k - 1] || dp[j][k + 1] || dp[j][k];
                        if (i == len - 1 && dp[i][k])
                            return true; // 跳到最后一块石头啦！
                    }
                }
            }
            return false; // 循环结束了都还没返回true
        }
    }