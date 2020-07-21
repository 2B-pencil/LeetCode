/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class RomanToInt {
    public static void main(String[] args) {
        // String str = "III";
        // System.out.println(romanToInt1(str));
    }
    public int romanToInt1(String s) {
        int res = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            res += fit(chars[i], chars[i+1]);
        }
        res += fit(chars[chars.length - 1],' ');
        return res;
    }


    public int fit(char ichar, char jchar) {
        switch (ichar) {
            case 'I':
                return 1 + difference(jchar);
            case 'V':
                return 5;
            case 'X':
                if (ichar == jchar || jchar == 'V')
                    return 10;
                return 10 + difference(jchar);
            case 'L':
            return   50;
            case 'C':
                if (ichar == jchar || jchar == 'X' || jchar == 'L' || jchar == 'V')
                    return 100;
                return 100 + difference(jchar);
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public int difference(char ichar) {
        switch (ichar) {
            case 'V':
                return -2;
            case 'X':
                return -2;
            case 'L':
                return -20; 
            case 'C':
                return -20;
            case 'D':
                return -200;
            case 'M':
                return -200;     
            default:
                return 0;
        }
    }

    public int romanToInt2(String s) {
        int sum = 0;
        
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }
    
    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}




// @lc code=end

