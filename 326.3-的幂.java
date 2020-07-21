/*
 * @lc app=leetcode.cn id=326 lang=java
 *
 * [326] 3的幂
 */

// @lc code=start
class IsPowerOfThree {
    public static void main(String[] args) {
        IsPowerOfThree sl = new IsPowerOfThree();
        sl.isPowerOfThree1(45);
    }
    /**
     * 除法计算；
     * @param n
     * @return
     */
    public boolean isPowerOfThree1(int n) {
        if (n < 1 ) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    /**
     * 换底
     * @param n
     * @return
     */
    public boolean isPowerOfThree2(int n) {
        if(n <= 0) return false;
        double a = Math.log(n) / Math.log(3) ;        //换底
        return  a == Math.floor(a);  
    }

    public boolean isPowerOfThree3(int n) {
        int a = 1;                  //a不断乘3，看是否与n相等
        while(n >= a)
        {
            if(a == n) return true; 
            if(a >= Integer.MAX_VALUE / 3)    return false;
            a *= 3;
        }
        return false;
    }

    /**
     * 作弊法，哈哈
     * @param n
     * @return
     */
    public boolean isPowerOfThree4(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

}
// @lc code=end

