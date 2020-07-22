package leetcode.editor.cn;

//Implement int sqrt(int x). 
//
// Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
//
// Since the return type is an integer, the decimal digits are truncated and only
// the integer part of the result is returned.
//
// Example 1: 
//
// 
//Input: 4
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since 
//             the decimal part is truncated, 2 is returned.
// 
// Related Topics 数学 二分查找 
// 👍 450 👎 0


/**
 * @author Longtao Zhang
 * @data 2020-07-22 10:20:02
 * @Description
 * @since version-1.0
 *
*/

public class Sqrtx{
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        System.out.println(solution.mySqrt(8));

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    /**
     * 二分法
     * @param x
     * @return
     */
    public int mySqrt1(int x) {
        int lower = 0;
        int upper = x;
        int ans = -1;
        while (lower <= upper) {
            int medium = lower + (upper - lower) / 2;
            if ((long)medium * medium <= x) {
                ans = medium;
                lower = medium + 1;
            }
            else {
                upper = medium - 1;
            }
        }
        return ans;
    }

    /**
     * 牛顿迭代
     * @param a
     * @return
     */
    public int mySqrt(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}