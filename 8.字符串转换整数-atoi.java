/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class MyAtoi {
    /**
     * 一般方法
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int len = chars.length;
        int index = 0;
        while (index < len && chars[index] == ' ') {
            index++;
        }
        if (index == len) return 0;
        boolean isPositive = true;
        if (chars[index] == '-') {
            isPositive = false;
            index++;
        } else if (chars[index] == '+') {
            // isPositive = true;
            index++;  
        } else if (!isDigit(chars[index])) {
            return 0;
        }
        int res = 0;
        while (index < len && isDigit(chars[index])) {
            int digit = chars[index++] - '0';
            // 通过判断Integer.Max_Value / 10 与 res 的大小关系来判断是否越界
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = 10 * res + digit;
        }
        return isPositive ? res : -res;
    }

    public boolean isDigit(char ch) {
        return '0' <= ch && ch  <= '9';
    }

}
// @lc code=end

