/*
 * @lc app=leetcode.cn id=1295 lang=java
 *
 * [1295] 统计位数为偶数的数字
 */

// @lc code=start
class FindNumbers {

    public int findNumbers1(int[] nums) {
        int res = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) res++;
        }
        return res;
    }

    /**
     * 数学运算1
     * @param nums
     * @return
     */
    public int findNumbers2(int[] nums) {
        int res = 0;
        for(int val : nums) {
            if((helper(val) & 1) == 0) {
                res++;
            }
        }
        return res;
    }

    public int helper(int val) {
        if(val < 10) return 1;
        int res = 0;
        while(val > 0) {
            res++;
            val /= 10;
        }
        return res;
    }


    /**
     * 数学运算2 {@code log} 函数
     * @param nums
     * @return
     */
    public int findNumbers(int[] nums) {
        int res = 0;
        for(int val : nums) {
            if ((int)Math.log10(val) % 2 == 1) res++;
        }
        return res;
    }
}
// @lc code=end

