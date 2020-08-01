/*
 * @lc app=leetcode.cn id=1221 lang=java
 *
 * [1221] 分割平衡字符串
 */

// @lc code=start
class BalancedStringSplit {
    public int balancedStringSplit1(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        int record = 0;
        char temp = ' ';
        for (int i = 0; i < chars.length; i++) {
            if (record == 0) {
                res++;
                temp = chars[i];
                record++;    
            } else {
                if (temp == chars[i]) record++;
                else record--;
            }
        }
        return res;
    }

    /**
     * 题目是对两个字符进行操作,那么自然会考虑到字符的asc码
     * L和R的中间字符O,即L-O=-3;R-O=3,
     * 原串就可以转化为3和-3的序列,这么看思路就很清晰了,
     * 题目要求子串中ΣL=ΣR,并未要求L和R结构对称,再加上所有分割出的子串都必须为平衡串
     * 那么其实就是求±3序列的前缀和为0的次数
     */
    public int balancedStringSplit(String s) {
        int nums = 0, res = 0;
        for(char i : s.toCharArray()) if((nums += (i - 'O')) == 0) res++;
        return res;
    }
}
// @lc code=end

