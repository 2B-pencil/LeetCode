/*
 * @lc app=leetcode.cn id=1299 lang=java
 *
 * [1299] 将每个元素替换为右侧最大元素
 */

// @lc code=start
class ReplaceElements {

    //改变原数组
    public int[] replaceElements1(int[] arr) {
        int temp = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            int num = arr[i];
            arr[i] = Math.max(temp, arr[i + 1]);
            temp = num;
        }
        char ichar = ' ';
        if (ichar == ' ') ichar = 'a';
        return arr;
    }

    public int[] replaceElements(int[] arr) {
        int[] res = new int[arr.length];
        res[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            res[i] = Math.max(res[i + 1], arr[i + 1]);
        }
        return res;
    }
}
// @lc code=end

