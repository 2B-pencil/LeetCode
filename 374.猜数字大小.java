/*
 * @lc app=leetcode.cn id=374 lang=java
 *
 * [374] 猜数字大小
 */

// @lc code=start
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

class GuessNumber{
    int guess(int num){
        return num;
    }
 }



class GuessNumberSolution extends GuessNumber{

    //暴力
    public int guessNumber1(int n) {
        for (int i = 1; i <= n; i++) if(guess(i) == 0) return i;
        return -1;
    }
    //二分
    public int guessNumbe2r(int n) {
        int low = 1;
        int high = n;
        int medium = 0;
        while(low<=high) {
            medium = low + (high - low) / 2;
            if (guess(medium) == 0) return medium;
            if (guess(medium) < 0) high = medium - 1;
            else low = medium + 1;
        }
        return -1;
    }
    //三分法
        public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;
            int res1 = guess(mid1);
            int res2 = guess(mid2);
            if (res1 == 0)
                return mid1;
            if (res2 == 0)
                return mid2;
            else if (res1 < 0)
                high = mid1 - 1;
            else if (res2 > 0)
                low = mid2 + 1;
            else {
                low = mid1 + 1;
                high = mid2 - 1;
            }
        }
        return -1;
    }   
}
// @lc code=end

