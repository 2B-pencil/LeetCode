/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
import java.util.*;
class TwoSumII {
    /**
     * 暴力解法，遍历数组
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum1(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2 || numbers[0] > target) return new int[]{};
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) return new int[]{i + 1,j + 1};
                else if (numbers[i] + numbers[j] > target) break;
            }
        }
        return new int[]{};
    }

    /**
     * 双指针
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2 || numbers[0] > target) return new int[]{};
        int lower = 0;
        int upper = numbers.length - 1;
        while (upper > lower) {
            if (numbers[lower] + numbers[upper] == target) return new int[]{lower + 1, upper + 1};
            else if (numbers[lower] + numbers[upper] < target) lower++;
            else upper--;
        }
        return new int[]{};
    }

    public int[] twosum3(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2 || numbers[0] > target) return new int[]{};
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{};
    }

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2 || numbers[0] > target) return new int[]{};
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement) + 1, i + 1 };
            }
            map.put(numbers[i], i);
        }
        return new int[]{};
    }

}
// @lc code=end

