package ByteDance;
/**
 * 2021/11/2
 *
 * 两数相加
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * */
public class _20_AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

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
            ListNode tmp = new ListNode((p.val + q.val + carry) % 10) ;
            carry = (p.val + q.val + carry) / 10 ;
            p = p.next ;
            q = q.next ;
            cur.next = tmp ;
            cur = cur.next ;
        }

        while (p != null){
            ListNode tmp = new ListNode((p.val + carry) % 10) ;
            carry = (p.val + carry) / 10 ;
            p = p.next ;
            cur.next = tmp ;
            cur = cur.next ;
        }

        while (q != null){
            ListNode tmp = new ListNode((q.val + carry) % 10) ;
            carry = (q.val + carry) / 10 ;
            q = q.next ;
            cur.next = tmp ;
            cur = cur.next ;
        }

        if (carry == 1){
            ListNode tmp = new ListNode(1) ;
            cur.next = tmp ;
            cur = cur.next ;
        }

        return dummy.next ;
    }

    public static void main(String[] args) {
        _20_AddTwoNumbers obj = new _20_AddTwoNumbers() ;
        ListNode node13 = new ListNode(3) ;
        ListNode node14 = new ListNode(4 , node13) ;
        ListNode node12 = new ListNode(2 , node14) ;

        ListNode node24 = new ListNode(4) ;
        ListNode node26 = new ListNode(6 , node24) ;
        ListNode node25 = new ListNode(5,  node26) ;

        ListNode res = obj.addTwoNumbers(node12 , node25) ;

        System.out.println(res.val);
    }
}
