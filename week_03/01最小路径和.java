    class Solution {
        public int minPathSum(int[][] grid) {
            // 3 steps: a. subproblem; b. dp-array; c. equation
            // grid[m-1][n-1] = min(grid[m-2][n-1]+1, grid[m-1][n-2]+2)
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp_array = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) { // 直接一边循环一边就求值了！
                    if (i == 0 && j == 0) { // 初始条件
                        dp_array[i][j] = grid[i][j];
                    } else if (i == 0) {
                        dp_array[i][j] = dp_array[i][j - 1] + grid[i][j];
                    } else if (j == 0) {
                        dp_array[i][j] = dp_array[i - 1][j] + grid[i][j];
                    } else {
                        dp_array[i][j] = Math.min(dp_array[i - 1][j], dp_array[i][j - 1]) + grid[i][j];
                    }
                }
            }
            return dp_array[m - 1][n - 1];
        }
    }