/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class IsPerfectSquare {
    public static void main(String[] args) {
        
    }

    //暴力
    public boolean isPerfectSquare1(int num) {
        long i = 0;
        while (i*i < num) i++;
        return i*i == num;
    }

    //二分法
    public boolean isPerfectSquare2(int num) {
        long lower = 1, upper = num;
        while (lower <= upper) {
            long mid = lower + (upper - lower) / 2;
            if (mid*mid == num) return true;
            else if (mid*mid > num) upper = mid - 1;
            else lower = mid + 1;
        }
        return false;
    }

    //牛顿迭代
    public boolean isPerfectSquare3(int num) {
        long res = num;
        while (res * res > num ) {
            res = (res + num / res) / 2;
        }
        return res*res == num;
    }

        //解法三：数学定理(1 + 3 + 5 + ... + (2n - 1) = n ^ 2)
        public boolean isPerfectSquare(int num) {
            int i = 1;
            while(num > 0) {
                num -= i;
                i += 2;
            }
            return num == 0;
        }



}
// @lc code=end

