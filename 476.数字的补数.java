/*
 * @lc app=leetcode.cn id=476 lang=java
 *
 * [476] 数字的补数
 */

// @lc code=start
class FindComplement {
    public static void main(String[] args) {
        
    }
    public int findComplement(int num) {
        int move = 0;
        int res = 0;
        while(num != 0){
            int temp = num & 1;
            if(temp == 0) res += (1 << move);
            move++;
            num >>>= 1;
        }
        return res;
    }
}
// @lc code=end

