/*
 * @lc app=leetcode.cn id=1370 lang=java
 *
 * [1370] 上升下降字符串
 */

// @lc code=start
import java.util.Arrays;

class SortString {

    public static void main(String[] args) {
        String s = "aaaabbbbcccc";
        SortString sl = new SortString();
        System.out.println(sl.sortString(s));
    }
    public String sortString1(String s) {
        char[] chars = s.toCharArray();
        boolean[] isUsed = new boolean[chars.length];
        Arrays.sort(chars);
        StringBuilder res = new StringBuilder().append(chars[0]);
        int count = chars.length - 1;
        int add = 1;
        char pre = chars[0];
        boolean isEdge = false;
        isUsed[0] = true;
        for (int i = 1; count != 0; /* i += add */) {
            if ((isEdge || chars[i] != pre) && !isUsed[i]) {
                res.append(chars[i]);
                pre = chars[i];
                isUsed[i] = true;
                count--;
                isEdge = false;
            }
            i += add;
            if (i == chars.length - 1) {
                add = -1;
                isEdge = true;
            }
            else if (i == 0) {
                add = 1;
                isEdge = true;
            }
        }
        return res.toString();
    }

    public String sortString(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray())
            count[c - 'a'] += 1;
        StringBuilder res = new StringBuilder();
        while(res.length() != s.length()){
            for(int i = 0; i < 26; i++){
                if(count[i] != 0) {
                    res.append((char)(i + 'a'));
                    count[i] -= 1;
                }

            }
            for(int i = 25; i >= 0; i--){
                if(count[i] != 0) {
                    res.append((char)(i + 'a'));
                    count[i] -= 1;
                }
            }
        }
        return res.toString();
    }
}
// @lc code=end

