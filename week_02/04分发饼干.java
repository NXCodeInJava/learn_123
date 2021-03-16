class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //g是小孩子 s是饼干
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0; // 已经被满足的小孩数量
        for(int j=0; count<g.length && j<s.length; j++){
            if(g[count]<=s[j]){
                count++; // 当前小孩已经被满足了，数量可以+1
            }
            // 如果当前小孩没有被满足，就去找下一块饼干
        }
        return count;
    }
}