/*
 * @lc app=leetcode.cn id=1512 lang=java
 *
 * [1512] 好数对的数目
 */

// @lc code=start
import java.util.*;
class NumIdenticalPairs {

    public static void main(String[] args) {
        // Solution sl = new Solution();
        // int[] nums = new int[]{1,2,3,1,1,3};
        // System.out.println(sl.numIdenticalPairs(nums));
    }

    /**
     * 暴力求解
     * @param nums
     * @return
     */
    public int numIdenticalPairs11(int[] nums) {
        if (nums == null || nums.length < 2) return -1;
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) res++;
            }
        }
        return res;
    }

    /**
     * 由于 {@code 1 <= nums.length <= 100 且 1 <= nums[i] <= 100} 即数组下标和值可以对应
     * temp 数组记录 nums 数组数字出现的次数 n（实时跟新）-- temp 下标和 nums 值相对应，最终计算方式为
     *  {@code 0 + 1 + 2 + ... + (n - 2) + (n - 1)  = n * (n - 1) / 2 }
     * @param nums
     * @return
     */
    public int numIdenticalPairs2(int[] nums) {
        if (nums == null || nums.length < 2) return -1;
        int res = 0;
        int[] temp = new int[100];
        for (int i : nums) {
            res += temp[i - 1]++;
        }
        return res;
    }

    /**
     * Hashtable
     * @param nums
     * @return
     */
    public int numIdenticalPairs3(int[] nums) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            int v = entry.getValue();
            ans += v * (v - 1) / 2;
        }

        return ans;
    }

    /**
     * 以上优化
     * @param nums
     * @return
     */
    public int numIdenticalPairs4(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i  : nums){
            int val = map.getOrDefault(i, 0);
            res += val;
            map.put(i, val + 1);//key 存在，则新 value 替换旧 value，否则加入
        }
        return res;
    }

}
// @lc code=end

