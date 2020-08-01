import java.util.function.Function;

/*
 * @lc app=leetcode.cn id=1470 lang=java
 *
 * [1470] 重新排列数组
 */

// @lc code=start
class Shuffle {

    /**
     * 不改变原始数组
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffle1(int[] nums, int n) {
        int[] res = new int[2 * n];
        for (int i = 0; i < n; i++) {
            res[2 * i] = nums[i];
            res[2 * i + 1] = nums[n + i];
        }
        return res;
    }


    /**
     * 改变原始数组
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffle(int[] nums, int n) {
        Function<Integer, Integer> fun = i -> i < n ? 2 * i : (i - n) * 2 + 1;
        for (int i = 0; i < 2 * n; i++) {
            int j = i;
            while (nums[i] >= 0) {
                j = fun.apply(j);
                int tmp = nums[i]; nums[i] = nums[j]; nums[j] = -tmp;
            }
        }
        for (int i = 0; i < 2 * n; i++) {
            nums[i] = -nums[i];
        }
        return nums;
    }
}
// @lc code=end

