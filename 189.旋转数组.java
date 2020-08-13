/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Rotate {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        new Rotate().rotate(nums, 3);
    }

    /**
     * 基础解法
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < res.length; i++) {
            res[(k + i) % len] = nums[i];
        }
        nums = res;
    }

    /**
     * 优化
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        int len = nums.length;
        k = k % len;//防止数组访问越界
        int count = 0;    // 记录交换位置的次数，n个同学一共需要换n次
        for (int start = 0; count < nums.length; start++) {
            int cur = start;  // 从0位置开始换位子
            int pre = nums[cur];
            do {
                int next = (cur + k) % len;
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                cur = next;
                count++;
            } while (start != cur);    // 循环暂停，回到起始位置，角落无人
        }
    }


    public void rotate3(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }


    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
// @lc code=end

