import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class SortColors {
    /**
     * 可参考 283.移动零
     * @param nums
     */
    public void sortColors(int[] nums) {
        int index1 = 0;
        int index2 = nums.length - 1;
        int cur = 0;
        while (cur < index2 + 1) {
            if (nums[cur] == 0) {
                int temp = nums[cur];
                nums[cur++] = nums[index1];
                nums[index1++] = temp;
            } else if (nums[cur] == 2) {
                int temp2 = nums[cur];
                nums[cur] = nums[index2];
                nums[index2--] = temp2;
            } else {
                cur++;
            }
        }
    }

    public void sortColors1(int[] nums) {
        Arrays.sort(nums);
    }
}
// @lc code=end

