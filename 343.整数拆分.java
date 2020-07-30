/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class IntegerBreak {
    public static void main(String[] args) {
        
    }
    //数学推导
    public int integerBreak1(int n) {
        if (n < 4) return n-1;
        int product = 1;
        while (n >= 4) {
            if (n == 4) return 4*product;
            product *= 3;
            n -= 3;
        }
        return product * n;
    }

    //推导优化
    public int integerBreak(int n) {
        if (n < 4) return n-1;
        int rest = n % 3;
        if (rest == 0) return (int)Math.pow(3, n / 3);
        else if (rest == 1) return (int)Math.pow(3, n / 3 - 1) * 4;
        else return (int)Math.pow(3, n / 3) * rest;
    }

    //动态优化
    /**
     * 动态规划和数学推导基本类似，且需要记录各项最优值。
     */


}
// @lc code=end

