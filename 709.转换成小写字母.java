/*
 * @lc app=leetcode.cn id=709 lang=java
 *
 * [709] 转换成小写字母
 */

// @lc code=start
class MyToLowerCase {
    public String toLowerCase(String str) {
        char[] res = str.toCharArray();
        // for (int i = 0; i < res.length; i++) {
        //     if (res[i] <= 'Z' && res[i] >= 'A') res[i] += 32;
        // }

        /* 位运算（解题区的思路
        大写变小写、小写变大写 : 字符 ^= 32;
        大写变小写、小写变小写 : 字符 |= 32;  
        小写变大写、大写变大写 : 字符 &= -33;
        eg：
        65(A)->二进制表示为100 0001
        32的二进制表示为 010 0000 
        100 0001|010 0000=110 0001->97(a)
        */

        for (int i = 0; i < res.length; i++) {
            res[i] |= 32;
        }
        return String.valueOf(res);
    }
}
// @lc code=end

