/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
class ReverseList {
    
    //循环
    public ListNode reverseList1(ListNode head) {
        ListNode res = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = res;
            res = head;
            head = tmp;
        }
        return res;
    }

    /**
     * 循环递归过度
     */
    ListNode res;
    public ListNode reverseList2(ListNode head) {
        if (head == null) return head;
        ListNode tmp = head.next;
        head.next = res;
        res = head;
        head = tmp;
        return reverseList(head);
    }

    /**
     * 带参数递归法
     * @param res 返回结果
     * @param head 待求链表
     * @return 
     */
    public ListNode reverseList(ListNode res, ListNode head) {
        if (head == null) return res;
        ListNode tmp = head.next;
        head.next = res;
        res = head;
        head = tmp;
        return reverseList(res, head);
    }

    /**
     * 递归法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
}
// @lc code=end

