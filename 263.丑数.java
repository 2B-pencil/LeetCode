/*
 * @lc app=leetcode.cn id=263 lang=java
 *
 * [263] 丑数
 */

// @lc code=start
class IsUgly {
    public boolean isUgly(int num) {
        if (num < 1) return false;
        else if (num < 6) return true;
        else {
            while (num % 3 == 0 || num % 2 == 0 || num % 5 == 0) {
                if (num % 3 == 0 ) {
                    num /= 3;
                }
                if (num % 2 == 0 ) {
                    num /= 2;
                }
                if (num % 5 == 0 ) {
                    num /= 5;
                }
            }
            return num == 1;
        }
    }
}
// @lc code=end

