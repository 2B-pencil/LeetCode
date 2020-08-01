/*
 * @lc app=leetcode.cn id=1323 lang=java
 *
 * [1323] 6 和 9 组成的最大数字
 */

// @lc code=start
class Maximum69Number {
    /**
     * 使用String
     * @param num
     * @return
     */
    public int maximum69Number1 (int num) {
        String res = String.valueOf(num);
        return Integer.valueOf(res.replaceFirst("6", "9"));
        // try {
        //     return Integer.valueOf(res.replaceFirst("6", "9"));
        // } catch (Exception e) {
        //     return num;
        // }
    }

    public int maximum69Number (int num) {

        int len = 0;
        int temp = num;
        while (temp >= 10) {
            temp = temp / 10;
            len++;
        }

        int sum = 0;
        temp = num;
        for (int i = 0; i <= len; i++) {
            if ((temp / Math.pow(10.00, len-i)) < 9) {
                temp += 3*Math.pow(10.00, len-i);
                return temp + sum;
            }
            temp -= 9*Math.pow(10.00, len-i);
            sum += 9*Math.pow(10.00, len-i);
        }

        return num;
    }
}
// @lc code=end

