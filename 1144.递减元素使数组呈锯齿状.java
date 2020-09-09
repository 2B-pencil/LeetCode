/*
 * @lc app=leetcode.cn id=1144 lang=java
 *
 * [1144] 递减元素使数组呈锯齿状
 */

// @lc code=start
import java.util.Arrays;
class MovesToMakeZigzag {
    public int movesToMakeZigzag(int[] nums) {
        return Math.min(compute(Arrays.copyOf(nums, nums.length), 0), compute(nums, 1));
    }

    private int compute(int[] arr, int idx) {
        int len = arr.length;
        int count = 0;
        for (; idx < len; idx += 2) {
            int cur_num = arr[idx];
            if (idx > 0 && arr[idx - 1] >= cur_num) {
                count += arr[idx - 1] - cur_num + 1;
                arr[idx - 1] = cur_num - 1;
            }
            if (idx + 1 < len && arr[idx + 1] >= cur_num) {
                count += arr[idx + 1] - cur_num + 1;
                arr[idx + 1] = cur_num - 1;
            }
        }
        return count;
    }
}
// @lc code=end

