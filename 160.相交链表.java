import java.util.Stack;

/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//用stack解法 不满最O(1)内存 还可以用set哦
// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         Stack<ListNode> stackA=new Stack<>();
//         Stack<ListNode> stackB=new Stack<>();
//          while (headA!=null) {
//              stackA.push(headA);
//              headA=headA.next;
             
//          }
//          while (headB != null) {
//             stackB.push(headB);
//             headB = headB.next;
         

//         }
//         ListNode cur=null;
    
     
//         while (stackA.size()>0&&stackB.size()>0&&stackA.peek()==stackB.peek()) {
         
//             cur=stackA.pop();
//             stackB.pop();
//         }
//         return cur;

//     }
// }
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode bakA=headA,bakB=headB;
        if (headA==null||headB==null) {
            return null;
        }
        while (headA!=headB) {
            if (headA!=null) {
                headA=headA.next;

            }else {headA=bakB;

            }
            if (headB != null) {
                headB=headB.next;
                
            }else{
                headB=bakA;

            }
        }
        if (headA!=null) {return headA;
        }else return null;

    }
}

