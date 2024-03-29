class Solution {

    // 两种思维都可以解决这道题

    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 第一行
        for (int j = 1; j <= n2; j++) dp[0][j] = dp[0][j - 1] + 1;
        // 第一列
        for (int i = 1; i <= n1; i++) dp[i][0] = dp[i - 1][0] + 1;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
        return dp[n1][n2];  
    }

    // 注意：给dp-array下定义的时候，就下成最终需要的结果！
    public int minDistanceAns(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        //if(len1 == 0 && len2 == 0) return 0;
        if(len1 == 0 || len2 == 0) return len1>=len2?len1:len2;

        // dp: a. subproblem; b. dp-array; c. equation
        //  一直都忘记-升维-这件事！！！
        int[][] dp = new int[len1+1][len2+1]; // dp[i][j]表示word1的0~i位置变到word2的0~j位置，最小的操作数

        for(int j = 1; j<=len2; j++){
            dp[0][j] = dp[0][j-1] + 1; // 第一列的初始化
        }

        for(int i = 1; i<=len1; i++){
            dp[i][0] = dp[i-1][0] + 1; // 第一行的初始化
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
/*
        // 要遍历到最后，不然最后一个填不满
        for(int i = 1; i<=len1; i++){
            for(int j = 1; j<=len2; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else {
                    // 三种情况：1. 删除一个字符；2. 增加一个字符（即目标删除一个字符）；
                    // 3. 替换一个字符
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }*/

        return dp[len1][len2];
    }
}