import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Merge {
    /**
     * 合并--排序
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }


    /**
     * 因为原数组为有序数组，若为非有序数组，除了先排序是否有别的方法
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;
    
        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
          // compare two elements from nums1 and nums2 
          // and add the largest one in nums1 
          nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
    
        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
      }
}
// @lc code=end

