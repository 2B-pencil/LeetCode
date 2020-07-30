/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Multiply {

    public String multiply1(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        int l1=num1.length(),l2=num2.length();
        int[] result = new int[l1+l2-1];
    
        //计算乘积并存储到数组中
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                result[i+j]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }
    
        //整理数组中结果到最终的字符串中
        StringBuilder sb = new StringBuilder();
        int carry=0;
        for (int i = l1 + l2 - 2; i >= 0; i--) {
            sb.append((result[i]+carry)%10);
            carry=(result[i]+carry)/10;
        }
        while (carry != 0) {
            sb.append(carry%10);
            carry/=10;
        }
        return sb.reverse().toString();

    }


    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = (res[i + j + 1] + n1 * n2);
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            result.append(res[i]);
        }
        return result.toString();
    }
}
// @lc code=end

