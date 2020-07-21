/*
 * @lc app=leetcode.cn id=1009 lang=java
 *
 * [1009] 十进制整数的反码
 */

// @lc code=start
class BitwiseComplement {
    public int bitwiseComplement(int N) {
        if(N==0){//特殊情况
            return 1;
        }
        int n=(int)log(2,N);
        return (int)Math.pow(2,n+1)-1-N;
    }
    public static double log(int basement, int n){//计算对数
        return Math.log(n) / Math.log(basement);
    }
}
// @lc code=end

