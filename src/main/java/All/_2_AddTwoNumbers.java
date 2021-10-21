package All;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.List;

/**
 * 2021/10/16
 *
 * 两数相加
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * */
public class _2_AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    // 逆序存储
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2 ;
        }
        if (l2 == null){
            return l1 ;
        }

        int carry = 0 ;
        ListNode p = l1 ;
        ListNode q = l2 ;
        ListNode dummy = new ListNode(0) ;
        ListNode cur = dummy ;

        while (p != null && q != null){
            ListNode tmp = new ListNode((p.val + q.val + carry) %10 );
            carry = (p.val + q.val + carry) / 10 ;
            p = p.next ;
            q = q.next ;
            cur.next = tmp ;
            cur = cur.next;
        }

        while (p != null){
            ListNode tmp = new ListNode((p.val + carry)  %10 ) ;
            carry = (p.val + carry) / 10 ;
            p = p.next ;
            cur.next = tmp ;
            cur = cur.next;
        }

        while (q != null){
            ListNode tmp = new ListNode((q.val + carry) %10 ) ;
            carry = (q.val + carry) / 10 ;
            q = q.next ;

            cur.next = tmp ;
            cur = cur.next;
        }

        if (carry == 1){
            ListNode tmp = new ListNode(carry) ;
            cur.next = tmp ;
            cur = cur.next ;
        }
        return dummy.next ;
    }
    public static void main(String[] args) {
        _2_AddTwoNumbers obj = new _2_AddTwoNumbers() ;
        ListNode node3 = new ListNode(3) ;
        ListNode node4 = new ListNode(4 , node3) ;
        ListNode node2 = new ListNode(2 , node4) ;

        ListNode node_4 = new ListNode(4) ;
        ListNode node6 = new ListNode(6 , node_4) ;
        ListNode node5 = new ListNode(5 , node6) ;

        ListNode res = obj.addTwoNumbers(node2 , node5) ;
        System.out.println(res.val);
    }
}
