/*
 * @lc app=leetcode.cn id=859 lang=java
 *
 * [859] 亲密字符串
 */

// @lc code=start
class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A == null || B == null || A.length() != B.length() || A.length() < 2 || B.length() < 2) return false;
        //如果两字符串相同，则只要字符串中包含相同字符即返回 true
        if (A.equals(B)) {
			for (int i = A.length() - 1; i >= 0; i--)//从后往前减少判断，因为indexof为从前往后查询
				if (A.indexOf(A.charAt(i)) != i)
					return true;
		}
        char[] aChars = A.toCharArray();
        char[] bChars = B.toCharArray();
        StringBuilder sb = new StringBuilder();
        int res = 0;
        for (int i = 0; i < bChars.length; i++) {
            if (aChars[i] != bChars[i]) {
                res++;
                sb.append(aChars[i]).append(bChars[i]);
            }
        }
        String temp = sb.toString();
        return res != 2 ? false : sb.reverse().toString().equals(temp);
    }
}
// @lc code=end

