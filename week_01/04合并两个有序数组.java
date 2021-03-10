class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}