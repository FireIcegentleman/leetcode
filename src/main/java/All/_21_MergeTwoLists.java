package All;

import SwordOffer._21_AdjustArray;

/**
 * 2021/10/22
 *
 * 合并两个有序链表
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * */
public class _21_MergeTwoLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2 ;
        }
        if (l2 == null){
            return l1 ;
        }

        ListNode dummy = new ListNode(0) ;
        ListNode p;
        if (l1.val <= l2.val){
            dummy.next = l1 ;
            p = dummy.next ;
            l1 = l1.next ;
        }else{
            dummy.next = l2 ;
            p = dummy.next ;
            l2 = l2.next ;
        }

        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                p.next = l1 ;
                l1 = l1.next ;
                p = p.next ;
            }else{
                p.next = l2 ;
                l2 = l2.next ;
                p = p.next ;
            }
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
        _21_MergeTwoLists obj = new _21_MergeTwoLists() ;
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
