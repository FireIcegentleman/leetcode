package SwordOffer;

import java.util.List;

/**
 * 2021/10/10
 *
 * 两个链表的第一个公共节点
 *
 * 输入两个链表，找出它们的第一个公共节点。
 * */
public class _52_GetIntersectionNode {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
        ListNode(int x , ListNode next) {
            val = x;
            this.next = next;
        }

    }
    // 返回公共节点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null ;
        }
        ListNode p = headA ;
        ListNode q = headB ;

        // 走了两遍
        while (p != q){
            p = p == null ? headB : p.next ;
            q = q == null ? headA : q.next ;
        }
        return p ;
    }
    public static void main(String[] args) {
        _52_GetIntersectionNode obj = new _52_GetIntersectionNode() ;
        ListNode node5 = new ListNode(5) ;
        ListNode node4 = new ListNode(4 , node5) ;
        ListNode node8 = new ListNode(8 , node4) ;

        ListNode node1_pre = new ListNode(1 , node8) ;
        ListNode node4_pre = new ListNode(4 , node1_pre) ;

        ListNode node1_low = new ListNode(1 , node8) ;
        ListNode node0 = new ListNode(0 , node1_low) ;
        ListNode node5_low = new ListNode(5 , node0) ;

        ListNode res = obj.getIntersectionNode(node4_pre , node5_low) ;
        System.out.print(res.val);
    }
}
