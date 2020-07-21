/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class PlusOne {
    public static void main(String[] args) {
        
    }
    public int[] plusOne(int[] digits) {
        if(digits == null) return new int[] {};
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i]++ != 9) return digits;
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    } 
}
// @lc code=end

