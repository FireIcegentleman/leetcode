import com.sun.xml.internal.ws.server.sei.SEIInvokerTube;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2021/09/15
 * 相交链表
 *
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * */

public class _160_IntersectionofTwoLinkedLists {
    public static class  ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 返回相交点的数值
    // 不能保证相交之前不重复
    // pA走过的路径为A链+B链
    // pB走过的路径为B链+A链
    // pA和pB走过的长度都相同，都是A链和B链的长度之和，相当于将两条链从尾端对齐，如果相交，则会提前在相交点相遇，
    // 如果没有相交点，则会在最后相遇。
    // .val的话只能保证值相同，不能保证节点是一个（内存地址等）
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null ;
        }
        ListNode p = headA , q = headB ;

        while(p != q){
            p = p == null ? headB : p.next ;
            q = q == null ? headA : q.next ;
        }
        return p ;
    }

    public static void main(String[] args) {
        _160_IntersectionofTwoLinkedLists obj = new _160_IntersectionofTwoLinkedLists() ;
        ListNode node5 = new ListNode(5) ;
        ListNode node4 = new ListNode(4 , node5) ;
        ListNode node8 = new ListNode(8 , node4) ;

        ListNode node1_pre = new ListNode(1 , node8) ;
        ListNode node4_pre = new ListNode(4 , node1_pre) ;

        ListNode node1_low = new ListNode(1 , node8) ;
        ListNode node0 = new ListNode(0 , node1_low) ;
        ListNode node5_low = new ListNode(5 , node0) ;

        ListNode res = obj.getIntersectionNode(node4_pre , node5_low) ;
        /*ListNode node4 = new ListNode(4) ;
        ListNode node2 = new ListNode(2 , node4) ;

        ListNode node1 = new ListNode(1 , node2) ;
        ListNode node9 = new ListNode(9 , node1) ;
        ListNode node_1 = new ListNode(1 , node9) ;

        ListNode node3 = new ListNode(3 , node2) ;
        ListNode res = obj.getIntersectionNode(node_1 , node3) ;*/
        System.out.println(res.val);
    }
}
