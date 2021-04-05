class Solution {
    public int racecar(int target) {
        // 一开始在原点0，target一定在正向上
        // int position = 0, speed = 1;

        // 动态规划 dp[i]是到达i（target）点时的最短指令长度
        // 1. 如果可以全都用A，即i是1,2,4,8,...等比数列前n项和：Sn = 2^n - 1 -> dp[i] = n
        // 2. 先走n步，越过了i，要回头需要用1个R，到目前走了n+1步，剩下的距离是2^n-1-i【i是target】
        // 3. 先走n步，还没到i，但是先回头走back步，还剩下的距离是target - ((2^n-1) - (2^back-1))

        if (target <= 0) {
            return 0;
        }

        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 1; i <= target; i++) {
            //先向前走 forward 步
            for (int forward = 1; (1 << forward) - 1 < 2 * i; forward++) {
                //向前走了forwardDistance
                int forwardDistance = (1 << forward) - 1;
                //对应第一种情况，走了forward步直接到达i
                if (forwardDistance == i) {
                    dp[i] = forward;
                } else if (forwardDistance > i) { //对应第二种情况，越过了i
                    // +1 是因为回头需要一个R指令
                    dp[i] = Math.min(dp[i], 
                            forward + 1 + dp[forwardDistance - i]);
                } else { //对应第三种情况，没有越过i
                    //先回头走backward步
                    for (int backward = 0; backward < forward; backward++) {
                        int backwardDistance = (1 << backward) - 1;
                        //第一个+1是还没到达i，先回头，使用一个R
                        //第二个+1是回头走了backwardDistance，再使用R回头走向i
                        dp[i] = Math.min(dp[i], 
                                forward + 1 + backward + 1 + dp[i - forwardDistance + backwardDistance]);
                    }
                }
            }
        }
        return dp[target];
    }
}