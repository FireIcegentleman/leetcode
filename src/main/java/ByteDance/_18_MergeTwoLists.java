package ByteDance;

import java.util.List;

/**
 * 2021/11/2
 *
 * 合并两个有序链表
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * */
public class _18_MergeTwoLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0) ;
        ListNode p = dummy ;

        if (l1 == null){
            return l2 ;
        }
        if (l2 == null){
            return l1 ;
        }

        if (l1.val <= l2.val){
            p.next = l1 ;
            l1 = l1.next ;
        }else {
            p.next = l2;
            l2 = l2.next ;
        }
        p = p.next ;

        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                p.next = l1 ;
                l1 = l1.next ;
            }else{
                p.next = l2 ;
                l2 = l2.next ;
            }
            p = p.next ;
        }

        while (l1 != null){
            p.next = l1 ;
            l1 = l1.next ;
            p = p.next ;
        }

        while (l2 != null){
            p.next = l2 ;
            l2 = l2.next ;
            p = p.next ;
        }

        return dummy.next ;
    }
    public static void main(String[] args) {
        _18_MergeTwoLists obj = new _18_MergeTwoLists() ;
        ListNode node14 = new ListNode(4) ;
        ListNode node12 = new ListNode(2 , node14) ;
        ListNode node11 = new ListNode(1 , node12) ;


        ListNode node24 = new ListNode(4) ;
        ListNode node23 = new ListNode(3 , node24) ;
        ListNode node21 = new ListNode(1 , node23) ;

        ListNode res = obj.mergeTwoLists(node11 , node21) ;
        System.out.println(res.val);
    }
}
