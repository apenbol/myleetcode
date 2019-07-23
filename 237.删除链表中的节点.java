/*
 * @lc app=leetcode.cn id=237 lang=java
 *
 * [237] 删除链表中的节点
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
    public void deleteNode(ListNode node) {
    //    if(node.next==null)node=null;  注意其实这步删除不了尾节点 错误示范
        node.val=node.next.val;
        node.next=node.next.next;

    }
}

