/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class LongestCommonPrefix {

    /**
     * 也可直接从头记录公共子串一一比较
     */
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String temp = strs[0];
        int len = Integer.MAX_VALUE;
        for (String str : strs) {
            if ("".equals(str)) return "";
            if (len > str.length()) {
                len = str.length();
                temp = str;
            }
        }
        int resinedx;
        for (resinedx = temp.length(); resinedx > 0; resinedx--) {
            int index = 0;
            for (; index < strs.length; index++) {
                // substring(i, j); 半闭半开区间
                if (!strs[index].substring(0, resinedx).equals(temp.substring(0, resinedx))) break;
            }
            if (index == strs.length) break;
        }
        return resinedx == 0 ? "" : temp.substring(0, resinedx);
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) 
            return "";
        String ans = strs[0];
        for(int i =1;i<strs.length;i++) {
            int j=0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }
}
// @lc code=end

