/*
 * @lc app=leetcode.cn id=1528 lang=java
 *
 * [1528] 重新排列字符串
 */

// @lc code=start

import java.util.*;
class RestoreString {
    public static void main(String[] args) {
        RestoreString sl = new RestoreString();
        String s = "codeleet";
        int[] indices = new int[]{4,5,6,7,0,2,1,3};
        System.out.println(sl.restoreString1(s, indices));
    }


    //哈希表
    public String restoreString1(String s, int[] indices) {
        char[] chars = s.toCharArray();
        Map<Integer, Character> res = new HashMap<>();
        for(int i = 0; i < chars.length; i++){
            res.put(indices[i], chars[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sb.append(res.get(i));
        }
        return sb.toString();
    }

    public String restoreString(String s, int[] indices) {
        char[] chars = s.toCharArray();
        char[] result=new char[indices.length];
        for(int i = 0; i < chars.length; i++){
            result[indices[i]] = chars[i];
        }
        return String.valueOf(result);
    }
}
// @lc code=end

