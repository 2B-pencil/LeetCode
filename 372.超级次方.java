import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=372 lang=java
 *
 * [372] 超级次方
 */

// @lc code=start
class SuperPow {
    
    public int superPow(int a, int[] b) {
        return mySuperPow(a, b, 1337);
    }

    /**
     * 暴力容易越界出错
     * @param a
     * @param b
     * @return
     */
    public int superPow1(int a, int[] b) {
        if (b.length == 0) return 1;
        a %= 1337;
        int part1 = myMod(a, b[b.length - 1], 1337);
        int part2 = myMod(superPow1(a, Arrays.copyOfRange(b, 0, b.length - 1)), 10, 1337);
        return part1 * part2 % 1337;
    }


    /**
     * 求 {@code (a^b)%c}
     * -- 根据 {@code (m*n)%x = ((m%x)*(n%x))%x} 求解
     * -- 当b相当大时显然单纯使用for循环处理是比较耗时的--待优化
     * @param a 底
     * @param b 指数
     * @param c 取模运算值
     * @return {@code (a^b)%c }
     */
    public int myMod1(int a, int b, int c) {
        int res = 1;
        a %= c;
        for (int i = 0; i < b; i++) {
            res *= a;
            res %= c;
        }
        return res;
    }


    /**
     * 求 {@code (a^b)%c}
     * -- 根据 {@code (m*n)%x = ((m%x)*(n%x))%x} 求解
     * -- 优化 {@code myMod1} 方法，采用 {@code 快速幂} 计算降低时间复杂度
     * @param a 底
     * @param b 指数
     * @param c 取模运算值
     * @return {@code (a^b)%c }
     */
    public int myMod(int a, int b, int c) {
        a %= c;
        if (b == 0) return 1;
        if (b == 1) return a;
        if (b % 2 == 0) {
            int half = myMod(a, b / 2, c);
            return half * half % c;
        } else return a * myMod(a, b - 1, c) % c;
    }


    /**
     * ular定理：若a与m互质，则 {@code a ^ f(m) ≡ 1(mod m) } 即 {@code a ^ b mod c = a ^ (b mod φ(c) + φ(c)) mod c}
     * @Description Euler降幂 
     * @param x
     * @return φ(x)
     */
    public int fEuler(int x) {
        int res = x;
        for(int i = 2; i * i <= x; i++) {
            if(x % i == 0) {
                res = res - res/ i;
                while(x % i == 0) {
                    x /= i;
                }
            }
        }
        if(x > 1) res = res - res / x;
        return res;
    }

    
    /**
     * 
     * @param a 底
     * @param b 指数数组
     * @param mod 取模运算值
     * @return
     */
    public int mySuperPow(int a, int[] b, int mod) {
        int c = fEuler(mod);
        int sum = 0;
        for(int i = 0; i < b.length ; i++) //求余数（模）-- 一般列算式求余数抽象表达。。。
        	sum = (sum * 10 + b[i]) % c; 
        sum += c;
        return myMod(a, sum, 1337);
    }


}
// @lc code=end

