    class Solution {
        public int countSubstrings(String s) {
            // dp: a. subproblem; b. dp-array; c. equation
            // 思维盲点：dp可以是一个二维数组（把复杂的问题升一个维度就变简单）
            // dp[i][j]表示回文字符串的首尾在s中的位置（可以重合）
            if (s == null || s.isEmpty())
                return 0;
            int resNum = 0;
            boolean[][] dp = new boolean[s.length()][s.length()]; // 思维盲点：注意这种二维数组表示方法
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j <= i; j++) { // 思维盲点：注意这种双指针的写法
                    if (s.charAt(i) == s.charAt(j) && i - j < 2) { // 左右相邻或者就是本身
                        dp[j][i] = true; // j<=i，j是头！注意
                        resNum++;
                    } else if (s.charAt(i) == s.charAt(j) && dp[j + 1][i - 1]) { // 它的第一个子串也是回文串
                        dp[j][i] = true; // j<=i，j是头！注意
                        resNum++;
                    }
                }
            }
            return resNum;
        }
    }