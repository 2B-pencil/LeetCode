/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Palindrom {
    public static void main(String[] args) {
        Palindrom sl = new Palindrom();
        for (int i = 0; i < 2000000; i++) {
            System.out.print(i);
            System.out.println(sl.isPalindrome(i));
            i*=i;
        }
        System.out.println(sl.isPalindrome(100021));
        
    }
    public boolean isPalindrome1(int x) {
        if (x < 0) return false;
        char[] chars = Integer.toString(x).toCharArray();
        int len = chars.length;
        for (int i = 0; i < len / 2; i++) {
            if (chars[i] != chars[len-i-1]) return false;
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) return false;
        String str = Integer.toString(x);
        StringBuilder temp = new StringBuilder();
        temp.append(str);
        return str.equals(temp.reverse().toString());
    }

    public boolean isPalindrome(int x) {
        //思考：这里大家可以思考一下，为什么末尾为 0 就可以直接返回 false
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

}
// @lc code=end

