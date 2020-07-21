/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Myreverse {
    public static void main(String[] args) {
        
    }
    /**
     * 一.把数字转化为字符（需记录并剔除符号）;
     * 二.字符翻转；
     * 三.字符转数字（异常表示会溢出，直接返回0），输出。
     * @param x
     * @return
     */
    public int reverse1(int x) {
        int flag = 1;
        if (x < 0) {
            flag = -1;
            x *= -1;
        }
        StringBuilder str = new StringBuilder().append(Integer.toString(x));
        str = str.reverse();
        try {
            x = Integer.valueOf(str.toString());
        } catch (Exception e) {
            return 0;
        }
        return  flag * x;
    }

    /**
     * 
     * @param x
     * @return
     */
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) 
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop == -9)) 
                return 0;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }
}
// @lc code=end

