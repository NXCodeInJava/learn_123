class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==1) return intervals;

        // intervals 要排序
        Arrays.sort(intervals, (v1, v2)->(v1[0]-v2[0]));

        int len = intervals.length;
        //int[][] tempRes = new int[len][2];

        // 用list方便后面的添加
        List<int[]> merged = new ArrayList<int[]>();

        for(int a = 0; a < len; a++){
            int al = intervals[a][0], ar = intervals[a][1];
            // 如果一个都没有，或者最后一个的右边都小于当前准备放入的左边，那就是直接放入
            if(merged.size()==0 || merged.get(merged.size()-1)[1]<al){
                merged.add(new int[]{al, ar});
            }else{ // 当前的最右是否需要更新成ar -> 直接在list上面修改【其实当前这个循环的就被覆盖了】
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1], ar);
            }
        }

        return merged.toArray(new int[merged.size()][]); // 这个写法要记住！
    }
}