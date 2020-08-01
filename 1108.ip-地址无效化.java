/*
 * @lc app=leetcode.cn id=1108 lang=java
 *
 * [1108] IP 地址无效化
 */

// @lc code=start
class DefangIPaddr {

    //内部算法
    public String defangIPaddr1(String address) {
        return address.replace(".", "[.]");
    }

    //遍历替换
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (char ichar : address.toCharArray()) {
            if (ichar == '.') sb.append("[.]");
            else sb.append(ichar);
        }
        return sb.toString();
    }
}
// @lc code=end

