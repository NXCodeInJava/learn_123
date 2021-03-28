class Solution {
    // 正方形的矩阵
    // dfs/bfs?
    // 对于任意一点，可以找齐
    // 这种数据结构叫【无向图】
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected[0].length; // 无向图的顶点个数
        boolean[] isVisited = new boolean[n]; // 每一个顶点是否被访问了-这个一定要记住！
        int provNum = 0;

        for(int i=0; i<n; i++){ // 遍历每一个顶点
            if(!isVisited[i]){ // 如果没有访问过
                provNum++; // 那它至少可以组成一个省
                dfs(i, isVisited, isConnected); // 以这个点为当前层，dfs找出所有与它直接or间接连接的点！
            }
        }
        return provNum;
    }

    private void dfs(int curPoint, boolean[] isVisited, int[][] isConnected){
        isVisited[curPoint] = true; // 来访问它了！
        for(int j=0;j<isConnected.length;j++){ // 继续遍历所有顶点（因为也还不知道哪个是跟curPoint连着的）
            if(isConnected[curPoint][j]==1&&!isVisited[j]){ // isConnected[i][j] == isConnected[j][i]，所以[curPoint][j]和[j][curPoint]是一样的，然后找的是与curPoint连着的点，且没有访问过的！
                dfs(j, isVisited, isConnected); // 继续往下面的顶点找！！！
            }
        }
    }
}