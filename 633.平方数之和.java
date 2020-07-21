
/*
 * @lc app=leetcode.cn id=633 lang=java
 *
 * [633] 平方数之和
 */

// @lc code=star
class JudgeSquareSum {
    public static void main(String[] args) {
        
    }
    //使用aqrt函数遍历一个数，通过判断另一个数是否为整数求解
    public boolean judgeSquareSum1(int c) {
        for (long a = 0; a*a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int)b) return true;
        }
        return false;
    }

    //二分查找
    public boolean judgeSquareSum2(int c) {
        for (long a = 0; a * a <= c; a++) {
            int b = c - (int)(a * a);
            if (binary_search(0, b, b))
                return true;
        }
        return false;
    }
    public boolean binary_search(long s, long e, int n) {
        if (s > e)
            return false;
        long mid = s + (e - s) / 2;
        if (mid * mid == n)
            return true;
        if (mid * mid > n)
            return binary_search(s, mid - 1, n);
        return binary_search(mid + 1, e, n);
    }

    //费马定理求解
    //链接: https://wstein.org/edu/124/lectures/lecture21/lecture21/node2.html#thm:sumsquare
    public boolean judgeSquareSum3(int c) {
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3;
    }

    //双指针
    public boolean judgeSquareSum(int c){
        long i = 0, j = (int)Math.sqrt(c);
        while(i <= j){
            if(i * i + j * j == c) return true;
            while(i * i + j * j > c) j--;
            while(i *i + j * j < c)  i++;
        }
        return false;
    }

}
// @lc code=end

