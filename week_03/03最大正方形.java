class Solution {
    public int maximalSquare(char[][] matrix) {
        // a. subproblem; b. dp-array; c. equation
        // 求正方形的面积：面积=边长^2，dp-array其实就是每一个格子能占用的最大的边长
        // subproblem: 当前格子的上，左，左上都不能是0，边长才能够变更长
        // 为了方便思维以及确定边界条件，以后当前格子，都叫cur[m][m]
        // equation: 当前格子能形成的最大变长，等于
        // dp(cur[m][n]) = min(dp[m-1][n-1], dp[m-1][n], dp[m][n-1]) + 1(它自己要是1)
        int char_row = matrix.length; // 原表的总行数
        int char_col = matrix[0].length; // 原表的总列数
        int[][] dp = new int[char_row+1][char_col+1]; // 这里是看的题解，为了更方便确定边界条件，直接在左上和左下拉出来一行和一列，都是初始值0
        int maxSide = 0; // 只要求最大变长就好了，并不在意是哪一个格子产生的
        for(int i=0;i<char_row;i++){
            for(int j=0;j<char_col;j++){
                if(matrix[i][j]=='1'){ // 是1才有后面的逻辑
                // 直接从[1][1]这一点考虑哦！
                dp[i+1][j+1] = Math.min(Math.min(dp[i+1][j], dp[i][j+1]), dp[i][j]) + 1;
                maxSide = Math.max(maxSide, dp[i+1][j+1]);
                }
            }
        }
        return maxSide*maxSide;
    }
}