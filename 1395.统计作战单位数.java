/*
 * @lc app=leetcode.cn id=1395 lang=java
 *
 * [1395] 统计作战单位数
 */

// @lc code=start
class NumTeams {
    /**
     * 暴力
     * @param rating
     * @return
     */
    public int numTeams1(int[] rating) {
        if (rating == null || rating.length < 3) return 0;
        int res = 0;
        for (int i = 0; i < rating.length - 2; i++) {
            for (int j = i + 1; j < rating.length - 1; j++) {
                for (int j2 = j + 1; j2 < rating.length; j2++) {
                    if ((rating[i] > rating[j] && rating[j] > rating[j2])
                     || (rating[i] < rating[j] && rating[j] < rating[j2])) res++;
                }
            }
        }
        return res;
    }

    /**
     * 中心点法
     * @param rating
     * @return
     */
    public int numTeams(int[] rating) {
        if (rating == null || rating.length < 3) return 0;
        int res = 0;
        for (int i = 1; i < rating.length - 1; i++) {
            int lowerCases_L = 0, lowerCases_R = 0;
            int upperCases_L = 0, upperCases_R = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] > rating[i]) upperCases_L++;
                else if (rating[j] < rating[i]) lowerCases_L++;
            }
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[j] > rating[i]) upperCases_R++;
                else if (rating[j] < rating[i]) lowerCases_R++;
            }
            res += lowerCases_L * upperCases_R + lowerCases_R * upperCases_L;
        }
        return res;
    }

    //也可通过字典树（前缀树处理）  学习之后补上
}
// @lc code=end

