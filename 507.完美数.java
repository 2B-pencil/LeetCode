/*
 * @lc app=leetcode.cn id=507 lang=java
 *
 * [507] 完美数
 */

// @lc code=start
class CheckPerfectNumber {
    /**
     * 遍历
     * @param num
     * @return
     */
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) return false;
        // int sum = 1;
        // for (int i = 2; i * i <= num; i++) {
        //     if (num % i == 0) {
        //         sum += i;
        //         if (i * i != num) sum += num / i;
        //     }
        // }
        // return sum == num;
        int sum = 1;
        int i = 2;
        for (; i * i < num; i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        if (i * i == num) sum += i;
        return sum == num;
    }
}
// @lc code=end

