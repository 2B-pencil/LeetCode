
/*
 * @lc app=leetcode.cn id=1365 lang=java
 *
 * [1365] 有多少小于当前数字的数字
 */

// @lc code=start
import java.util.*;
class SmallerNumbersThanCurrent {

    /**
     * 对原数组排序，通过二分查找搜索对应数值其下标即为比其小的数字个数
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent1(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = numOfLowerCase(copy, nums[i]);
        }
        return res;
    }

    /**
     * 
     * @param array 检索数组(已排序)
     * @param num 待查找数字
     * @return 数组 array 中比 num 小的数字个数
     */
    public int numOfLowerCase(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) right = mid - 1;
            else left = mid + 1;
        }
        return (left >= nums.length || nums[left] != target) ? -1 : left; 
    }


    /**
     * 计数排序
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        // 统计出现频率 frequency

        int[] freq = new int[101]; // 索引即数值--nums 中元素最大值为 100 , 最小值为 0；
        for (int num : nums) freq[num]++;

        // 对频率(而非对原数组nums)从前到后累加
        for (int i = 1; i < freq.length; i++) {
            freq[i] = freq[i] + freq[i - 1];
        }
    
        // 输出结果
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            if (nums[i] > 0) res[i] = freq[nums[i] - 1];
        }
        return res;
    }
}
// @lc code=end

