import java.util.HashSet;

public class A123 {

    public int robotSim(int[] commands, int[][] obstacles) {
        // 递归且需要考虑初始状态
        // 每到一个新节点就要考虑是否遇到障碍点
        // 要记录下最新的一点的x坐标以及y坐标
        int x = 0, y = 0; // 初始状态
        int[] curPosition = { x, y };
        int direction = 1; // 1表示北，2表示南，3表示西，4表示东
        HashSet<String> set = new HashSet() {
        };
        for (int i = 0; i < obstacles.length; i++) {
            set.add(obstacles[i][0] + ", " + obstacles[i][1]);
        }

        // 要遍历commands
        for (int start = 0; start < commands.length; start++) {
            // if (commands[start] < 0) { // 只改变方向
            // direction = getDirection(direction, commands[start]);
            // } else {// 要走路了
            direction = getDirection(direction, commands[start]);

            // int symbol = getSymbol(direction);
            getNewPosition(curPosition, direction, commands[start], set);
            // }
        }
        x = curPosition[0];
        y = curPosition[1];
        return x * x + y * y;
    }

    // 如果是-1or-2 确定方向
    private int getDirection(int curDir, int thisCom) {
        if (thisCom > 0) {
            return curDir;
        }
        switch (curDir) {
        case 1:
            curDir = thisCom == -2 ? 3 : 4;
            break;
        case 2:
            curDir = thisCom == -2 ? 4 : 3;
            // thisCom==-2?nextDir=4:nextDir=3;
            break;
        case 3:
            curDir = thisCom == -2 ? 2 : 1;
            // thisCom == -2?nextDir=2:nextDir=1;
            break;
        case 4:
            curDir = thisCom == -2 ? 1 : 2;
            // thisCom == -2?nextDir=1:nextDir=2;
            break;
        }
        return curDir;
    }

    // 如果是其他数字，确定运算符号 1:+y; 2:-y; 3+x; 4:-x
    private int getSymbol(/* int[] newPosition */ int curDir/* , int thisCom */) {
        int symbol = 0;
        switch (curDir) {
        case 1:
            symbol = 1;
            // newPosition[1] += thisCom;
            break;
        case 2:
            symbol = 2;
            // newPosition[1] -= thisCom;
            break;
        case 3:
            symbol = 3;
            // newPosition[0] += thisCom;
            break;
        case 4:
            symbol = 4;
            // newPosition[0] -= thisCom;
            break;
        }
        return symbol;
    }

    private int[] getNewPosition(int[] curPosition, int symbol, int thisCom, HashSet<String> set) {
        if (thisCom < 0) {
            return curPosition;
        }
        int i = 1;
        while (i <= thisCom) {
            switch (symbol) { // 1:+y; 2:-y; 3+x; 4:-x
            case 1:
                curPosition[1]++;
                if (realIncluded(curPosition, set)) {
                    curPosition[1]--;
                    return curPosition;
                }
                break;
            case 2:
                curPosition[1]--;
                if (realIncluded(curPosition, set)) {
                    curPosition[1]++;
                    return curPosition;
                }
                break;
            case 3:
                curPosition[0]--;
                if (realIncluded(curPosition, set)) {
                    curPosition[0]++;
                    return curPosition;
                }
                break;
            case 4:
                curPosition[0]++;
                if (realIncluded(curPosition, set)) {
                    curPosition[0]--;
                    return curPosition;
                }
                break;
            }
            i++;
        }
        return curPosition;
    }

    private boolean realIncluded(int[] curPosition, HashSet<String> set) {
        int xTemp = curPosition[0];
        int yTemp = curPosition[1];
        if (set == null || set.size() < 1) {
            return false;
        }
        return set.contains(xTemp + ", " + yTemp);
    }
}