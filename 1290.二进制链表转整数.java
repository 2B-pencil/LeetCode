/*
 * @lc app=leetcode.cn id=1290 lang=java
 *
 * [1290] 二进制链表转整数
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class GetDecimalValue {
    public int getDecimalValue(ListNode head) {
        int number = 0;
        while (head != null) {
            number = number << 1 ^ head.val;
            head = head.next;
        }
        return  number;
    }
}
// @lc code=end

