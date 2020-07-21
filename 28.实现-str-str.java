/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr() in C++
 * [28] 实现 indexof() in java
 */

// @lc code=start
class StrStr {
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "pi";
        System.out.println(strStr1(haystack, needle));
        
    }
    public static int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    //逐一比较
    public int strStr(String haystack, String needle) {
        //if (haystack.equals(needle)) return 0;
        int len1 = haystack.length();
        int len2 = needle.length();
        for (int i = 0; i <= len1 - len2 ; i++) {
            if (haystack.substring(i, i + len2).equals(needle)) return i;
        }
        return -1;
    }

}

class StrStr2Solution {
    // function to convert character to integer
    public int charToInt(int idx, String s) {
      return (int)s.charAt(idx) - (int)'a';
    }
  
    public int strStr(String haystack, String needle) {
      int L = needle.length(), n = haystack.length();
      if (L > n) return -1;
  
      // base value for the rolling hash function
      int a = 26;
      // modulus value for the rolling hash function to avoid overflow
      long modulus = (long)Math.pow(2, 31);
  
      // compute the hash of strings haystack[:L], needle[:L]
      long h = 0, ref_h = 0;
      for (int i = 0; i < L; ++i) {
        h = (h * a + charToInt(i, haystack)) % modulus;
        ref_h = (ref_h * a + charToInt(i, needle)) % modulus;
      }
      if (h == ref_h) return 0;
  
      // const value to be used often : a**L % modulus
      long aL = 1;
      for (int i = 1; i <= L; ++i) aL = (aL * a) % modulus;
  
      for (int start = 1; start < n - L + 1; ++start) {
        // compute rolling hash in O(1) time
        h = (h * a - charToInt(start - 1, haystack) * aL
                + charToInt(start + L - 1, haystack)) % modulus;
        if (h == ref_h) return start;
      }
      return -1;
    }
  }

// @lc code=end

