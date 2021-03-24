class Solution {
    public int leastInterval(char[] tasks, int n) {
        // dp: a. subproblem; b. dp-array; c. equation
        // 目的：给出满足条件的排列的组合，求min(排列1, 排列2, ...) -> 这就是暴力
        // 桶思想，一个桶的容量是冷却时间n，桶的数量是队列里最多的那一个元素的数量
        // 最后一个桶不需要完整的容量
        // 冷却时间=两个相同元素出现的时间间隔
        // 所以，总时间=[Max(元素的个数)-1]*(n+1)+最后一桶需要处理的元素个数
            if (n == 0)
                return tasks.length;
            Map<Character, Integer> unSortedMap = new HashMap<>();
            for (int i = 0; i < tasks.length; i++) {
                if (unSortedMap.containsKey(tasks[i])) {
                    unSortedMap.put(tasks[i], unSortedMap.get(tasks[i]) + 1);
                } else {
                    unSortedMap.put(tasks[i], 1);
                }
            }

        Map<Character, Integer> reverseSortedMap = new LinkedHashMap<>();
        unSortedMap.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()).forEach(e -> reverseSortedMap.put(e.getKey(), e.getValue()));

        int lastNum = 0;
        int theMostValue = 0;

        Set<Map.Entry<Character, Integer>> entrySet = reverseSortedMap.entrySet();
        theMostValue = entrySet.iterator().next().getValue();

        for (Map.Entry<Character, Integer> entry : reverseSortedMap.entrySet()) {
            if (entry.getValue() == theMostValue)
                lastNum++;
            else
                break;
        }

        // [Max(元素的个数)-1]*(n+1)+最后一桶需要处理的元素个数
        return Math.max((theMostValue - 1) * (n + 1) + lastNum, tasks.length);    
    }
}