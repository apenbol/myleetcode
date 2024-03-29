/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur=head;
        while (cur!=null&&cur.next!=null) {//注意判断指针是否为空
            if(cur.val==cur.next.val)cur.next=cur.next.next;
            else cur=cur.next;
        }
        return head;
    }
}

