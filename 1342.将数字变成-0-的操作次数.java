/*
 * @lc app=leetcode.cn id=1342 lang=java
 *
 * [1342] 将数字变成 0 的操作次数
 */

// @lc code=start
class NumberOfSteps {

    //暴力
    public int numberOfSteps1 (int num) {
        int res = 0;
        while (num > 0) {
            if (num % 2 == 0) num /= 2;
            else num--;
            res++;
        }
        return res;
    }

    public int numberOfSteps (int num) {
        int res = 0;
        while (num > 0) {
            if ((num & 1) == 1) num ^= 1;//num--;
            else num >>= 1;
            res++;
        }
        return res;
    }

}
// @lc code=end

