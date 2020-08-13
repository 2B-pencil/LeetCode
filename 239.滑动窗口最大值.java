import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start

/**
 * 未完成
 */
class MaxSlidingWindow {
    /**
     *  -- 暴力法--
     * 时间复杂度：{@code O(N * K) }, 其中 N 为数组中元素个数。
     * 空间复杂度：{@code O(N - k + 1) }, 用于输出数组。
     * **运算超时
     * @param nums 原始数组
     * @param k 滑动数组大小
     * @return 每个滑动数组最大值的集合
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length - k + 1;
        int[] res = new int[n];
        Arrays.fill(res, Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            //int[] tmp = Arrays.copyOfRange(nums, i, k + i);
            for (int j : Arrays.copyOfRange(nums, i, k + i)) {
                res[i] = res[i] >= j ? res[i] : j;
            }
        }
        return res;
    }


    /**
     * 由于暴力超时，因此要想办法降低时间复杂度
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {

        return new int[]{};
    }
}
// @lc code=end

