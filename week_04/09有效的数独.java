class Solution {
    // 刚刚又没有看清题！！！【，验证已经填入的数字是否有效即可。】！！！

    // 动态规划dp 1. subproblem; 2. dp-array; 3. equation
    // 9个小格子，9条直线，9条竖线
    public boolean isValidSudoku(char[][] board) {
        // 由HashMap组成的数组，每一个数组里面有9个哈希表
        HashMap<Integer, Integer> [] rows = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
            }

        // 遍历这个输入
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num; // 注意这种直接把char转换为int的写法
                    int box_index = (i / 3 ) * 3 + j / 3; // 直接找到当前的[i][j]在哪个box里

                    // 要先放进去，因为后面还要看这个
                    // 确定当前遍历的char[i][j]是属于哪一行，哪一列，哪一个box！
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    if(rows[i].get(n)>1||columns[j].get(n)>1||boxes[box_index].get(n)>1){
                        return false;
                        }
                    }
                    }
                    }
                    return true; 
    }
}