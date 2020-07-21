/*
 * @lc app=leetcode.cn id=342 lang=java
 *
 * [342] 4的幂
 */

// @lc code=start
/**
 * https://leetcode-cn.com/problems/power-of-four/solution/4de-mi-by-leetcode/
 */
class IsPowerOfFour {
    /**
     * 位运算
     * @param num
     * @return
     */
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num &(num - 1)) == 0 && (num & 0xaaaaaaaa) == 0;
    }

        /**
     * 除法计算；
     * @param n
     * @return
     */
    public boolean isPowerOfFour1(int n) {
        if (n < 1 ) return false;
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }

    /**
     * 换底
     * @param n
     * @return
     */
    public boolean isPowerOfFour2(int n) {
        return (n > 0) && (Math.log(n) / Math.log(2) % 2 == 0);
    }

    public boolean isPowerOfFour3(int n) {
        int a = 1;                  //a不断乘3，看是否与n相等
        while(n >= a)
        {
            if(a == n) return true; 
            if(a >= Integer.MAX_VALUE / 4)    return false;
            a *= 4;
        }
        return false;
    }

    /**
     * 作弊法，哈哈
     * @param n
     * @return
     */
    public boolean isPowerOfFour4(int n) {
        return n > 0 && 1073741824 % n == 0;
    }

    public boolean isPowerOfFour5(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && (num % 3 == 1);
      }
}
// @lc code=end

