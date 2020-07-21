
/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
import java.util.*;
class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0};
        System.out.println(twoSum(nums, 0));
    }
    //暴力
    public static int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length < 2) return new int[]{};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return new int[]{};
    }
    //暴力
   public static int[] twoSum12(int[] nums, int target) {
        int size = nums.length;
        int[] value = new int[2];
        //int itimes = 1;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i+1; j < size; j++) {
                if (nums[i] + nums[j] == target) {
                    value[0] = i;
                    value[1] = j;
                    return value;
                }
            }
        }
        return value;
        //throw new IllegalArgumentException("No answer!");
    }
    //遍历两次hash表
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    //一次遍历hash表
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static List<List<Integer>> twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return Collections.emptyList();
        Set<List<Integer>> res = new LinkedHashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                res.add(Arrays.asList(map.get(complement), i));
                //return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new ArrayList<>(res);
    }

}
// @lc code=end

