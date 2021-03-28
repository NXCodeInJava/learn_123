class Solution {
    
    // 遍历每一个点，找到与它连接着的点，
    public int numIslands(char[][] grid) {
        int m = grid.length; // 行
        int n = grid[0].length; // 列

        // boolean[][] markT = new boolean[m+1][n+1]; // 用来标记[i][j]是否被访问到了

        int islandNum = 0;

        for(int i = 0; i<m; i++){
            for(int j=0;j<n; j++){
                if(grid[i][j]=='1'){
                    islandNum++;
                    dfs(i, j, grid, m, n);
                }
            }
        }

        return islandNum;
    }

    private void dfs(int i, int j, char[][] grid, int m, int n){
        if(!isInArea(i, j, m, n)) return; // 不在图范围内就直接返回
        if(grid[i][j]!='1') return; // 不是未访问过的岛屿就直接返回
        grid[i][j] = '2'; // 标记当前岛屿为已访问过-这种做法更简洁
        
        // 依次访问与[i][j]上下左右相邻的4个节点
            dfs(i-1, j, grid, m, n);

            dfs(i+1, j, grid, m, n);
        
            dfs(i, j-1, grid, m, n);
       
            dfs(i, j+1, grid, m, n);        
    }

    private boolean isInArea(int i, int j, int m, int n){
        return i>=0&&i<m&&j>=0&&j<n;
    }
}